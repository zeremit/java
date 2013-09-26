package com.kharevich.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import com.kharevich.keys.PropertyKeys;

public class FTPUtil {
	
	static public void deleteFiles(){
		Properties prop = new Properties();
		FTPClient client = new FTPClient();
		try {
			// load a properties file
			prop.load(new FileInputStream("server_config.properties"));
//			String dirName = prop.getProperty(PropertyKeys.TEMP_FOLDER);
//			File dir = new File(dirName);
//			if (!dir.exists()) {
//				if (dir.mkdir()) {
//					System.out.println("Directory is created!");
//				} else {
//					System.out.println("Failed to create directory!");
//				}
//			}
			client.connect(prop.getProperty(PropertyKeys.FTP_URL));
			client.login(prop.getProperty(PropertyKeys.FTP_USER),
					prop.getProperty(PropertyKeys.FTP_PASSWORD));

			client.changeWorkingDirectory(prop
					.getProperty(PropertyKeys.CACHE_FOLDER));
//			String url = prop.getProperty(PropertyKeys.SRC_URL);
			// client.storeFile(filename, fis);
			FTPFile[] files = client.listFiles();
			client.setFileType(FTP.BINARY_FILE_TYPE, FTP.BINARY_FILE_TYPE);
			client.setFileTransferMode(FTP.BINARY_FILE_TYPE);
			for (FTPFile fl : files) {
				System.out.println(client.deleteFile(fl.getName()));
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
	}

}
