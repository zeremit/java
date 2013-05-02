package com.kharevich.pricetools.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kharevich.pricetools.logic.Product;
import com.kharevich.pricetools.logic.dao.ProductDAO;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;
	
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		productDAO.addProduct(product);

	}

}
