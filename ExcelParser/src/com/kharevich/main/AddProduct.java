package com.kharevich.main;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kharevich.logic.Product;
import com.kharevich.logic.ProductDescription;
import com.kharevich.logic.ProductToCategory;
import com.kharevich.logic.ProductToStore;
import com.kharevich.util.ExcelHelper;
import com.kharevich.util.HibernateUtil;

public class AddProduct {

	private static ClassPathXmlApplicationContext ac;
	
	private static final BigDecimal devide = new BigDecimal("8600");

	public static void main(String[] args) throws Exception {
		Session session = null;
		Transaction tx = null;
		// ProductDescription user = null;
		// try {
		// session = HibernateUtil.getSessionFactory().openSession();
		// tx = session.beginTransaction();
		// user = (ProductDescription) session.get(ProductDescription.class,
		// (long) 1583);
		// tx.commit();
		//
		// } catch (Exception e) {
		// if (tx != null)
		// tx.rollback();
		// throw e;
		// } finally {
		// session.close();
		// }
		// System.out.println(user.toParams());

		ac = new ClassPathXmlApplicationContext(new String[] { "config.xml" });
		FileInputStream file = new FileInputStream(new File("base24.xls"));
		HSSFWorkbook workbook = new HSSFWorkbook(file);

		HSSFSheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.iterator();
		rowIterator.next();
		Set<Integer> type = new HashSet<Integer>();
		while (rowIterator.hasNext()) {
			Product product = (Product) ac.getBean("product_base");
			ProductDescription productdescription = (ProductDescription) ac
					.getBean("product_description_base");
			ProductToStore productToStore = (ProductToStore) ac
					.getBean("product_to_store_base");
			ProductToCategory productToCategory = (ProductToCategory) ac
					.getBean("product_to_category_base");
			Row row = rowIterator.next();
			// Product product = new Product();
			type.add(row.getCell(1).getCellType());
			// product.setCode((int) row.getCell(1).getNumericCellValue());
			// product.setOkpd(row.getCell(11).getStringCellValue());
			// product.setName(row.getCell(2).getStringCellValue());
			// product.setDescription(row.getCell(4).getStringCellValue());
			// System.out.println(row.getCell(3));
			//
			//
			//
			//
			// System.out.println(row.getCell(5));
			String s = ExcelHelper.getString(row.getCell(2));
			product.setModel(s);
			product.setPartner_product_id((long) row.getCell(0).getNumericCellValue());
			product.setCode(ExcelHelper.getString(row.getCell(1)));
			product.setOkdp(ExcelHelper.getString(row.getCell(11)));
			product.setSku(ExcelHelper.getString(row.getCell(3)));
			BigDecimal price = new BigDecimal(ExcelHelper.getString(row
					.getCell(5))).divide(devide,1,RoundingMode.HALF_UP);
			product.setPrice(price);
			product.setPartner_price(price);
			productdescription.setDescription(ExcelHelper.getString(row
					.getCell(4)));
			productdescription.setName(s);
			try {
				session = HibernateUtil.getSessionFactory().openSession();
				tx = session.beginTransaction();
				session.save(product);
				productdescription.setProduct_id(product.getProduct_id());
				session.save(productdescription);
				productToStore.setProduct_id(product.getProduct_id());
				session.save(productToStore);
				productToCategory.setProduct_id(product.getProduct_id());
				session.save(productToCategory);
				tx.commit();
			} catch (Exception e) {
				if (tx != null)
					tx.rollback();
				throw e;
			} finally {
				session.close();
			}
		}

	}

}
