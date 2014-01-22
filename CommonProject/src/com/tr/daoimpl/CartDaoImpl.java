package com.tr.daoimpl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tr.dao.CartDao;
import com.tr.dao.InventoryDao;
import com.tr.dao.UserDao;
import com.tr.model.Cart;
import com.tr.model.Inventory;
import com.tr.model.UserInfo;

@Repository
public class CartDaoImpl implements CartDao {

	@Autowired
	private UserDao userdao;

	@Autowired
	private InventoryDao inventorydao;

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Cart> list_cart(int c_user, Double _isbn) {

		List<UserInfo> user = userdao.fetchUsers(c_user);
		List<Inventory> book = inventorydao.listInven(_isbn);

		Iterator<UserInfo> uit = user.iterator();
		Iterator<Inventory> bit = book.iterator();

		UserInfo cartUser = null;
		Inventory cartBook = null;

		if (uit.hasNext()) {
			cartUser = uit.next();
		}

		if (bit.hasNext()) {
			cartBook = bit.next();
		}

		return (List<Cart>) sessionFactory.getCurrentSession()
				.createCriteria(Cart.class)
				.add(Restrictions.eq("inven", cartBook))
				.add(Restrictions.eq("cart_user", cartUser)).list();
	}

	public boolean add_to_cart(String _user, Double _isbn) {

		try {

			List<UserInfo> usrlist = userdao.fetchUsers(_user);
			Iterator<UserInfo> uit = usrlist.iterator();

			UserInfo u = null;

			if (uit.hasNext()) {
				u = uit.next();

				List<Inventory> list = inventorydao.listInven(_isbn);

				Iterator<Inventory> inv_it = list.iterator();

				Cart list_of_items = new Cart();

				List<Cart> chkinveninfo = list_cart(u.getUser_identity(), _isbn);

				if (chkinveninfo.size() == 0) {

					// list_of_items.setInven_info_id(list_of_items.hashCode());
					list_of_items.setQty(1);
					list_of_items.setCart_user(u);
					// list_of_items.setInvenList(list);

					while (inv_it.hasNext()) {

						list_of_items.setInven(inv_it.next());

					}
					// cartt.setCart_items(list_of_items);
					list_of_items.setItem_locater(list_of_items.hashCode());

					// Map<Integer, InvenInfo> resolver = new HashMap<>();
					// resolver.put(cartt.getCart_id(), cartt.getCart_items());

					// System.out.println(cartt.hashCode());

					sessionFactory.getCurrentSession().save(list_of_items);

					return true;

				} else {

					Iterator<Cart> chkinvit = chkinveninfo.iterator();
					if (chkinvit.hasNext()) {
						Cart invif = chkinvit.next();

						invif.setQty(invif.getQty() + 1);
						sessionFactory.getCurrentSession().update(invif);

						return true;

					}

				}

			} else {
				return false;

			}

		} catch (HibernateException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return true;

	}

	public void update_cart() {

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cart> listCart(int cuid) {
		List<UserInfo> user = userdao.fetchUsers(cuid);

		Iterator<UserInfo> uit = user.iterator();

		UserInfo cartUser = null;
		// Inventory cartBook = null;

		if (uit.hasNext()) {
			cartUser = uit.next();
		}

		return (List<Cart>) sessionFactory.getCurrentSession()
				.createCriteria(Cart.class)
				.add(Restrictions.eq("cart_user", cartUser)).list();
	}

}
