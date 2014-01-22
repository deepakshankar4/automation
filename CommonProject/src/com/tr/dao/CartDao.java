package com.tr.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.tr.model.Cart;

@Transactional
public interface CartDao {
	// TODO Always keep method names in CamelCase. Change list_cart() to
	// listCart()
	public List<Cart> list_cart(int c_user, Double _isbn);

	// TODO dont start variable names with _ char. change _user to user
	public boolean add_to_cart(String _user, Double _isbn);

	public List<Cart> listCart(int cuid);

	public void update_cart();

}
