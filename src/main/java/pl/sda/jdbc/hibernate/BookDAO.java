package pl.sda.jdbc.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sda.jdbc.hibernate.config.HibernateUtil;
import pl.sda.jdbc.hibernate.entity.Book;

public class BookDAO {
    public Book insertBook(Book book){
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(book);
        transaction.commit();
        HibernateUtil.closeSession();
        return book;
    }
}
