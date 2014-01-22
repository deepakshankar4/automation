package com.tr.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tr.dao.CategoryDao;
import com.tr.model.Category;

@Repository
public class CategoryDaoImpl  implements CategoryDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getCategory(String catname) {

		

		return (List<Category>) sessionFactory.getCurrentSession()
				.createCriteria(Category.class)
				.add(Restrictions.eq("categoryName", catname)).list();

	}

	@Override
	public String addCategory(String catname) {

		try {

			Category category = new Category();
			category.setCategoryId(category.hashCode());
			category.setCategoryName(catname);
			sessionFactory.getCurrentSession().save(category);

			return "pubwel";

		}

		finally {

		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getCategory() {
		// TODO Auto-generated method stub
		return (List<Category>) sessionFactory.getCurrentSession()
				.createCriteria(Category.class).list();
	}
}
