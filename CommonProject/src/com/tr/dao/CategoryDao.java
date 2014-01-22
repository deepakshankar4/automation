package com.tr.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.tr.model.Category;

@Transactional
public interface CategoryDao {

	public List<Category> getCategory(String catname);

	public List<Category> getCategory();

	public String addCategory(String catname);

}
