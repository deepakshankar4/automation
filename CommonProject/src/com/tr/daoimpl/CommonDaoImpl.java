package com.tr.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tr.dao.CommonDao;
import com.tr.model.Common;

@Repository("commonDao")
public class CommonDaoImpl implements CommonDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void addUsers(Common common) {

		sessionFactory.getCurrentSession().saveOrUpdate(common);
	}

}