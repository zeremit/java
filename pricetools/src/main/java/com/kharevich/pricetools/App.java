package com.kharevich.pricetools;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.math.BigDecimal;

import org.apache.log4j.Logger;

import com.kharevich.pricetools.util.DownloadManager;

/**
 * Hello world!
 * 
 */
public class App {
	public static final Logger LOG = Logger.getLogger(App.class);

	public static void main(String[] args) throws Exception {
		// System.setOut(new java.io.PrintStream(System.out, true, "Cp866"));
//		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
//				"applicationContext.xml");
		LOG.info("Application start");
		while (true) {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			System.out
					.print("Введите номер команды:\n1 - обновить товары\n2 - обновить изображения\n3 - удалить кеш\n4 - выход\n");
			try {
				int i = Integer.parseInt(br.readLine());
				switch (i) {
				case 1:
					System.out.print("Введите курс:");
					int brb = Integer.parseInt(br.readLine());
					File product = DownloadManager.download(
							"http://www.tools.by/base24.php", "base24.xls",
							true);
					try {
						new ParseHTML(new BigDecimal(brb), product).proceed();
						;
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 2:
					File image = DownloadManager.download(
							"http://www.tools.by/base24.php", "base24.xls",
							true);
					UploadImage.proceed(image);
					// UpdateImageLinkHTML.proceed(image);
					break;
				case 3:
					// FTPUtil.deleteFiles();
					// break;
				default:
					return;
				}
			} catch (NumberFormatException nfe) {
				System.err.println("Неверный формат!");
			}
			// FTPUtil.deleteFiles();
		}
	}
}
