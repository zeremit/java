package com.kharevich.pricetools.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HTMLPicParser extends HTMLBaseParser {

	public HTMLPicParser(File file) throws IOException {
		super(file);
		// TODO Auto-generated constructor stub
	}
	
	
	public Map<String, String> getMap(){
		Iterator<Element> it = getContent().iterator();
		Map<String, String> map = new HashMap<String,String>();
		it.next();
		while(it.hasNext()){
			Elements el = it.next().getElementsByTag(TD);;
			map.put(el.get(1).html(), el.get(0).html());
		}
		return map;
	}
	

}
