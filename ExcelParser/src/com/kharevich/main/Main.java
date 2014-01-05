package com.kharevich.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import jxl.read.biff.BiffException;

import com.kharevich.util.FTPUtil;
import com.kharevich.util.HttpUtil;

public class Main {
	
	private static DateFormat df = new SimpleDateFormat("yyyyMMdd");

	public static void main(String[] args) throws IOException, InterruptedException, BiffException {
		System.setOut(new java.io.PrintStream(System.out, true, "Cp866"));
		while(true){
			 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		        System.out.print("Введите номер команды:\n1 - обновить товары\n2 - обновить изображения\n3 - удалить кеш\n4 - выход\n");
		        try{
		            int i = Integer.parseInt(br.readLine());
		            switch (i) {
					case 1:
						System.out.print("Введите курс:");
						int brb = Integer.parseInt(br.readLine());
						File product = HttpUtil.download("http://www.tools.by/base24.php", df.format(new Date()) + "base.xls");
						try {
							ParseHTML.proceed(product, new BigDecimal(brb));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case 2:
						File image = HttpUtil.download("http://www.tools.by/base.php", df.format(new Date()) + "base24.xls");	
						UploadImage.proceed(image);
						UpdateImageLinkHTML.proceed(image);
					case 3:
						FTPUtil.deleteFiles();
						break;
					default:
						return;
					}
		        }catch(NumberFormatException nfe){
		            System.err.println("Неверный формат!");
		        }
		        FTPUtil.deleteFiles();
		}
		
	}

}
