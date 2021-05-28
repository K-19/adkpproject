package by.bsuir.filinovichsa.adkpproject.dao;

import by.bsuir.filinovichsa.adkpproject.ad.AbstractAd;
import by.bsuir.filinovichsa.adkpproject.users.Admin;
import by.bsuir.filinovichsa.adkpproject.users.Advertiser;
import by.bsuir.filinovichsa.adkpproject.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

public class AdminDao {
    public Admin findById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        Admin ad = session.get(Admin.class, id);
        tx1.commit();
        session.close();
        return ad;
    }

    public Admin findByLoginAndPassword(String login, int password) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();

        Query query = session.createQuery("from Admin where login = :login and password = :password");
        query.setParameter("login", login);
        query.setParameter("password", password);
        Admin admin;
        try {
            admin = (Admin) query.getSingleResult();
        } catch (NoResultException e) {
            tx1.commit();
            session.close();
            return null;
        }
        tx1.commit();
        session.close();
        return admin;
    }

    public List<Admin> selectAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        List<Admin> list = session.createQuery("FROM Admin").list();
        tx1.commit();
        session.close();
        return list;
    }

    public void save(Admin admin) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(admin);
        tx1.commit();
        session.close();
    }

    public void update(Admin admin) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(admin);
        tx1.commit();
        session.close();
    }

    public void delete(Admin admin) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(admin);
        tx1.commit();
        session.close();
    }
}
