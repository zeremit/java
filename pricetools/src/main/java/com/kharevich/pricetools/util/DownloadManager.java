package com.kharevich.pricetools.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DownloadManager {
	
	private static DateFormat df = new SimpleDateFormat("yyyyMMdd");
	
	public static File download(String uri, String fileName, boolean needDate) throws IOException {
		return download(uri,(needDate ? df.format(new Date()) : "") + fileName);
	}
	
	public static File download(String uri, String fileName) throws IOException {
		File file = new File(fileName);
		if (!file.exists()) {
			URL url = null;
			URLConnection con = null;
			int i;
			url = new URL(uri);
			con = url.openConnection();

			BufferedInputStream bis = new BufferedInputStream(
					con.getInputStream());
			BufferedOutputStream bos = new BufferedOutputStream(
					new FileOutputStream(file.getName()));
			while ((i = bis.read()) != -1) {
				bos.write(i);
			}
			bos.flush();
			bis.close();
			bos.close();
		}
		return file;
	}

}
