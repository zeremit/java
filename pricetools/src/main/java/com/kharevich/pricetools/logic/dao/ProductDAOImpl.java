package com.kharevich.pricetools.logic.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kharevich.pricetools.logic.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
    private SessionFactory sessionFactory;
	
	
	public void addProduct(Product product) {
		// TODO Auto-generated method stub

	}

}
