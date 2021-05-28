package by.bsuir.filinovichsa.adkpproject.dao;

import by.bsuir.filinovichsa.adkpproject.ad.AbstractAd;
import by.bsuir.filinovichsa.adkpproject.products.Product;
import by.bsuir.filinovichsa.adkpproject.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AdDao {
    public AbstractAd findById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        AbstractAd ad = session.get(AbstractAd.class, id);
        tx1.commit();
        session.close();
        return ad;
    }

    public void save(AbstractAd ad) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(ad);
        tx1.commit();
        session.close();
    }

    public void update(AbstractAd ad) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(ad);
        tx1.commit();
        session.close();
    }

    public void delete(AbstractAd ad) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(ad);
        tx1.commit();
        session.close();
    }
}
