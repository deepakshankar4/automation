package com.tr.dao;

import org.springframework.transaction.annotation.Transactional;

import com.tr.model.Common;

@Transactional
public interface CommonDao {

	public void addUsers(Common common);

}
