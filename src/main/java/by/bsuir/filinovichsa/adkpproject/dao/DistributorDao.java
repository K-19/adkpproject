package by.bsuir.filinovichsa.adkpproject.dao;

import by.bsuir.filinovichsa.adkpproject.users.Advertiser;
import by.bsuir.filinovichsa.adkpproject.users.BankAccount;
import by.bsuir.filinovichsa.adkpproject.users.Distributor;
import by.bsuir.filinovichsa.adkpproject.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

public class DistributorDao extends AbstractDao{
    public Distributor findById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        Distributor user = session.get(Distributor.class, id);
        if (user != null)
            user.load();
        tx1.commit();
        session.close();
        return user;
    }

    public Distributor findByLoginAndPassword(String login, int password) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();

        Query query = session.createQuery("from Distributor where login = :login and password = :password");
        query.setParameter("login", login);
        query.setParameter("password", password);
        Distributor distributor;
        try {
            distributor = (Distributor) query.getSingleResult();
        } catch(NoResultException e) {
            tx1.commit();
            session.close();
            return null;
        }
        if (distributor != null) {
            sortBankAccounts(distributor);
            distributor.load();
        }
        tx1.commit();
        session.close();
        return distributor;
    }

    public List<Distributor> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        List<Distributor> list = session.createQuery("FROM Distributor").list();
        for (Distributor distributor : list) {
            distributor.load();
        }
        tx1.commit();
        session.close();
        return list;
    }

    public void save(Distributor user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    public void update(Distributor user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }

    public void delete(Distributor user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }
}
