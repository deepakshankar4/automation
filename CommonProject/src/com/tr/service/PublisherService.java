package com.tr.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface PublisherService {

	public String PubLogin(HttpServletRequest request,
			HttpServletResponse response) throws IOException;

	public String PubReg(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException;

	public String pubLogOut(HttpServletRequest request,
			HttpServletResponse response) throws IOException;

}
