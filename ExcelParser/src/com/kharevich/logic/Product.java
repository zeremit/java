package com.kharevich.logic;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="product")
public class Product {
	@Id
	@GeneratedValue
	private long product_id;

}
