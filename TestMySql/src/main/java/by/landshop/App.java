package by.landshop;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Connection conn = null;
        String url = "jdbc:mysql://93.125.99.50/";
        String dbName = "landshop_landshop";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "landshop_green";
        String password = "048Nwazi";
        try {
            while (true) {
                Class.forName(driver).newInstance();
                conn = DriverManager.getConnection(url + dbName, userName, password);
                Connection conn1 = DriverManager.getConnection(url + dbName, userName, password);
                java.sql.Statement st = conn.createStatement();
                java.sql.Statement st1 = conn1.createStatement();
                String sql = "SELECT product_id FROM(SELECT DISTINCT p.product_id, pd.name, p.model, p.quantity, p.price, p.sort_order, p.date_added , coalesce((SELECT price FROM product_discount pd2 WHERE pd2.product_id = p.product_id AND pd2.customer_group_id = '1' AND pd2.quantity = '1' AND ((pd2.date_start = '0000-00-00' OR pd2.date_start < NOW()) AND (pd2.date_end = '0000-00-00' OR pd2.date_end > NOW())) ORDER BY pd2.priority ASC, pd2.price ASC LIMIT 1), (SELECT price FROM product_special ps WHERE ps.product_id = p.product_id AND ps.customer_group_id = '1' AND ((ps.date_start = '0000-00-00' OR ps.date_start < NOW()) AND (ps.date_end = '0000-00-00' OR ps.date_end > NOW())) ORDER BY ps.priority ASC, ps.price ASC LIMIT 1), p.price) as realprice FROM product p LEFT JOIN product_option_value pov ON (pov.product_id=p.product_id) LEFT JOIN product_description pd ON (pd.product_id=p.product_id) LEFT JOIN product_to_store p2s ON (p2s.product_id=p.product_id) LEFT JOIN product_to_category p2c ON (p2c.product_id=p.product_id) WHERE 1 AND p2c.category_id IN (135) AND p.manufacturer_id IN(11) AND p.price >=82 AND pd.language_id = '2' AND p.status = '1' AND p.date_available <= NOW( ) AND p2s.store_id = 0) as innertable WHERE 1 AND realprice >=82 AND realprice <=1882 ORDER BY (CASE WHEN quantity>0 THEN 1 ELSE 0 END) DESC, sort_order ASC, LCASE(name) ASC LIMIT 0,30";
                ResultSet result = st.executeQuery(sql);

                ResultSet result1 = st1.executeQuery(sql);
                while (result.next()) {
                    result1.next();
                    if (result.getLong(1) != result1.getLong(1))
                        System.out.println(result.getLong(1) == result1.getLong(1));
                }


                conn.close();
                conn1.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("NO CONNECTION =(");
        }
    }
}
