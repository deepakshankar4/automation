package com.tr.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tr.service.PublisherService;

@Controller
public class PublisherController {
	@Autowired
	private PublisherService publisherservice;
//TODO: To lower
	@RequestMapping(value = "PubLogin", method = RequestMethod.POST)
	public String PubLogin(HttpServletRequest request,

	HttpServletResponse response) throws IOException {

		return publisherservice.PubLogin(request, response);
	}

	@RequestMapping(value = "PublisherRegister", method = RequestMethod.POST)
	public String PubReg(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		return publisherservice.PubReg(request, response);
	}

	@RequestMapping(value = "PubLogout", method = RequestMethod.GET)
	public String pubLogOut(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		return publisherservice.pubLogOut(request, response);
	}

}
