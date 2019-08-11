package pl.sda.jdbc.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import pl.sda.jdbc.hibernate.entity.User;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        SessionFactory sf = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();

        User user = new User("Tomasz", "Kowalski");
        session.save(user);

        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();

    }
}
