package com.kharevich.pricetools;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kharevich.pricetools.logic.Product;
import com.kharevich.pricetools.logic.bo.ProductService;
import com.kharevich.pricetools.logic.dao.ProductDAO;
import com.kharevich.pricetools.service.ProductServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
    	 ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    	 ProductService emService = (ProductService) context.getBean("productService");
    	 System.out.println(emService.getById(58).getCode());
    }
}
