package com.kharevich.main;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.kharevich.logic.Product;
import com.kharevich.util.ExcelHelper;
import com.kharevich.util.HibernateUtil;

public class UpdatePrice {
	
	private static final BigDecimal devide = new BigDecimal("8600");

	public static void main(String[] args) throws Exception {
		Session session = null;
		Transaction tx = null;
		FileInputStream file = new FileInputStream(new File("base24.xls"));
		HSSFWorkbook workbook = new HSSFWorkbook(file);

		HSSFSheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.iterator();
		rowIterator.next();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			
			try {
				session = HibernateUtil.getSessionFactory().openSession();
				tx = session.beginTransaction();
				@SuppressWarnings("unchecked")
				List<Product> result = session.createCriteria(Product.class).add(Restrictions.eq("partner_product_id", (long) row.getCell(0).getNumericCellValue())).setMaxResults(1).list();
				Product product = result.get(0);
				BigDecimal price = new BigDecimal(ExcelHelper.getString(row
						.getCell(6))).divide(devide,1,RoundingMode.HALF_UP);
				product.setPartner_price(price);
				session.update(product);
//				productdescription.setProduct_id(product.getProduct_id());
//				session.save(productdescription);
//				productToStore.setProduct_id(product.getProduct_id());
//				session.save(productToStore);
//				productToCategory.setProduct_id(product.getProduct_id());
//				session.save(productToCategory);
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
