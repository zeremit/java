package com.kharevich.pricetools;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kharevich.pricetools.logic.Product;
import com.kharevich.pricetools.logic.dao.ProductDAO;
import com.kharevich.pricetools.service.ProductService;
import com.kharevich.pricetools.service.ProductServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
    	ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(new String[] { "beanlocations.xml" });
    	Product product = (Product) ac.getBean("product_base");
    	ProductDAO service = (ProductDAO) ac.getBean("productDao");
    	System.out.println(service.getProduct(3).getProduct_id());
    }
}
