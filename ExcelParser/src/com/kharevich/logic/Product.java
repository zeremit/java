package com.kharevich.logic;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "product")
public class Product {
	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long product_id;

	@Column(name = "model", nullable = false, length = 64)
	private String model;

	@Column(name = "sku", nullable = false, length = 64)
	private String sku;

	@Column(name = "code", nullable = true)
	private int code;

	@Column(name = "okdp", nullable = true)
	private int okdp;

	@Column(name = "upc", nullable = false, length = 12)
	private String upc;

	@Column(name = "ean", nullable = false, length = 14)
	private String ean;

	@Column(name = "jan", nullable = false, length = 13)
	private String jan;

	@Column(name = "isbn", nullable = false, length = 13)
	private String isbn;

	@Column(name = "mpn", nullable = false, length = 64)
	private String mpn;

	@Column(name = "location", nullable = false, length = 128)
	private String location;

	@Column(name = "quantity", nullable = true, columnDefinition = "int(4) default 0")
	private int quantity;

	@Column(name = "stock_status_id", nullable = false)
	private int stock_status_id = 0;

	@Column(name = "image", nullable = true, length = 255)
	private String image;

	@Column(name = "manufacturer_id", nullable = false)
	private int manufacturer_id = 0;

	@Column(name = "shipping", columnDefinition = "TINYINT")
	private int shipping;

	@Column(name = "price", nullable = false)
	private BigDecimal price = BigDecimal.ZERO;

	@Column(name = "points", nullable = true, columnDefinition = "int(8) default 0")
	private int points;

	@Column(name = "tax_class_id", nullable = false)
	private int tax_class_id = 0;

	@Column(name = "date_avalable", nullable = false)
	private Date date_avalable;

	@Column(name = "weight", nullable = false)
	private BigDecimal weight = BigDecimal.ZERO;

	@Column(name = "weight_class_id", nullable = false)
	private int weight_class_id;

	@Column(name = "length", nullable = false)
	private BigDecimal length = BigDecimal.ZERO;

	@Column(name = "width", nullable = false)
	private BigDecimal width = BigDecimal.ZERO;

	@Column(name = "height", nullable = false)
	private BigDecimal height = BigDecimal.ZERO;

	@Column(name = "length_class_id", nullable = false)
	private int length_class_id;

	@Column(name = "subtract", columnDefinition = "TINYINT")
	private int subtract = 1;

	@Column(name = "minimum", nullable = false)
	private int minimum = 1;

	@Column(name = "sort_order", nullable = false)
	private int sort_order = 0;

	@Column(name = "status", columnDefinition = "TINYINT")
	private int status = 0;

	@Column(name = "date_added", nullable = false)
	private Date date_added;

	@Column(name = "date_modified", nullable = false)
	private Date date_modified;

	@Column(name = "viewed", nullable = false)
	private int viewed = 0;
}
