package com.kharevich.pricetools.logic.dao;

import org.hibernate.SessionFactory;

import com.kharevich.pricetools.logic.ProductToCategory;
import com.kharevich.pricetools.logic.service.ProductToStoreService;

public interface ProductToStoreDAO {
	
	public void addProductToStore(ProductToStoreService productToStore);

	public SessionFactory getSessionFactory();

	public void setSessionFactory(SessionFactory sessionFactory);

}
