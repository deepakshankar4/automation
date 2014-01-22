package com.tr.daoimpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tr.service.InventoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/WebContent/WEB_INF/spring-servlet.xml")
public class CommentBoxDaoSuccessTest {
	
	@Autowired
	private InventoryService inventoryService;
	
	@Test
	public void viewCommentsSuccessTest(){
		
	}

}
