package com.kharevich.pricetools.logic.dao;

import org.hibernate.SessionFactory;

import com.kharevich.pricetools.logic.ProductDescription;

public interface ProductDescriptionDAO {

	public void addProductDescription(ProductDescription productDescription);

	public SessionFactory getSessionFactory();

	public void setSessionFactory(SessionFactory sessionFactory);

}
