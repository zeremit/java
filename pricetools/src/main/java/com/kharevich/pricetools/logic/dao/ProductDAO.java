package com.kharevich.pricetools.logic.dao;

import org.hibernate.SessionFactory;

import com.kharevich.pricetools.logic.Product;

public interface ProductDAO {

	public void addProduct(Product product);
	
	public Product getBySkuOrPartnerId(String sku, String partnerId);
	
	public Product getBySku(String id);

	public Product getByPartnerId(String id);

	public void updateProduct(Product product);

	public SessionFactory getSessionFactory();

	public void setSessionFactory(SessionFactory sessionFactory);

	public Product getByCode(String code);

}
