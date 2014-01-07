package com.kharevich.pricetools.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kharevich.pricetools.logic.ProductToCategory;
import com.kharevich.pricetools.logic.dao.ProductToCategoryDAO;

@Service("productToCategoryService")
public class ProductToCategoryServiceImpl implements ProductToCategoryService {

	@Autowired
	private ProductToCategoryDAO dao;
	
	@Override
	@Transactional
	public void addProductToCategory(ProductToCategory productToCategory) {
		// TODO Auto-generated method stub
		dao.addProductToCategory(productToCategory);
	}

}
