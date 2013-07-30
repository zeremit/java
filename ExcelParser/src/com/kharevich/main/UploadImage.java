package com.kharevich.main;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.kharevich.keys.PropertyKeys;

public class UploadImage {

	private static String POSTFIX = ".jpg";

	public static void main(String[] args) {
		FTPClient client = new FTPClient();

		Properties prop = new Properties();

		try {
			// load a properties file
			prop.load(new FileInputStream("server_config.properties"));
			FileInputStream file = new FileInputStream(new File("base.xls"));

			// get the property value and print it out
			// HSSFWorkbook workbook = new HSSFWorkbook(file);
			//
			// HSSFSheet sheet = workbook.getSheetAt(0);
			// Iterator<Row> rowIterator = sheet.iterator();
			// while (rowIterator.hasNext()) {
			// Row row = rowIterator.next();
			//
			// Cell cell = row.getCell(0);
			// switch (cell.getCellType()) {
			// case Cell.CELL_TYPE_NUMERIC:
			// double t = cell.getNumericCellValue();
			// int i = (int) t;
			//
			// String link = PREFIX + i + POSTFIX;
			// try {
			// saveUrl(FOLDER + i + POSTFIX, link);
			// } catch (MalformedURLException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
			// break;
			//
			// }
			//
			// }
			// file.close();
			//
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		List<String> fileList = new ArrayList<String>();
		try {
			String dirName = prop.getProperty(PropertyKeys.TEMP_FOLDER);
			File dir = new File(dirName);
			if (!dir.exists()) {
				if (dir.mkdir()) {
					System.out.println("Directory is created!");
				} else {
					System.out.println("Failed to create directory!");
				}
			}
			client.connect(prop.getProperty(PropertyKeys.FTP_URL));
			client.login(prop.getProperty(PropertyKeys.FTP_USER),
					prop.getProperty(PropertyKeys.FTP_PASSWORD));

			client.changeWorkingDirectory(prop
					.getProperty(PropertyKeys.FTP_FOLDER));
			String url = prop.getProperty(PropertyKeys.SRC_URL);
			// client.storeFile(filename, fis);
			FTPFile[] files = client.listFiles();
			client.setFileType(FTP.BINARY_FILE_TYPE, FTP.BINARY_FILE_TYPE);
			client.setFileTransferMode(FTP.BINARY_FILE_TYPE);
			for (FTPFile fl : files) {
				fileList.add(fl.getName());
			}
			System.out.println(fileList.size());

			FileInputStream file = new FileInputStream(new File("base.xls"));
			HSSFWorkbook workbook = new HSSFWorkbook(file);

			HSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();

				Cell cell = row.getCell(0);
				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_NUMERIC:
					double t = cell.getNumericCellValue();
					int i = (int) t;
					// linkList.add(PREFIX + i + POSTFIX);
					String fileName = i + POSTFIX;
					if (!fileList.contains(fileName)) {
						try {
							System.out.println("download: "+fileName);
							saveUrl(fileName, url, client);
						} catch (MalformedURLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					break;

				}

			}
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				client.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		for (String fl : fileList) {
			// System.out.println(fl);
		}
		System.out.println(fileList.size());
	}

	public static void saveUrl(String filename, String urlString,
			FTPClient client) throws MalformedURLException, IOException {
		BufferedInputStream in = null;
		FileOutputStream fout = null;
		try {
			File file = new File(filename);
			in = new BufferedInputStream(
					new URL(urlString + filename).openStream());
//			fout = new FileOutputStream(file);
//
//			byte data[] = new byte[1024];
//			int count;
//			while ((count = in.read(data, 0, 1024)) != -1) {
//				fout.write(data, 0, count);
//			}
			client.storeFile(filename, in);
//			in.close();
		} finally {
			if (in != null)
				in.close();
			if (fout != null)
				fout.close();
		}
//		InputStream file = new FileInputStream(filename);
//		client.storeFile(filename, file);
//		file.close();
	}
}
