package pl.sda.jdbc.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sda.jdbc.hibernate.config.HibernateUtils;
import pl.sda.jdbc.hibernate.entity.Book;

import java.util.List;

public class BookDAO {

    public Book insertBook(Book book){
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(book);
        transaction.commit();
        HibernateUtils.closeSession();
        return book;
    }

    public List<Book> findAllBooks(){
        Session session = HibernateUtils.getSession();
//        List<Book> books = session.createQuery("SELECT b FROM Book b",
//                Book.class).getResultList();
        List<Book> books = session.getNamedQuery("selectBooks").getResultList();

        return books;
    }


}