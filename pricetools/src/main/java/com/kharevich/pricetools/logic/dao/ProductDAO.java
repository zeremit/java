package com.kharevich.pricetools.logic.dao;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.kharevich.pricetools.logic.Product;

public interface ProductDAO {

	public void addProduct(Product product);

	public Product getProduct(long id);

	public SessionFactory getSessionFactory();

	public void setSessionFactory(SessionFactory sessionFactory);

}
