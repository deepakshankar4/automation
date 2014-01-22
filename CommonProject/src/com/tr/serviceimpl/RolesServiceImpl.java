package com.tr.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tr.dao.RolesDao;
import com.tr.model.Roles;
import com.tr.service.RolesService;

@Service("rolesService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class RolesServiceImpl implements RolesService {

	@Autowired
	private RolesDao rolesDao;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addRoles(Roles roles) {
		rolesDao.addRoles(roles);
	}

}
