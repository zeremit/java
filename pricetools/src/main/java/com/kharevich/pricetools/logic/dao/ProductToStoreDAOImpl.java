package com.kharevich.pricetools.logic.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kharevich.pricetools.logic.service.ProductToStore;

@Repository("productToStoreDAO")
public class ProductToStoreDAOImpl implements ProductToStoreDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void addProductToStore(ProductToStore productToStore) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(productToStore);
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
