package com.kharevich.pricetools.logic.service;

import com.kharevich.pricetools.logic.Product;

public interface ProductService {
	
	public void addProduct(Product product);
	
	public Product getBySkuOrPartnerId(String sku, String partnerId);
	
	public Product getByCode(String code);

	public Product getByPartnerId(String string);
	
	public void updateProduct(Product product);
}
