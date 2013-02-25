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
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class AddProduct {

	private static Connection connection = null;

	static public final String driver = "com.mysql.jdbc.Driver";
	static public final String connectionString = "jdbc:mysql://localhost:3306/greenlab_landshop";
	static public final String user = "root";
	static public final String password = "";
	
	static private final String Insert_Product  = "Insert into product model, sku";

	public static void main(String[] args) throws IOException, InterruptedException {
		FileInputStream file = new FileInputStream(new File("base24_test.xls"));
		HSSFWorkbook workbook = new HSSFWorkbook(file);

		HSSFSheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.iterator();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();

			Cell cell = row.getCell(2);
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_STRING:
				String s = cell.getStringCellValue();
				Thread.sleep(1000);
				System.out.println(s);
				break;

			}

		}
		file.close();

	}

	static private Connection getConnection() throws ClassNotFoundException, SQLException {
		if (connection != null)
			return connection;
		Class.forName(driver);
		connection = DriverManager.getConnection(connectionString, user, password);
		return connection;

	}

}
