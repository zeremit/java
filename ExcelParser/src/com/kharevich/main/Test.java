package com.kharevich.main;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kharevich.logic.Product;
import com.kharevich.util.ExcelHelper;
import com.kharevich.util.HibernateUtil;

public class Test {

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

		new ClassPathXmlApplicationContext(new String[] { "config.xml" });
		FileInputStream file = new FileInputStream(new File("base24.xls"));
		HSSFWorkbook workbook = new HSSFWorkbook(file);

		HSSFSheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.iterator();
		rowIterator.next();
		Set<Integer> type = new HashSet<Integer>();
		int i=0;
		while (rowIterator.hasNext()) {
//			ProductDescription productdescription = (ProductDescription) ac
//					.getBean("product_description_base");
//			ProductToStore productToStore = (ProductToStore) ac
//					.getBean("product_to_store_base");
//			ProductToCategory productToCategory = (ProductToCategory) ac
//					.getBean("product_to_category_base");
			Row row = rowIterator.next();
			// Product product = new Product();
//			ExcelHelper.getStatus(row.getCell(8));
//			System.out.println(ExcelHelper.getStatus(row.getCell(8)));
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
			try {
				session = HibernateUtil.getSessionFactory().openSession();
				tx = session.beginTransaction();
				@SuppressWarnings("unchecked")
				List<Product> result = session
						.createCriteria(Product.class)
						.add(Restrictions.eq("partner_product_id", (long) row
								.getCell(0).getNumericCellValue()))
						.setMaxResults(1).list();
				Product product = null;
				if (result.size() > 0) {
					product = result.get(0);
					int count = ExcelHelper.getStatus(row.getCell(8));
					product.setQuantity(count);
					product.setStock_status_id((count>0) ? 4 : 9);
					session.update(product);
				} 
//				else {
//					product = (Product) ac.getBean("product_base");
//					String s = ExcelHelper.getString(row.getCell(2));
//					product.setModel(s);
//					product.setPartner_product_id((long) row.getCell(0)
//							.getNumericCellValue());
//					product.setCode(ExcelHelper.getString(row.getCell(1)));
//					product.setOkdp(ExcelHelper.getString(row.getCell(11)));
//					product.setSku(ExcelHelper.getString(row.getCell(3)));
//					System.out.println(product.getPartner_product_id());
//					BigDecimal price = new BigDecimal(ExcelHelper.getString(row
//							.getCell(5)).replaceAll("[\']","").replaceAll(",",".")).divide(devide, 1,
//							RoundingMode.HALF_UP);
//					product.setPrice(price);
//					price = new BigDecimal(
//							ExcelHelper.getString(row.getCell(6))).divide(
//							devide, 1, RoundingMode.HALF_UP);
//					product.setPartner_price(price);
//					productdescription.setDescription(ExcelHelper.getString(row
//							.getCell(4)));
//					productdescription.setName(s);
//					session.save(product);
//					productdescription.setProduct_id(product.getProduct_id());
//					session.save(productdescription);
//					productToStore.setProduct_id(product.getProduct_id());
//					session.save(productToStore);
//					productToCategory.setProduct_id(product.getProduct_id());
//					session.save(productToCategory);
//				}
				// try {
				// session = HibernateUtil.getSessionFactory().openSession();
				// tx = session.beginTransaction();

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
