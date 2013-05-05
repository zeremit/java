package com.kharevich.pricetools.service;

import com.kharevich.pricetools.logic.Product;

public interface ProductService {
	
	public void addProduct(Product product);
	
	public Product getProduct(long id);

}
