package com.kharevich.pricetools.logic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_to_store")
public class ProductToStore extends Bean {

	private ProductToStore() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name = "product_id")
	private long product_id;

	@Column(name = "store_id")
	private long store_id;

	public long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}

	public long getStore_id() {
		return store_id;
	}

	public void setStore_id(long store_id) {
		this.store_id = store_id;
	}
}
