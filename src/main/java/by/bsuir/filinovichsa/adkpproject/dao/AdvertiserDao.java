package by.bsuir.filinovichsa.adkpproject.dao;

import by.bsuir.filinovichsa.adkpproject.products.Product;
import by.bsuir.filinovichsa.adkpproject.users.Advertiser;
import by.bsuir.filinovichsa.adkpproject.users.BankAccount;
import by.bsuir.filinovichsa.adkpproject.users.Distributor;
import by.bsuir.filinovichsa.adkpproject.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;

public class AdvertiserDao extends AbstractDao{
    public Advertiser findById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        Advertiser user = session.get(Advertiser.class, id);
        if (user != null)
            user.load();
        tx1.commit();
        session.close();
        return user;
    }

    public Advertiser findByLoginAndPassword(String login, int password) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();

        Query query = session.createQuery("from Advertiser where login = :login and password = :password");
        query.setParameter("login", login);
        query.setParameter("password", password);
        Advertiser advertiser;
        try {
            advertiser = (Advertiser) query.getSingleResult();
        } catch (NoResultException e) {
            tx1.commit();
            session.close();
            return null;
        }
        if (advertiser != null) {
            sortBankAccounts(advertiser);
            sortProducts(advertiser);
            advertiser.load();
        }
        tx1.commit();
        session.close();
        return advertiser;
    }

    public List<Advertiser> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        List<Advertiser> list = session.createQuery("FROM Advertiser").list();
        for (Advertiser advertiser : list) {
            advertiser.load();
        }
        tx1.commit();
        session.close();
        return list;
    }

    public void save(Advertiser user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    public void update(Advertiser user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }

    public void delete(Advertiser user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }
}
