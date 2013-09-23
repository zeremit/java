package com.kharevich.main;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.kharevich.logic.HTMLProductParser;
import com.kharevich.util.HttpUtil;

public class DownloadImage {

	private static String FOLDER = "toolsby/";
	private static String PREFIX = "http://www.tools.by/newkatfiles/";
	private static String POSTFIX = ".jpg";
	private static int i = 0;

	public static void main(String[] args) {
		List<String> linkList = new ArrayList<String>();
		try {
			File file = HttpUtil.download("http://www.tools.by/base.php",
					"test.xls");
			HTMLProductParser parser = new HTMLProductParser(file);
			parser.iterator();
			while (parser.hasNext()) {
				parser.next();

				linkList.add(PREFIX + parser.getID() + POSTFIX);
				String link = PREFIX + parser.getID() + POSTFIX;
				try {
					saveUrl(FOLDER + parser.getID() + POSTFIX, link);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("Download: " + i);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File not found");
			;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IOException");
			;
		}
		// for (String link: linkList) {
		// try {
		// saveUrl("test.jpg",link);
		// } catch (MalformedURLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//
		// }
	}

	public static void saveUrl(String filename, String urlString)
			throws MalformedURLException, IOException {
		BufferedInputStream in = null;
		FileOutputStream fout = null;
		try {
			File file = new File(filename);
			if (!file.exists() || !file.isFile()) {
				System.out.println(urlString);
				in = new BufferedInputStream(new URL(urlString).openStream());
				fout = new FileOutputStream(file);

				byte data[] = new byte[1024];
				int count;
				while ((count = in.read(data, 0, 1024)) != -1) {
					fout.write(data, 0, count);
				}
				i++;
			} else {
				System.out.println(urlString + ": exist");
			}
		} finally {
			if (in != null)
				in.close();
			if (fout != null)
				fout.close();
		}
	}

}
