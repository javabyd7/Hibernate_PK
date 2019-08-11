package pl.sda.jdbc.hibernate.config;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sf =
            new Configuration()
                    .configure()
                    .buildSessionFactory();

    private static Session session = null;

    public static Session getSession(){
        if(session == null){
            System.out.println("Otwieram sesje");
            session = sf.openSession();
        }
        return session;
    }

    public static void closeSession(){
        if(session != null && !session.isOpen()){
            session.close();
            session = null;
        }
    }

    public static SessionFactory getSessionFactory(){
        if(sf == null){
            sf = (SessionFactory) new HibernateUtil();
        }
        return sf;
    }

    public static void closeConnection(){
        session.close();
        sf.close();
    }
}