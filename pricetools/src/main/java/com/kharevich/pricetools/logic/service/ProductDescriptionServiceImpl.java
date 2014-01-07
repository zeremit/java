package com.kharevich.pricetools.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kharevich.pricetools.logic.ProductDescription;
import com.kharevich.pricetools.logic.dao.ProductDescriptionDAO;

@Service("productDescriptionService")
public class ProductDescriptionServiceImpl implements ProductDescriptionService {
	
	@Autowired
	private ProductDescriptionDAO dao;

	@Override
	@Transactional
	public void addProductDescription(ProductDescription productDescription) {
		// TODO Auto-generated method stub
		dao.addProductDescription(productDescription);
	}

}
