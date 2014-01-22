package com.tr.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tr.service.CartService;

@Controller
public class CartManager {

	private static final Logger LOGGER = Logger.getLogger(CartManager.class);

	@Autowired
	private CartService cartservice;

	// TODO: Change AddToCart to add-to-cart. Keep url path and params in lower
	// case and separated by "-" char
	@RequestMapping(value = "AddToCart", method = RequestMethod.POST)
	public String addToCart(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		// LOGGER.debug(");
		return cartservice.addToCart(request, response);
	}

	@RequestMapping(value = "ViewCart", method = RequestMethod.POST)
	public String viewCart(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		return cartservice.viewCart(request, response);
	}
}
