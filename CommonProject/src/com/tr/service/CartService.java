package com.tr.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CartService {
	
	public String addToCart(HttpServletRequest request,
			HttpServletResponse response) throws IOException;
	
	public String viewCart(HttpServletRequest request,
			HttpServletResponse response) throws IOException;
	

}
