package com.tr.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tr.dao.PublisherDao;
import com.tr.model.Publisher;

@Repository
public class PublisherDaoImpl  implements PublisherDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Publisher> Pub_login_dao(String publishername, String pass) {

		return (List<Publisher>) sessionFactory.getCurrentSession()
				.createCriteria(Publisher.class)
				.add(Restrictions.eq("publisherName", publishername))
				.add(Restrictions.eq("password", pass)).list();

	}

	public Integer regNewPub(String pn, String on, String pww)
			throws HibernateException {

		int PID;
		try {

			Publisher publisher = new Publisher();

			publisher.setPid(publisher.hashCode());
			publisher.setPublisherName(pn);
			publisher.setOwnerName(on);
			publisher.setPassword(pww);

			PID = (Integer) sessionFactory.getCurrentSession().save(publisher);

		} finally {

		}
		return PID;

	}

	@SuppressWarnings("unchecked")
	public List<Publisher> Pub_list(String pubName) {

		return (List<Publisher>) sessionFactory.getCurrentSession()
				.createCriteria(Publisher.class)
				.add(Restrictions.eq("publisherName", pubName)).list();

	}

}
