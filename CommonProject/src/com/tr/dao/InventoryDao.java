package com.tr.dao;

import java.io.File;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.tr.model.Category;
import com.tr.model.Inventory;
import com.tr.model.Publisher;

@Transactional
public interface InventoryDao {

	public List<Inventory> listInven(String bookname);

	public List<Inventory> listInven(double ISBN);

	public double addINV(String bookname, String authorname,
			Publisher publishername, Category genre, double iSBN, float price,
			String desc, File file_cover);

	public List<Inventory> search_inven(String searchstr);

	public List<Inventory> fetchBooks();

}
