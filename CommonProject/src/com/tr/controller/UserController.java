package com.tr.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tr.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userservice;
//TODO To lower
	@RequestMapping(value = "UsersLogin", method = RequestMethod.POST)
	public String usersLogin(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		return userservice.usersLogin(request, response);

	}

	@RequestMapping(value = "UsersLogin", method = RequestMethod.GET)
	public String redirecting(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		return "index";

	}

	@RequestMapping(value = "GoogleLogin", method = RequestMethod.GET)
	public String googleloginflow(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		return userservice.googleloginflow(request, response);

	}

	@RequestMapping(value = "ProfilePic", method = RequestMethod.GET)
	public String ShowProfilePic(Model model, HttpServletRequest request,
			HttpServletResponse response) throws FileNotFoundException {
		return userservice.ShowProfilePic(model, request, response);
	}

	@RequestMapping(value = "ManageUser", method = RequestMethod.POST)
	public String ManUser(HttpServletRequest request,

	HttpServletResponse response) throws IOException {

		return userservice.ManUser(request, response);

	}

	@RequestMapping(value = "Logout", method = RequestMethod.GET)
	public String logOut(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		return userservice.logOut(request, response);
	}

}
