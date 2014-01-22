package com.tr.daoimpl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tr.model.Inventory;
import com.tr.service.InventoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/testcontexts/spring-servlet.xml")
public class InventoryDaoSuccessTest {

	@Autowired
	private InventoryService inventoryService;

	@Test
	public void listBooksTest() {
		List<Inventory> lis = inventoryService.listBooks();
		for (Inventory inventory : lis) {
			System.out.println("book name:: " + inventory.getBookName());
		}
	}

}
