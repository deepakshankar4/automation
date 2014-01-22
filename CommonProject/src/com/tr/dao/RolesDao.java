package com.tr.dao;

import org.springframework.transaction.annotation.Transactional;

import com.tr.model.Roles;

@Transactional
public interface RolesDao {

	public void addRoles(Roles roles);

}
