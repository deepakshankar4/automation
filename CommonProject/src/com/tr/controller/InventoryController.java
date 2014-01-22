package com.tr.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tr.service.InventoryService;

@Controller
public class InventoryController {

	@Autowired
	private InventoryService inventoryservice;
// TODO change to lower and add - instead of camel case
	@RequestMapping(value = "DisplayImage", method = RequestMethod.GET)
	public String displayImage(Model model, HttpServletRequest request,
			HttpServletResponse response) throws FileNotFoundException {

		return inventoryservice.displayImage(model, request, response);

	}

	@RequestMapping(value = "ManageInventory", method = RequestMethod.POST)
	public String ManInv(HttpServletRequest request,

	HttpServletResponse response, Model model) throws IOException {

		return inventoryservice.ManInv(request, response, model);

	}

	@RequestMapping(value = "Search", method = RequestMethod.GET)
	public String Search(HttpServletRequest request,

	HttpServletResponse response) throws IOException {

		return inventoryservice.Search(request, response);

	}

	@RequestMapping(value = "/booksdesc/{inve_id}", method = RequestMethod.GET)
	public String invenbookdesc(@PathVariable(value = "inve_id") String inId,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {

		return inventoryservice.invenbookdesc(inId, request, response, model);
	}

	@RequestMapping(value = "AddComments", method = RequestMethod.POST)
	public String addComments(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		
		String bookname = request.getParameter("bookname");
		HttpSession httpsession = request.getSession(false);
		String user = (String) httpsession.getAttribute("user");
		String comment = request.getParameter("commentbox");

		return inventoryservice.addComments(request,response,model,user,comment,bookname);

	}

}
