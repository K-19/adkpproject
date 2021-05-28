package by.bsuir.filinovichsa.adkpproject.dao;

import by.bsuir.filinovichsa.adkpproject.products.Deal;
import by.bsuir.filinovichsa.adkpproject.products.Product;
import by.bsuir.filinovichsa.adkpproject.users.BankAccount;
import by.bsuir.filinovichsa.adkpproject.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DealDao {
    public Deal findById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        Deal deal = session.get(Deal.class, id);

        //deal.load();

        deal.getProduct().getOwner().load();
        for (BankAccount account : deal.getProduct().getOwner().getBankAccounts()) {
            account.getIndividualAccount();
        }
        deal.getAd().getDescription();
        deal.getDistributor().getDistributorType().getName();
        for (BankAccount account : deal.getDistributor().getBankAccounts()) {
            account.getIndividualAccount();
        }

        tx1.commit();
        session.close();
        return deal;
    }

    public void save(Deal deal) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(deal);
        tx1.commit();
        session.close();
    }

    public void update(Deal deal) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(deal);
        tx1.commit();
        session.close();
    }

    public void delete(Deal deal) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(deal);
        tx1.commit();
        session.close();
    }

    public void load(Deal deal) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();

        deal.getProduct().getOwner().load();
        deal.getAd().getDescription();
        deal.getDistributor().getDistributorType().getName();

        tx1.commit();
        session.close();
    }
}
