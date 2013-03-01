import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

import com.kharevich.logic.Product;
import com.kharevich.util.HibernateUtil;

public class AddProduct {

	private static Connection connection = null;

	static public final String driver = "com.mysql.jdbc.Driver";
	static public final String connectionString = "jdbc:mysql://localhost:3306/greenlab_landshop";
	static public final String user = "root";
	static public final String password = "";

	static private final String Insert_Product = "Insert into product model, sku";

	public static void main(String[] args) throws IOException,
			InterruptedException {
		// FileInputStream file = new FileInputStream(new File("base24.xls"));
		// HSSFWorkbook workbook = new HSSFWorkbook(file);
		//
		// HSSFSheet sheet = workbook.getSheetAt(0);
		// Iterator<Row> rowIterator = sheet.iterator();
		// rowIterator.next();
		// Set<Integer> type = new HashSet<Integer>();
		// while (rowIterator.hasNext()) {
		// Row row = rowIterator.next();
		// Product product = new Product();
		// type.add(row.getCell(1).getCellType());
		// // product.setCode((int) row.getCell(1).getNumericCellValue());
		// // product.setOkpd(row.getCell(11).getStringCellValue());
		// // product.setName(row.getCell(2).getStringCellValue());
		// // product.setDescription(row.getCell(4).getStringCellValue());
		// // System.out.println(row.getCell(3));
		// //
		// product.setSku(Integer.toString((int)row.getCell(3).getNumericCellValue()));
		// //
		// product.setCost(Double.parseDouble((row.getCell(5).getStringCellValue())));
		// Cell cell = row.getCell(2);
		// // Cell.CELL_TYPE_BLANK;
		//
		// }
		// file.close();
		// for(int t : type){
		// System.out.println(t);
		// }
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Product user = (Product) session.get(Product.class, (long) 59);
		session.getTransaction().commit();
		System.out.println(user.getModel());
		session = HibernateUtil.getSessionFactory().openSession();
		user.setProduct_id(100000);
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();

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
