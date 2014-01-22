package com.tr.serviceimpl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.tr.dao.CategoryDao;
import com.tr.model.Category;
import com.tr.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categorydao;

	@Override
	public String addGenre(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		String genre = request.getParameter("genre");
		return categorydao.addCategory(genre);
	}

	@Override
	public List<Category> listCategory(Model model, HttpServletRequest request,
			HttpServletResponse response) {

		List<Category> catlist = categorydao.getCategory();

		return catlist;
	}

}
