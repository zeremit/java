package com.kharevich.logic;

import java.math.BigDecimal;

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
	
	@Column(name="price", nullable=false)
	private BigDecimal price = BigDecimal.ZERO;

	@Column(name = "points", nullable = true, columnDefinition = "int(8) default 0")
	private int points;
	19 	tax_class_id 	int(11) 			Нет 	Нет 		Изменить Изменить 	Удалить Удалить 	Показать больше операций Ещё
	20 	date_available 	date 			Нет 	Нет 		Изменить Изменить 	Удалить Удалить 	Показать больше операций Ещё
	21 	weight 	decimal(15,8) 			Нет 	0.00000000 		Изменить Изменить 	Удалить Удалить 	Показать больше операций Ещё
	22 	weight_class_id 	int(11) 			Нет 	0 		Изменить Изменить 	Удалить Удалить 	Показать больше операций Ещё
	23 	length 	decimal(15,8) 			Нет 	0.00000000 		Изменить Изменить 	Удалить Удалить 	Показать больше операций Ещё
	24 	width 	decimal(15,8) 			Нет 	0.00000000 		Изменить Изменить 	Удалить Удалить 	Показать больше операций Ещё
	25 	height 	decimal(15,8) 			Нет 	0.00000000 		Изменить Изменить 	Удалить Удалить 	Показать больше операций Ещё
	26 	length_class_id 	int(11) 			Нет 	0 		Изменить Изменить 	Удалить Удалить 	Показать больше операций Ещё
	27 	subtract 	tinyint(1) 			Нет 	1 		Изменить Изменить 	Удалить Удалить 	Показать больше операций Ещё
	28 	minimum 	int(11) 			Нет 	1 		Изменить Изменить 	Удалить Удалить 	Показать больше операций Ещё
	29 	sort_order 	int(11) 			Нет 	0 		Изменить Изменить 	Удалить Удалить 	Показать больше операций Ещё
	30 	status 	tinyint(1) 			Нет 	0 		Изменить Изменить 	Удалить Удалить 	Показать больше операций Ещё
	31 	date_added 	datetime 			Нет 	0000-00-00 00:00:00 		Изменить Изменить 	Удалить Удалить 	Показать больше операций Ещё
	32 	date_modified 	datetime 			Нет 	0000-00-00 00:00:00 		Изменить Изменить 	Удалить Удалить 	Показать больше операций Ещё
	33 	viewed 	int(5)

}
