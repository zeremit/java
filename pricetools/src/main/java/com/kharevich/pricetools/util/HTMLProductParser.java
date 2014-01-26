package com.kharevich.pricetools.util;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Iterator;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.kharevich.pricetools.logic.ProductData;

public class HTMLProductParser extends HTMLBaseParser {

	public HTMLProductParser(File file) throws IOException {
		super(file);
		// TODO Auto-generated constructor stub
	}
	
	public  Iterator<ProductData> iterator(){
		return new ToolsByPriceListIterator(this);
	}
	
	class ToolsByPriceListIterator implements Iterator<ProductData> {
		
		Iterator<Element> elements;
		
		int current = 0;
		
		public ToolsByPriceListIterator(HTMLProductParser parcer) {
			this.elements = parcer.getContent().iterator();
			elements.next();
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return elements.hasNext();
		}

		@Override
		public ProductData next() {
			// TODO Auto-generated method stub
			Elements element = elements.next().getElementsByTag(TD);
			ProductData data = new ProductData();
			data.setiD(element.get(0).html());
			data.setCode(element.get(1).html());
			data.setModel(element.get(2).html());
			data.setSku(element.get(3).html());
			data.setDescription(element.get(4).html());
			data.setPrice(new BigDecimal(element.get(5).html()
				.replaceAll("[\']", "").replaceAll(",", ".")));
			data.setPartnerPrice(new BigDecimal(element.get(6).html()
					.replaceAll("[\']", "").replaceAll(",", ".")));
			data.setQuantity(ExcelHelper.getStatus(element.get(8).html()));
			return data;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();

		}

	}

}
