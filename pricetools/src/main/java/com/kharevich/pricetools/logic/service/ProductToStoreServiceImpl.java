package com.kharevich.pricetools.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kharevich.pricetools.logic.dao.ProductToStoreDAO;

@Repository("productToStore")
public class ProductToStoreServiceImpl implements ProductToStoreService{
	
	@Autowired
	ProductToStoreDAO dao;

	@Override
	public void addProductToStore(ProductToStoreService productToStore) {
		// TODO Auto-generated method stub
		dao.addProductToStore(productToStore);
	}

}
