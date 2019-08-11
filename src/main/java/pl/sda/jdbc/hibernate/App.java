package pl.sda.jdbc.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sda.jdbc.hibernate.config.HibernateUtil;
import pl.sda.jdbc.hibernate.entity.Author;
import pl.sda.jdbc.hibernate.entity.Book;
import pl.sda.jdbc.hibernate.entity.Category;
import pl.sda.jdbc.hibernate.entity.User;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSession();

        User user = new User("Jan", "Kowalski");

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                HibernateUtil.closeSession();
            }
        }
        session = HibernateUtil.getSession();
        transaction = session.beginTransaction();
        session.save(new User("jan", "kowalski"));
        transaction.commit();
        HibernateUtil.closeSession();

        Category category = new Category();
        category.setName("Fantastyka");
        Set<Author> authors = new HashSet<>(Arrays.asList(
                new Author("Jan", "Kowalski")
        ));
        Book book = new Book();
        book.setCategory(category);
        book.setAuthors(authors);
        book.setTitle("Tytul ksiazki");

        BookDAO bookDAO = new BookDAO();
        bookDAO.insertBook(book);
    }
}