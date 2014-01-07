package com.kharevich.pricetools.logic.dao;

import org.hibernate.SessionFactory;

import com.kharevich.pricetools.logic.Product;

public interface ProductDAO {

	public void addProduct(Product product);

	public Product getById(long id);

	public void updateProduct(Product product);

	public SessionFactory getSessionFactory();

	public void setSessionFactory(SessionFactory sessionFactory);

}
