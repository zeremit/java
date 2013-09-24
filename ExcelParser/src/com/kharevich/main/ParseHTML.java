package com.kharevich.main;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kharevich.logic.HTMLProductParser;
import com.kharevich.logic.Product;
import com.kharevich.logic.ProductDescription;
import com.kharevich.logic.ProductToCategory;
import com.kharevich.logic.ProductToStore;
import com.kharevich.util.HibernateUtil;

public class ParseHTML {

	private static ClassPathXmlApplicationContext ac;

	private static final BigDecimal devide = new BigDecimal("8700");

	public static void proceed(File file) throws Exception {
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
		HTMLProductParser parser = new HTMLProductParser(file);
		parser.iterator();
		while (parser.hasNext()) {
			ProductDescription productdescription = (ProductDescription) ac
					.getBean("product_description_base");
			ProductToStore productToStore = (ProductToStore) ac
					.getBean("product_to_store_base");
			ProductToCategory productToCategory = (ProductToCategory) ac
					.getBean("product_to_category_base");
			parser.next();
			// Product product = new Product();
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
						.add(Restrictions.eq("partner_product_id",
								Long.parseLong(parser.getID())))
						.setMaxResults(1).list();
				Product product = null;
				if (result.size() > 0) {
					product = result.get(0);
					// session.update(product);
				} else {
					product = (Product) ac.getBean("product_base");
					product.setModel(parser.getModel());
					product.setPartner_product_id(Long.parseLong(parser.getID()));
					product.setCode(parser.getCode());
					product.setOkdp(parser.getOKDP());
					product.setSku(parser.getSKU());
					System.out.println(product.getPartner_product_id());
					BigDecimal price = parser.getPrice().divide(devide, 1,
							RoundingMode.HALF_UP);
					product.setPrice(price);
					price = parser.getPartnerPrice().divide(devide, 1,
							RoundingMode.HALF_UP);
					product.setPartner_price(price);
					productdescription.setDescription(parser.getDescription());
					productdescription.setName(parser.getModel());
					session.save(product);
					productdescription.setProduct_id(product.getProduct_id());
					session.save(productdescription);
					productToStore.setProduct_id(product.getProduct_id());
					session.save(productToStore);
					productToCategory.setProduct_id(product.getProduct_id());
					session.save(productToCategory);
				}
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
