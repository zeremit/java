package com.kharevich.pricetools;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.kharevich.pricetools.logic.Product;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Product> result = session
				.createCriteria(Product.class)
				.add(Restrictions.eq("partner_product_id", (long) 3))
				.setMaxResults(1).list();
		System.out.println(result.get(0).getModel());
    }
}
