package com.tr.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

public interface UserService {

	public String usersLogin(HttpServletRequest request,
			HttpServletResponse response) throws IOException;

	public String googleloginflow(HttpServletRequest request,
			HttpServletResponse response);

	public String ShowProfilePic(Model model, HttpServletRequest request,
			HttpServletResponse response);

	public String ManUser(HttpServletRequest request,
			HttpServletResponse response) throws IOException;

	public String logOut(HttpServletRequest request,
			HttpServletResponse response);

}
