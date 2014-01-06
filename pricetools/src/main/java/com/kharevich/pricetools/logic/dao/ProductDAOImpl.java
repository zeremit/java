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
		List<Product> result = (List<Product>) sessionFactory.getCurrentSession()
				.createCriteria(Product.class)
				.add(Restrictions.eq("partner_product_id", id)).list();
		return result.get(0);
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
