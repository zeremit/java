package com.kharevich.main;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ParseHTML {
	
	public static void main(String[] args) {
		File input = new File("22-09-2013-base.xls");
		try {
			Document doc = Jsoup.parse(input, "UTF-8");
			Elements links = doc.getElementsByTag("tr");
			  System.out.println(links.get(1));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
