package com.kharevich.pricetools.util;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HTMLBaseParser implements Iterable<Element>, IParser {

	private Document content;

	private Iterator<Element> iterator = null;

	private Element currentElement = null;

	protected Elements currentObjData = null;

	private static final String TD = "td";
	private static final String TR = "tr";

	public HTMLBaseParser(File file) throws IOException {
		content = Jsoup.parse(file, "UTF-8");
	}

	@Override
	public Iterator<Element> iterator() {
		// TODO Auto-generated method stub
		iterator = content.getElementsByTag(TR).iterator();
		iterator.next();
		return iterator;
	}

	public boolean hasNext() {
		if (iterator != null && !iterator.hasNext())
			return false;
		return true;
	}

	public Element next() {
		currentElement = iterator.next();
		currentObjData = currentElement.getElementsByTag(TD);
		return currentElement;
	}

	@Override
	public String getID() {
		return currentObjData.get(0).html();
	}

	@Override
	public String getCode() {
		return currentObjData.get(1).html();
	}

	@Override
	public String getSKU() {
		return currentObjData.get(3).html();
	}

	@Override
	public String getModel() {
		// TODO Auto-generated method stub
		return currentObjData.get(2).html();
	}

}
