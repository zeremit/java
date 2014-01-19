package com.kharevich.pricetools.logic.service;

import com.kharevich.pricetools.logic.Product;

public interface ProductService {
	
	public void addProduct(Product product);

	public Product getByPartnerId(String string);
	
	public void updateProduct(Product product);
}
