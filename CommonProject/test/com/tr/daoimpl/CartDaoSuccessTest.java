package com.tr.daoimpl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tr.dao.CartDao;
import com.tr.model.Cart;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/WebContent/WEB_INF/spring-servlet.xml")
public class CartDaoSuccessTest {

	@Autowired
	private CartDao cartDao;

	@Test
	public void testViewCart() {
		// Double _isbn;
		List<Cart> res = cartDao.list_cart(1, null);
		for (Cart cart : res) {
			System.out.println(cart);
		}
	}

}
