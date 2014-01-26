package com.kharevich.pricetools;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import com.kharevich.pricetools.util.DownloadManager;
import com.kharevich.pricetools.util.HTMLProductParser;

public class CompareFiles {

	public static void main(String[] args) throws IOException {
		File image = DownloadManager.download("http://www.tools.by/base.php",
				"base.xls", true);
		File price = DownloadManager.download("http://www.tools.by/base24.php",
				"base24.xls", true);

		HTMLProductParser parserImage = new HTMLProductParser(image);
		HTMLProductParser parserPrice = new HTMLProductParser(price);

		Set<String> imageSet = new HashSet<String>();
		Set<String> priceSet = new HashSet<String>();
		parserImage.iterator();
//		while (parserImage.hasNext()) {
//			parserImage.next();
//			imageSet.add(parserImage.getCode());
//
//		}
//		parserPrice.iterator();
//		System.out.println(imageSet.size());
//		int i=0;
//		while (parserPrice.hasNext()) {
//			parserPrice.next();
//			i++;
//			imageSet.remove(parserPrice.getCode());
//
//		}
//		System.out.println(i);
		System.out.println(imageSet.size());
	}

}
