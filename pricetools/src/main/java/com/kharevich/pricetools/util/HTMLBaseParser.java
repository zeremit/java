package com.kharevich.pricetools.util;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HTMLBaseParser implements IParser {

	private Document content;

	protected static final String TD = "td";
	
	private static final String TR = "tr";

	public HTMLBaseParser(File file) throws IOException {
		content = Jsoup.parse(file, "UTF-8");
	}
	
	protected Elements getContent(){
		return content.getElementsByTag(TR);
	}

}
