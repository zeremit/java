package com.kharevich.pricetools.logic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_to_category")
public class ProductToCategory extends Bean {

	private ProductToCategory() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name = "product_id")
	private long product_id;

	@Column(name = "category_id")
	private long category_id;

	public long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}

	public long getCategory_id() {
		return category_id;
	}

	public void setCategory_id(long category_id) {
		this.category_id = category_id;
	}

}
