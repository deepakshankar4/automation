package com.tr.serviceimpl;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tr.dao.CartDao;
import com.tr.dao.InventoryDao;
import com.tr.dao.UserDao;
import com.tr.model.Cart;
import com.tr.model.UserInfo;
import com.tr.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private InventoryDao inventorydao;

	@Autowired
	private UserDao userdao;

	@Autowired
	private CartDao cartdao;

	@Override
	public String addToCart(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		// PrintWriter out = response.getWriter();
		// SessionFactory factory;
		HttpSession hsession = request.getSession(false);
		String orderBy = (String) hsession.getAttribute("user");

		Double ISBN = Double.parseDouble(request.getParameter("bookisbn"));

		boolean added = cartdao.add_to_cart(orderBy, ISBN);

		if (added) {

			request.setAttribute("book", inventorydao.listInven(ISBN));

			return viewCart(request, response);

		} else {
			return "login";

		}

	}

	@Override
	public String viewCart(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		int cart_usr_id = 0;

		String orderBy = null;
		HttpSession hsession = request.getSession(false);
		try {
			orderBy = (String) hsession.getAttribute("user");
		} catch (NullPointerException ex) {

			return "login";

		}
		if (orderBy != null) {

			try {

				List<UserInfo> cartusr = userdao.fetchUsers(orderBy);
				Iterator<UserInfo> user_of_cart = cartusr.iterator();
				if (user_of_cart.hasNext()) {

					UserInfo forId = user_of_cart.next();

					cart_usr_id = forId.getUser_identity();

				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}

			try {

				List<Cart> lis = cartdao.listCart(cart_usr_id);

				request.setAttribute("cartitems", lis);

				return "viewcart";

			} catch (HibernateException ex) {
				ex.printStackTrace();
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {

			}

			return null;
		} else {
			return "login";
		}

	}

}
