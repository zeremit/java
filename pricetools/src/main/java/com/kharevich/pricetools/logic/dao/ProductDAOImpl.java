package com.kharevich.pricetools.logic.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kharevich.pricetools.logic.Product;

@Repository("productDao")
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(product);
	}

	@Transactional
	public Product getProduct(long id) {
		sessionFactory.getCurrentSession();
		Product result = (Product) sessionFactory.getCurrentSession()
				.get(Product.class, id);
		return result;
	}

	@Autowired
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
