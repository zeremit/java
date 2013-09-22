package com.kharevich.logic;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class HTMLBaseParser implements Iterable<Element> {

	private Document content;

	private Iterator<Element> iterator = null;

	private Element currentElement = null;

	private static final String TD = "td";
	private static final String TR = "tr";

	HTMLBaseParser(File file) throws IOException {
		content = Jsoup.parse(file, "UTF-8");
	}

	@Override
	public Iterator<Element> iterator() {
		// TODO Auto-generated method stub
		return content.getElementsByTag(TR).iterator();
	}

	public boolean hasNext() {
		if (iterator == null || !iterator.hasNext())
			return false;
		return true;
	}

	public Element next() {
		if (hasNext()) {
			currentElement = iterator.next();

		} else {
			iterator = iterator();
			currentElement = iterator.next();
		}
		return currentElement;
	}

}
