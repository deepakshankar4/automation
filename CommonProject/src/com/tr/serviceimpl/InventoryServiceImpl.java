package com.tr.serviceimpl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.hibernate.HibernateException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.tr.dao.CategoryDao;
import com.tr.dao.CommentBoxDao;
import com.tr.dao.InventoryDao;
import com.tr.dao.PublisherDao;
import com.tr.model.Category;
import com.tr.model.CommentBox;
import com.tr.model.Inventory;
import com.tr.model.Publisher;
import com.tr.model.UserInfo;
import com.tr.service.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private InventoryDao inventorydao;

	@Autowired
	private CommentBoxDao commentboxdao;

	@Autowired
	private CategoryDao categorydao;

	@Autowired
	private PublisherDao publisherdao;

	@Override
	public String displayImage(Model model, HttpServletRequest request,
			HttpServletResponse response) throws FileNotFoundException {

		String bookname = request.getParameter("bookName");

		try {

			List<Inventory> inven = inventorydao.listInven(bookname);
			Iterator<Inventory> invenit = inven.iterator();

			Inventory booktodesc = null;
			if (invenit.hasNext()) {
				booktodesc = invenit.next();
			}

			File imgeFile = booktodesc.getCoverImage();
			System.out.println(imgeFile.getAbsolutePath());
			FileInputStream fis = new FileInputStream(imgeFile);
			BufferedInputStream bis = new BufferedInputStream(fis);
			response.setContentType("image/jpg");
			BufferedOutputStream output = new BufferedOutputStream(
					response.getOutputStream());
			for (int data; (data = bis.read()) > -1;) {
				output.write(data);
			}

			bis.close();
			fis.close();

		} catch (HibernateException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// InventoryDao.destroy();

		}

		return null;
	}

	@Override
	public String ManInv(HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {

		HttpSession pub_session = request.getSession(false);

		String bookname = null;
		String authorname = null;
		String publishername = (String) pub_session.getAttribute("publisher");
		String _ISBN = null;
		String _genre = null;
		String _price = null;
		String desc = null;
		String fileName = null;
		String file_path = null;
		double ISBN = 0;

		Category genre = null;

		Publisher publication = null;

		// ////*******************************************************************//////
		// //*******************************************************************//////
		// code to insert the image to the model class and persist to
		// database
		// //*******************************************************************//////
		// //*******************************************************************//////

		// boolean isMultipart;
		String filePath = "D:/uploads/";
		int maxFileSize = 1024 * 1024 * 10;
		int maxMemSize = 1024 * 1024 * 10;
		File file = null;

		// isMultipart = ServletFileUpload.isMultipartContent(request);
		java.io.PrintWriter out = response.getWriter();

		DiskFileItemFactory imgfactory = new DiskFileItemFactory();
		// maximum size that will be stored in memory
		imgfactory.setSizeThreshold(maxMemSize);
		// Location to save data that is larger than maxMemSize.
		imgfactory.setRepository(new File("c:\\temp"));

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(imgfactory);
		// maximum file size to be uploaded.
		upload.setSizeMax(maxFileSize);

		try {
			// Parse the request to get file items.

			List<FileItem> fileItems = upload.parseRequest(request);

			// Process the uploaded file items
			Iterator<FileItem> i = fileItems.iterator();

			while (i.hasNext()) {
				FileItem fi = (FileItem) i.next();
				if (!fi.isFormField()) {

					if (fi.getName() != "") {

						fileName = publishername + "_" + fi.getName();

						{

							if (fileName.lastIndexOf("\\") >= 0) {
								file = new File(filePath
										+ fileName.substring(fileName
												.lastIndexOf("\\")));

							} else {
								file = new File(filePath
										+ fileName.substring(fileName
												.lastIndexOf("\\") + 1));

							}
						}

						file_path = file.getAbsolutePath();

						System.out.println(file_path);

						fi.write(file);

						System.out.println("Uploaded Filename: " + fileName);
					}

					else {
						file = new File("D:\\dump\\default.jpg");

					}

				} else {
					switch (fi.getFieldName()) {
					case "bookname":
						bookname = fi.getString();
						break;
					case "authorname":
						authorname = fi.getString();
						break;
					case "isbn":
						_ISBN = fi.getString();
						ISBN = Double.parseDouble(_ISBN);
						break;
					case "genre":
						_genre = fi.getString();
						break;
					case "price":
						_price = fi.getString();
						break;
					case "description":
						desc = fi.getString();
						break;

					}

				}
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}

		float price = (float) Integer.parseInt(_price);

		double IID;
		out = response.getWriter();

		{

			try {

				List<Category> categList = categorydao.getCategory(_genre);
				Iterator<Category> categIt = categList.iterator();
				if (categIt.hasNext()) {
					genre = categIt.next();
				}
				List<Publisher> publisher = publisherdao
						.Pub_list(publishername);
				Iterator<Publisher> pubit = publisher.iterator();
				if (pubit.hasNext()) {
					publication = pubit.next();
				}

				IID = inventorydao.addINV(bookname, authorname, publication,
						genre, ISBN, price, desc, file);

				out.println("inventory added with IID " + IID);
				// out.println(request.getAttribute("publisher"));
			}

			catch (ConstraintViolationException ex) {
				out.println("publisher does not exist!!!");
			} catch (HibernateException ex) {
				ex.printStackTrace();
				out.println("inventory already exists");
			}
		}

		return null;
	}

	@Override
	public String Search(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		String searchstr = request.getParameter("q").toUpperCase();
		PrintWriter out = response.getWriter();

		// out.println(searchstr);
		try {

			List<Inventory> booklist = inventorydao.search_inven(searchstr);
			if (booklist.size() != 0) {

				request.setAttribute("result", booklist);
				return "searchResult";

			}
			// out.println(usenamelist.toString());
			else {
				out.println(booklist.size());
				out.println("no records found!!!");
			}
		} catch (HibernateException ex) {

			ex.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

		}

		return null;
	}

	@Override
	public String invenbookdesc(String inId, HttpServletRequest request,
			HttpServletResponse response, Model model) {

		try {
			System.out.println("the ISBN:  " + inId);

			List<Inventory> inven = inventorydao.listInven(inId);

			Iterator<Inventory> invenit = inven.iterator();
			Inventory booktodesc = null;
			if (invenit.hasNext()) {
				booktodesc = invenit.next();
			}

			model.addAttribute("bookName", booktodesc.getBookName());
			model.addAttribute("bookPrice", booktodesc.getPrice());
			model.addAttribute("bookPub", booktodesc.getPublisher()
					.getPublisherName());
			model.addAttribute("bookISBN", booktodesc.getIsbn());
			model.addAttribute("bookAuthor", booktodesc.getAuthorName());
			model.addAttribute("bookGenre", booktodesc.getGenre()
					.getCategoryName());
			model.addAttribute("bookDesc", booktodesc.getDescription());

			List<CommentBox> comments_on_books = commentboxdao
					.viewcomments(booktodesc.getIsbn());
			request.setAttribute("user_comments", comments_on_books);

		} catch (HibernateException ex) {
			ex.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		}

		return "booksdesc";
	}

	@Override
	public String addComments(HttpServletRequest request,
			HttpServletResponse response, Model model, String user,
			String comment, String book) {

		Inventory booktocomment = null;
		UserInfo commenter = null;

		booktocomment = commentboxdao.addComment(book, user, comment,
				booktocomment, commenter);

		commentboxdao.viewcomments(booktocomment.getIsbn());

		return invenbookdesc(book, request, response, model);
	}

	@Override
	public List<Inventory> listBooks() {
		return inventorydao.fetchBooks();

	}

}
