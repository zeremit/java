package com.kharevich.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class HttpUtil {
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
		}
		return file;
	}
}
