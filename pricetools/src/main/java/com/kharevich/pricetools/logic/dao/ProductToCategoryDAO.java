package com.kharevich.pricetools.logic.dao;

import org.hibernate.SessionFactory;

import com.kharevich.pricetools.logic.ProductToCategory;

public interface ProductToCategoryDAO {

	public void addProductToCategory(ProductToCategory productToCategory);

	public SessionFactory getSessionFactory();

	public void setSessionFactory(SessionFactory sessionFactory);

}
