package com.tr.daoimpl;

import java.io.File;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tr.dao.InventoryDao;
import com.tr.model.Category;
import com.tr.model.Inventory;
import com.tr.model.Publisher;

@Repository
public class InventoryDaoImpl  implements InventoryDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Inventory> listInven(String bookname) {

		return (List<Inventory>) sessionFactory.getCurrentSession()
				.createCriteria(Inventory.class)
				.add(Restrictions.eq("bookName", bookname)).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Inventory> listInven(double ISBN) {

		return (List<Inventory>) sessionFactory.getCurrentSession()
				.createCriteria(Inventory.class)
				.add(Restrictions.eq("isbn", ISBN)).list();
	}

	@Override
	public double addINV(String bookname, String authorname,
			Publisher publishername, Category genre, double iSBN, float price,
			String desc, File file_cover) throws HibernateException,
			ConstraintViolationException {

		double IID;
		try {

			Inventory inven = new Inventory();

			inven.setAuthorName(authorname.toUpperCase());
			inven.setBookName(bookname.toUpperCase());
			// inven.setGenre(genre.toUpperCase());
			inven.setGenre(genre);
			inven.setIsbn(iSBN);
			inven.setPrice(price);
			inven.setPublisher(publishername);
			inven.setDescription(desc);
			// System.out.println(file_cover.getAbsolutePath());
			inven.setCoverImage(file_cover);

			IID = (Double) sessionFactory.getCurrentSession().save(inven);

		} finally {

		}

		return IID;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Inventory> search_inven(String searchstr) {

		return (List<Inventory>) sessionFactory.getCurrentSession()
				.createCriteria(Inventory.class)
				.add(Restrictions.ilike("bookName", "%" + searchstr + "%"))
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Inventory> fetchBooks() {
		return (List<Inventory>) sessionFactory.getCurrentSession()
				.createCriteria(Inventory.class).list();
	}

}
