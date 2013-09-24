package com.kharevich.main;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import jxl.read.biff.BiffException;

import com.kharevich.util.HttpUtil;

public class Main {
	
	private static DateFormat df = new SimpleDateFormat("yyyyMMdd");

	public static void main(String[] args) throws IOException, InterruptedException, BiffException {
		File product = HttpUtil.download("http://www.tools.by/base24.php", df.format(new Date()) + "base.xls");
		File image = HttpUtil.download("http://www.tools.by/base.php", df.format(new Date()) + "base24.xls");
		try {
			ParseHTML.proceed(product);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UploadImage.proceed(image);
		UpdateImageLinkHTML.proceed(image);
		
	}

}
