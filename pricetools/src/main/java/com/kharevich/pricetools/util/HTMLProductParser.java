package com.kharevich.pricetools.util;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

public class HTMLProductParser extends HTMLBaseParser {

	public HTMLProductParser(File file) throws IOException {
		super(file);
		// TODO Auto-generated constructor stub
	}

	public String getDescription() {
		return currentObjData.get(4).html();
	}

	public BigDecimal getPrice() {
		return new BigDecimal(currentObjData.get(5).html()
				.replaceAll("[\']", "").replaceAll(",", "."));
	}

	public BigDecimal getPartnerPrice() {
		return new BigDecimal(currentObjData.get(6).html()
				.replaceAll("[\']", "").replaceAll(",", "."));
	}

	public String getQuantity() {
		return currentObjData.get(8).html();
	}

	public String getOKDP() {
		return currentObjData.get(11).html();
	}

}
