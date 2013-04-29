package com.kharevich.pricetools;

import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.kharevich.pricetools.logic.Product;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
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
		Transaction tx = session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Product> result = session
				.createCriteria(Product.class)
				.add(Restrictions.eq("partner_product_id", (long) 3))
				.setMaxResults(1).list();
		assertTrue(result.size()>0);
	}
}
