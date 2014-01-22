package com.tr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "CP_CATEGORY")
public class Category {

	private Integer categoryId;
	private String categoryName;

	@Id
	@GenericGenerator(name = "CATEGORY_ID", strategy = "increment")
	@GeneratedValue(generator = "CATEGORY_ID")
	@Column(name = "CATEGORY_ID")
	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	@Column(name = "CATEGORY_NAME")
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
