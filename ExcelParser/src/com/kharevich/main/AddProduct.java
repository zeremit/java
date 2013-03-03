package com.kharevich.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kharevich.logic.Product;
import com.kharevich.logic.ProductDescription;
import com.kharevich.util.HibernateUtil;

public class AddProduct {

	private static Connection connection = null;

	static public final String driver = "com.mysql.jdbc.Driver";
	static public final String connectionString = "jdbc:mysql://localhost:3306/greenlab_landshop";
	static public final String user = "root";
	static public final String password = "";

	static private final String Insert_Product = "Insert into product model, sku";

	public static void main(String[] args) throws IOException,
			InterruptedException, IllegalArgumentException, IllegalAccessException {
		// ClassPathXmlApplicationContext ac = new
		// ClassPathXmlApplicationContext(
		// new String[] { "config.xml" });// показываем Spring где лежит
		// // файл конфигурации
		// Product h = (Product) ac.getBean("hello");// указываем id нашего
		// bean-а
		// System.out.println(h.getModel());
		// FileInputStream file = new FileInputStream(new File("base24.xls"));
		// HSSFWorkbook workbook = new HSSFWorkbook(file);
		//
		// HSSFSheet sheet = workbook.getSheetAt(0);
		// Iterator<Row> rowIterator = sheet.iterator();
		// rowIterator.next();
		// Set<Integer> type = new HashSet<Integer>();
		// while (rowIterator.hasNext()) {
		// Row row = rowIterator.next();
		// // Product product = new Product();
		// type.add(row.getCell(1).getCellType());
		// System.out.println(getString(row.getCell(1)));
		// // product.setCode((int) row.getCell(1).getNumericCellValue());
		// // product.setOkpd(row.getCell(11).getStringCellValue());
		// // product.setName(row.getCell(2).getStringCellValue());
		// // product.setDescription(row.getCell(4).getStringCellValue());
		// // System.out.println(row.getCell(3));
		// //
		// //
		// product.setSku(Integer.toString((int)row.getCell(3).getNumericCellValue()));
		// //
		// //
		// product.setCost(Double.parseDouble((row.getCell(5).getStringCellValue())));
		// Cell cell = row.getCell(2);
		// // Cell.CELL_TYPE_BLANK;
		//
		// }
		// file.close();
		// for (int t : type) {
		// System.out.println(t);
		// }
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Product user = (Product) session.get(Product.class, (long) 59);
		session.getTransaction().commit();
		System.out.println(user.toParams());

	}

	private static String getString(Cell cell) {
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			return cell.getStringCellValue();
		case Cell.CELL_TYPE_NUMERIC:
			DecimalFormat df = new DecimalFormat();
			df.setDecimalSeparatorAlwaysShown(false);
			return df.format(cell.getNumericCellValue());

		}
		return "";

	}

	static private Connection getConnection() throws ClassNotFoundException,
			SQLException {
		if (connection != null)
			return connection;
		Class.forName(driver);
		connection = DriverManager.getConnection(connectionString, user,
				password);
		return connection;

	}

}
