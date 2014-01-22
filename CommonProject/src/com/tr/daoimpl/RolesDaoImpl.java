package com.tr.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tr.model.Roles;
import com.tr.dao.RolesDao;

@Repository("rolesDao")
public class RolesDaoImpl implements RolesDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void addRoles(Roles roles) {

		sessionFactory.getCurrentSession().saveOrUpdate(roles);
	}

}