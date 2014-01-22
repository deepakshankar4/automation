package com.tr.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import com.tr.model.Category;

public interface CategoryService {
	
	public String addGenre(Model model, HttpServletRequest request,
			HttpServletResponse response);
	
	public List<Category> listCategory(Model model, HttpServletRequest request,
			HttpServletResponse response);

}
