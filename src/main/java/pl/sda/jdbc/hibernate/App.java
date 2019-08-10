package pl.sda.jdbc.hibernate;

import org.hibernate.Session;
import pl.sda.jdbc.hibernate.config.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        String sql = "select version()";

        String result = (String) session.createNativeQuery(sql).getSingleResult();
        System.out.println(result);

        session.getTransaction().commit();
        session.close();


        HibernateUtil.shutdown();
    }
}
