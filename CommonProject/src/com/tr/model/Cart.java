package com.tr.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "CP_CART")
public class Cart {

	private int item_locater;
	private UserInfo cart_user;
	private Inventory inven;
	private int qty;

	@Id
	@GenericGenerator(name = "ITEM_LOCATOR", strategy = "assigned")
	@GeneratedValue(generator = "ITEM_LOCATOR")
	@Column(name = "ITEM_LOCATOR")
	public int getItem_locater() {
		return item_locater;
	}

	public void setItem_locater(int item_locater) {
		this.item_locater = item_locater;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ISBN")
	public Inventory getInven() {
		return inven;
	}

	public void setInven(Inventory inven) {
		this.inven = inven;
	}

	@Column(name = "QTY")
	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_identity")
	public UserInfo getCart_user() {
		return cart_user;
	}

	public void setCart_user(UserInfo cart_user) {
		this.cart_user = cart_user;
	}

}
