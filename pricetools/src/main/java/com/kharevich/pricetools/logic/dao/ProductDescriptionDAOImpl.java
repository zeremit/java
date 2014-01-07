package com.kharevich.pricetools.logic.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kharevich.pricetools.logic.ProductDescription;

@Repository("productDescriptionDao")
public class ProductDescriptionDAOImpl implements ProductDescriptionDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void addProductDescription(ProductDescription productDescription) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(productDescription);
	}

	@Override
	public SessionFactory getSessionFactory() {
		// TODO Auto-generated method stub
		return sessionFactory;
	}

	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		// TODO Auto-generated method stub
		this.sessionFactory = sessionFactory;
	}

}
