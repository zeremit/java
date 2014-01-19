package com.kharevich.pricetools;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kharevich.pricetools.logic.Product;
import com.kharevich.pricetools.logic.ProductDescription;
import com.kharevich.pricetools.logic.ProductToCategory;
import com.kharevich.pricetools.logic.ProductToStore;
import com.kharevich.pricetools.logic.service.ProductDescriptionService;
import com.kharevich.pricetools.logic.service.ProductService;
import com.kharevich.pricetools.logic.service.ProductToCategoryService;
import com.kharevich.pricetools.logic.service.ProductToStoreService;
import com.kharevich.pricetools.util.ExcelHelper;
import com.kharevich.pricetools.util.HTMLProductParser;


public class ParseHTML {
	
	public ParseHTML(BigDecimal decimal, File file){
		this.devide = decimal;
		this.file = file;
	}

	private BigDecimal devide;
	
	private File file;

	public void proceed() throws Exception {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		ProductService productService = (ProductService) context
				.getBean("productService");
		ProductDescriptionService productDescriptionService = (ProductDescriptionService) context
				.getBean("productDescriptionService");
		ProductToCategoryService productToCategoryService = (ProductToCategoryService) context
				.getBean("productToCategoryService");
		ProductToStoreService productToStoreService = (ProductToStoreService) context
				.getBean("productToStoreService");
		HTMLProductParser parser = new HTMLProductParser(file);
		parser.iterator();
		while (parser.hasNext()) {
			parser.next();
			Product product = productService.getByPartnerId(parser.getID());
			if (product != null) {
				BigDecimal price = parser.getPrice().divide(devide, 1,
						RoundingMode.HALF_UP);
				if(!product.getNot_change()){
					product.setPrice(price.multiply(product.getPercent()));
				}
				price = parser.getPartnerPrice().divide(devide, 1,
						RoundingMode.HALF_UP);
				product.setPartner_price(price);
				int count = ExcelHelper.getStatus(parser.getQuantity());
				product.setQuantity(count);
				product.setStock_status_id((count > 0) ? 4 : 9);
				product.setDate_modified(new Date());
				productService.updateProduct(product);
			} else {
				product = (Product) context.getBean("product_base");
				ProductDescription productDescription = (ProductDescription) context
						.getBean("product_description_base");
				ProductToStore productToStore = (ProductToStore) context
						.getBean("product_to_store_base");
				ProductToCategory productToCategory = (ProductToCategory) context
						.getBean("product_to_category_base");
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
				productDescription.setDescription(parser.getDescription());
				productDescription.setName(parser.getModel());
				int count = ExcelHelper.getStatus(parser.getQuantity());
				product.setQuantity(count);
				product.setStock_status_id((count > 0) ? 4 : 9);
				productService.addProduct(product);
				productDescription.setProduct_id(product.getProduct_id());
				productDescriptionService.addProductDescription(productDescription);
				productToStore.setProduct_id(product.getProduct_id());
				productToStoreService.addProductToStore(productToStore);
				productToCategory.setProduct_id(product.getProduct_id());
				productToCategoryService.addProductToCategory(productToCategory);
				// session.save(productToCategory);
			}
		}
		context.close();

	}

}
