package com.tr.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.tr.model.Publisher;

@Transactional
public interface PublisherDao {

	public List<Publisher> Pub_login_dao(String publishername, String pass);

	public Integer regNewPub(String pn, String on, String pww);

	public List<Publisher> Pub_list(String pubName);

}
