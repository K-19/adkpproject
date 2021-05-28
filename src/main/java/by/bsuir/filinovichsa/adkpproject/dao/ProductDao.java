package by.bsuir.filinovichsa.adkpproject.dao;

import by.bsuir.filinovichsa.adkpproject.products.Product;
import by.bsuir.filinovichsa.adkpproject.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProductDao {

    public Product findById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        Product product = session.get(Product.class, id);
        product.getOwner().hasProductWithId(0);
        tx1.commit();
        session.close();
        return product;
    }

    public void save(Product product) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(product);
        tx1.commit();
        session.close();
    }

    public void update(Product product) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(product);
        tx1.commit();
        session.close();
    }

    public void delete(Product product) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(product);
        tx1.commit();
        session.close();
    }
}
