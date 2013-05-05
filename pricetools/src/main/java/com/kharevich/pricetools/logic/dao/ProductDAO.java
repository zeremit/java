package com.kharevich.pricetools.logic.dao;

import com.kharevich.pricetools.logic.Product;

public interface ProductDAO {
	
	public void addProduct(Product product);
	
	public Product getProduct(long id);

}
