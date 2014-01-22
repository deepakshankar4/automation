package com.tr.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tr.model.Inventory;
import com.tr.service.InventoryService;

@Controller
// You can keep the class name as ECommerceController. 4 more char wont hurt a
// lot
public class ECOMMController {

	@Autowired
	private InventoryService inventoryservice;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request,
			HttpServletResponse response, Model model) {

		List<Inventory> books = inventoryservice.listBooks();

		request.setAttribute("books", books);
		return "ecomm_index";

	}

	@RequestMapping(value = "/manacc", method = RequestMethod.GET)
	public String manacc(Model model) {

		return "manacc";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Model model) {

		return "register";
	}

	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public String category(Model model) {

		return "addCategory";
	}

	@RequestMapping(value = "/publisherlogin", method = RequestMethod.GET)
	public String publisherlogin(Model model) {

		return "publisherlogin";
	}

	@RequestMapping(value = "/pubregister", method = RequestMethod.GET)
	public String publisherreg(Model model) {

		return "pubregister";
	}

	@RequestMapping(value = "/pubwel", method = RequestMethod.GET)
	public String pubwel(Model model) {

		return "pubwel";
	}

	@RequestMapping(value = "/ecomm_index", method = RequestMethod.GET)
	public String index(HttpServletRequest request,
			HttpServletResponse response, Model model) {

		List<Inventory> books = inventoryservice.listBooks();

		request.setAttribute("books", books);

		return "ecomm_index";
	}

	@RequestMapping(value = "/errorpage", method = RequestMethod.GET)
	public String errorPage(Model model) {

		return "errorpage";
	}

	@RequestMapping(value = "/ecomm_usr_login", method = RequestMethod.GET)
	public String login(Model model) {

		return "ecomm_usr_login";
	}

	@RequestMapping(value = "/history", method = RequestMethod.GET)
	public String history(Model model) {

		return "history";
	}

	// TODO change to lower. Where is the "/" ??
	@RequestMapping(value = "/ecomm_welcome", method = RequestMethod.GET)
	public String welcome(Model model) {

		return "ecomm_welcome";
	}

	// TODO change to lower.
	@RequestMapping(value = "/searchResult", method = RequestMethod.GET)
	public String SearchResult(Model model) {

		return "searchResult";
	}

	@RequestMapping(value = "/bookredirect", method = RequestMethod.GET)
	public String redirectingpage(Model model) {

		return "RedirectBooksdesc";
	}

	@RequestMapping(value = "/viewcart", method = RequestMethod.GET)
	public String viewcart(Model model) {

		return "viewcart";
	}

}
