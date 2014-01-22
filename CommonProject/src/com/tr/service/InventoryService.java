package com.tr.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import com.tr.model.Inventory;

public interface InventoryService {

	public String displayImage(Model model, HttpServletRequest request,
			HttpServletResponse response) throws FileNotFoundException;

	public String ManInv(HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException;

	public String Search(HttpServletRequest request,
			HttpServletResponse response) throws IOException;

	public String invenbookdesc(String inId, HttpServletRequest request,
			HttpServletResponse response, Model model);

	public String addComments(HttpServletRequest request,
			HttpServletResponse response, Model model, String user,
			String comment, String book);

	public List<Inventory> listBooks();

}
