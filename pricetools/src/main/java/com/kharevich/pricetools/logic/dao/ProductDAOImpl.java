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
	
	@Transactional
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(product);
	}

	@Transactional
	public Product getByPartnerId(String id) {
		sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Product> result = (List<Product>) sessionFactory.getCurrentSession()
				.createCriteria(Product.class).add(Restrictions.eq("partner_product_id",Long.parseLong(id))).list();
		if (result.size()>0)
			return result.get(0);
		return null;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(product);
	}

}
