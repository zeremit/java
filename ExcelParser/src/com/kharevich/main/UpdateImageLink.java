package com.kharevich.main;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.hibernate.Query;
import org.hibernate.Session;

import com.kharevich.util.ExcelHelper;
import com.kharevich.util.HibernateUtil;

public class UpdateImageLink {

	private static String PREFIX = "data/toolsby/";
	private static String POSTFIX = ".jpg";
	private static int i = 0;

	public static void main(String[] args) {
		try {
			FileInputStream file = new FileInputStream(new File("base.xls"));
			HSSFWorkbook workbook = new HSSFWorkbook(file);

			HSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			Session session = HibernateUtil.getSessionFactory().openSession();
			rowIterator.next();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				String hql = "update Product set image = :newImage where partner_product_id = :code";
		        Query query = session.createQuery(hql);
		        query.setString("newImage",PREFIX+ExcelHelper.getString(row.getCell(0))+POSTFIX);
		        query.setLong("code",Long.parseLong(ExcelHelper.getString(row.getCell(0))));
		        int rowCount = query.executeUpdate();
		        System.out.println(ExcelHelper.getString(row.getCell(0))+" upade: "+ rowCount);

			}
			session.close();
			file.close();
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
