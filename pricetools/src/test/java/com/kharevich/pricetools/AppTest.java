package com.kharevich.pricetools;

import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kharevich.pricetools.logic.Product;
import com.kharevich.pricetools.service.ProductService;
import com.kharevich.pricetools.service.ProductServiceImpl;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    private ApplicationContext ac;

	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    public void testConn() {
    	Session session = HibernateUtil.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<Product> result = session
				.createCriteria(Product.class)
				.add(Restrictions.eq("partner_product_id", (long) 3))
				.setMaxResults(1).list();
		assertTrue(result.size()>0);
	}
    
    public void testSave() {
    	ProductService service = new ProductServiceImpl();
    	System.out.println(service.getProduct(3).getProduct_id());
		assertTrue(true);
	}
    
    public void testProduct() {
    	ac = new ClassPathXmlApplicationContext(new String[] { "config.xml" });
    	Product product = (Product) ac.getBean("product_base");
    	assertTrue(product.getStock_status_id() == 4);
    	
		
	}
}
