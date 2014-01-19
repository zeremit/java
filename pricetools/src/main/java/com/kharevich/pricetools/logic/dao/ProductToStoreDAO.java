package com.kharevich.pricetools.logic.dao;

import org.hibernate.SessionFactory;

import com.kharevich.pricetools.logic.ProductToStore;

public interface ProductToStoreDAO {
	
	public void addProductToStore(ProductToStore productToStore);

	public SessionFactory getSessionFactory();

	public void setSessionFactory(SessionFactory sessionFactory);

}
