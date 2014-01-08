package com.kharevich.pricetools.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kharevich.pricetools.logic.Product;
import com.kharevich.pricetools.logic.dao.ProductDAO;

@Service("productService")
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductDAO dao;

	@Override
	@Transactional
	public Product getById(String id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

	@Override
	@Transactional
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		dao.addProduct(product);
	}

	@Override
	@Transactional
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		dao.updateProduct(product);
		
	}
	
	
}
