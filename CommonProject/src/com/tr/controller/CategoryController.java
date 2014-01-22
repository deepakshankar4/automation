package com.tr.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tr.model.Category;
import com.tr.service.CategoryService;

@Controller
public class CategoryController {

	@Autowired
	private CategoryService categoryservice;
//TODO: change to add-category
	@RequestMapping(value = "addcategory", method = RequestMethod.POST)
	public String addGenre(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		return categoryservice.addGenre(model, request, response);
	}

	@RequestMapping(value = "inventory", method = RequestMethod.GET)
	public String listCategory(Model model, HttpServletRequest request,
			HttpServletResponse response) {

		List<Category> catlist = categoryservice.listCategory(model, request,
				response);
		request.setAttribute("catlist", catlist);
		return "inventory";
	}

}
