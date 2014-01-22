package com.tr.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tr.dao.CommonDao;
import com.tr.model.Common;
import com.tr.service.CommonService;

@Service("commonService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CommonServiceImpl implements CommonService {

	@Autowired
	private CommonDao commonDao;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addUsers(Common common) {
		commonDao.addUsers(common);
	}
}
