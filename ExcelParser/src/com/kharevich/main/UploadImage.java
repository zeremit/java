package com.kharevich.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import com.kharevich.keys.PropertyKeys;

public class UploadImage {

	public static void main(String[] args) {
		FTPClient client = new FTPClient();
		FileInputStream fis = null;

		Properties prop = new Properties();

		try {
			// load a properties file
			prop.load(new FileInputStream("server_config.properties"));
			File fl = new File("24shop.xls");
			System.out.println(fl.length());

			// get the property value and print it out
			System.out.println(prop.getProperty("ftp_url"));
			System.out.println(prop.getProperty("ftp_user"));
			System.out.println(prop.getProperty("ftp_password"));

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		try {
			client.connect(prop.getProperty(PropertyKeys.FTP_URL));
			client.login(prop.getProperty(PropertyKeys.FTP_USER), prop.getProperty(PropertyKeys.FTP_PASSWORD));

			//
			// Create an InputStream of the file to be uploaded
			//
			String filename = "24shop.xls";
			fis = new FileInputStream(filename);

			//
			// Store file to server
			//
			client.changeWorkingDirectory(prop.getProperty(PropertyKeys.FTP_FOLDER));
			client.storeFile(filename, fis);
			FTPFile[] ar = client.listFiles();
			for(FTPFile a: ar){
				System.out.println(a.getSize());
			}
			client.logout();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
				client.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
