package com.kharevich.pricetools.logic;

import java.lang.reflect.Field;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_description")
public class ProductDescription extends Bean{

	@Id
	@Column(name = "product_id")
	private long product_id;

	@Column(name = "language_id")
	private long language_id = 2;

	@Column(name = "name", nullable = false, length = 255)
	private String name;

	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "meta_description", nullable = false, length = 255)
	private String meta_description;

	@Column(name = "meta_keyword", nullable = false, length = 255)
	private String meta_keyword;

	@Column(name = "tag", nullable = false)
	private String tag;

	public long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}

	public long getLanguage_id() {
		return language_id;
	}

	public void setLanguage_id(long language_id) {
		this.language_id = language_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMeta_description() {
		return meta_description;
	}

	public void setMeta_description(String meta_description) {
		this.meta_description = meta_description;
	}

	public String getMeta_keyword() {
		return meta_keyword;
	}

	public void setMeta_keyword(String meta_keyword) {
		this.meta_keyword = meta_keyword;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String toParams()  {
		String prefix = "<property name=\"";
		String middle = "\" value=\"";
		String postfix = "\"/>";
		Field[] field = this.getClass().getDeclaredFields();
		StringBuilder sb = new StringBuilder();
		for (Field t : field) {
			try {
				sb.append(prefix).append(t.getName()).append(middle)
						.append(t.get(this)).append(postfix).append("\n");
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
			}
		}
		return sb.toString();
	}

}
