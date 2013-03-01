package com.kharevich.logic;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
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

//	@Column(name = "code", nullable = true)
//	private int code;
//
//	@Column(name = "okdp", nullable = true)
//	private int okdp;

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

	@Column(name = "date_available", nullable = false)
	private Date date_available;

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

	public long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

//	public int getCode() {
//		return code;
//	}
//
//	public void setCode(int code) {
//		this.code = code;
//	}
//
//	public int getOkdp() {
//		return okdp;
//	}
//
//	public void setOkdp(int okdp) {
//		this.okdp = okdp;
//	}

	public String getUpc() {
		return upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}

	public String getEan() {
		return ean;
	}

	public void setEan(String ean) {
		this.ean = ean;
	}

	public String getJan() {
		return jan;
	}

	public void setJan(String jan) {
		this.jan = jan;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getMpn() {
		return mpn;
	}

	public void setMpn(String mpn) {
		this.mpn = mpn;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getStock_status_id() {
		return stock_status_id;
	}

	public void setStock_status_id(int stock_status_id) {
		this.stock_status_id = stock_status_id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getManufacturer_id() {
		return manufacturer_id;
	}

	public void setManufacturer_id(int manufacturer_id) {
		this.manufacturer_id = manufacturer_id;
	}

	public int getShipping() {
		return shipping;
	}

	public void setShipping(int shipping) {
		this.shipping = shipping;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getTax_class_id() {
		return tax_class_id;
	}

	public void setTax_class_id(int tax_class_id) {
		this.tax_class_id = tax_class_id;
	}

	public Date getDate_avalable() {
		return date_available;
	}

	public void setDate_avalable(Date date_avalable) {
		this.date_available = date_avalable;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public int getWeight_class_id() {
		return weight_class_id;
	}

	public void setWeight_class_id(int weight_class_id) {
		this.weight_class_id = weight_class_id;
	}

	public BigDecimal getLength() {
		return length;
	}

	public void setLength(BigDecimal length) {
		this.length = length;
	}

	public BigDecimal getWidth() {
		return width;
	}

	public void setWidth(BigDecimal width) {
		this.width = width;
	}

	public BigDecimal getHeight() {
		return height;
	}

	public void setHeight(BigDecimal height) {
		this.height = height;
	}

	public int getLength_class_id() {
		return length_class_id;
	}

	public void setLength_class_id(int length_class_id) {
		this.length_class_id = length_class_id;
	}

	public int getSubtract() {
		return subtract;
	}

	public void setSubtract(int subtract) {
		this.subtract = subtract;
	}

	public int getMinimum() {
		return minimum;
	}

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}

	public int getSort_order() {
		return sort_order;
	}

	public void setSort_order(int sort_order) {
		this.sort_order = sort_order;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getDate_added() {
		return date_added;
	}

	public void setDate_added(Date date_added) {
		this.date_added = date_added;
	}

	public Date getDate_modified() {
		return date_modified;
	}

	public void setDate_modified(Date date_modified) {
		this.date_modified = date_modified;
	}

	public int getViewed() {
		return viewed;
	}

	public void setViewed(int viewed) {
		this.viewed = viewed;
	}
}
