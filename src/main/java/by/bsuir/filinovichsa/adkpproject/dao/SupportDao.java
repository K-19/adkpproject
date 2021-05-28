package by.bsuir.filinovichsa.adkpproject.dao;

import by.bsuir.filinovichsa.adkpproject.products.Product;
import by.bsuir.filinovichsa.adkpproject.support.SupportMessage;
import by.bsuir.filinovichsa.adkpproject.users.AbstractUser;
import by.bsuir.filinovichsa.adkpproject.users.Distributor;
import by.bsuir.filinovichsa.adkpproject.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SupportDao {
    public SupportMessage findById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        SupportMessage message = session.get(SupportMessage.class, id);
        message.getUser().load();
        tx1.commit();
        session.close();
        return message;
    }

    public List<SupportMessage> selectAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        List<SupportMessage> list = session.createQuery("FROM SupportMessage").list();
        for (SupportMessage message : list) {
            message.getUser().load();
        }
        tx1.commit();
        session.close();
        return list;
    }

    public void save(SupportMessage message) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(message);
        tx1.commit();
        session.close();
    }

    public void update(SupportMessage message) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(message);
        tx1.commit();
        session.close();
    }

    public void delete(SupportMessage message) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(message);
        tx1.commit();
        session.close();
    }
}
