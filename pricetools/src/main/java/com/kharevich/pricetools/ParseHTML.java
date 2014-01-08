package com.kharevich.pricetools;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kharevich.pricetools.logic.Product;
import com.kharevich.pricetools.logic.ProductDescription;
import com.kharevich.pricetools.logic.ProductToCategory;
import com.kharevich.pricetools.logic.ProductToStore;
import com.kharevich.pricetools.logic.service.ProductService;
import com.kharevich.pricetools.util.ExcelHelper;
import com.kharevich.pricetools.util.HTMLProductParser;
import com.kharevich.pricetools.util.HttpUtil;


public class ParseHTML {

	private static ClassPathXmlApplicationContext ac;
	
	private static DateFormat df = new SimpleDateFormat("yyyyMMdd");

	private static final BigDecimal devide = new BigDecimal("8700");

	public static void proceed() throws Exception {
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

		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		ProductService productService = (ProductService) context
				.getBean("productService");
		File productFile = HttpUtil.download("http://www.tools.by/base24.php", df.format(new Date()) + "base.xls");
		HTMLProductParser parser = new HTMLProductParser(productFile);
		parser.iterator();
		while (parser.hasNext()) {
//			ProductDescription productdescription = (ProductDescription) ac
//					.getBean("product_description_base");
//			ProductToStore productToStore = (ProductToStore) ac
//					.getBean("product_to_store_base");
//			ProductToCategory productToCategory = (ProductToCategory) ac
//					.getBean("product_to_category_base");
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
			Product product = productService.getById(parser.getID());
			if (product != null) {
				BigDecimal price = parser.getPrice().divide(devide, 1,
						RoundingMode.HALF_UP);
				product.setPrice(price);
				price = parser.getPartnerPrice().divide(devide, 1,
						RoundingMode.HALF_UP);
				product.setPartner_price(price);
				int count = ExcelHelper.getStatus(parser.getQuantity());
				product.setQuantity(count);
				product.setStock_status_id((count > 0) ? 4 : 9);
				System.out.println(parser.getQuantity() + " "
						+ ExcelHelper.getStatus(parser.getQuantity()));
				productService.updateProduct(product);
				// session.update(product);
			} else {
				product = (Product) context.getBean("product_base");
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
//				productdescription.setDescription(parser.getDescription());
//				productdescription.setName(parser.getModel());
				int count = ExcelHelper.getStatus(parser.getQuantity());
				product.setQuantity(count);
				product.setStock_status_id((count > 0) ? 4 : 9);
				productService.addProduct(product);
				// productdescription.setProduct_id(product.getProduct_id());
				// session.save(productdescription);
				// productToStore.setProduct_id(product.getProduct_id());
				// session.save(productToStore);
				// productToCategory.setProduct_id(product.getProduct_id());
				// session.save(productToCategory);
			}
			// try {
			// session = HibernateUtil.getSessionFactory().openSession();
			// tx = session.beginTransaction();

		}

	}

}
