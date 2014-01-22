package com.tr.daoimpl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tr.dao.CommentBoxDao;
import com.tr.dao.InventoryDao;
import com.tr.dao.UserDao;
import com.tr.model.CommentBox;
import com.tr.model.Inventory;
import com.tr.model.UserInfo;

@Repository
public class CommentBoxDaoImpl   implements CommentBoxDao {

	@Autowired
	private UserDao userdao;

	@Autowired
	private InventoryDao inventorydao;

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Inventory addComment(String bookname, String user, String comment,
			Inventory booktocomment, UserInfo commenter) {

		try {

			try {

				List<Inventory> book = inventorydao.listInven(bookname);
				Iterator<Inventory> bookit = book.iterator();
				if (bookit.hasNext()) {

					booktocomment = bookit.next();

				}
			} catch (HibernateException ex) {
				ex.printStackTrace();
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			try {

				List<UserInfo> usr = userdao.fetchUsers(user);
				Iterator<UserInfo> usrit = usr.iterator();
				if (usrit.hasNext()) {

					commenter = usrit.next();

				}
			} catch (HibernateException ex) {
				ex.printStackTrace();
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			CommentBox commentbox = new CommentBox();

			commentbox.setCommentBoxId(commentbox.hashCode());
			commentbox.setCommenter_comment(comment);
			commentbox.setBook(booktocomment);
			commentbox.setCommenter(commenter);
			sessionFactory.getCurrentSession().save(commentbox);

			return commentbox.getBook();

		} finally {
			// inventorydao.destroy();

		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CommentBox> viewcomments(double isbn) {

		try {
			List<Inventory> books = inventorydao.listInven(isbn);
			Iterator<Inventory> bookit = books.iterator();
			Inventory book = null;
			if (bookit.hasNext()) {
				book = bookit.next();

			}

			return (List<CommentBox>) sessionFactory.getCurrentSession()
					.createCriteria(CommentBox.class)
					.add(Restrictions.eq("book", book)).list();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;

	}
}
