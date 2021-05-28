package by.bsuir.filinovichsa.adkpproject.utils;

import by.bsuir.filinovichsa.adkpproject.ad.*;
import by.bsuir.filinovichsa.adkpproject.products.Deal;
import by.bsuir.filinovichsa.adkpproject.products.Product;
import by.bsuir.filinovichsa.adkpproject.support.SupportMessage;
import by.bsuir.filinovichsa.adkpproject.users.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    public HibernateSessionFactoryUtil() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Advertiser.class);
                configuration.addAnnotatedClass(Distributor.class);
                configuration.addAnnotatedClass(AbstractUser.class);
                configuration.addAnnotatedClass(BankAccount.class);
                configuration.addAnnotatedClass(Product.class);
                configuration.addAnnotatedClass(AbstractAd.class);
                configuration.addAnnotatedClass(AirshipAd.class);
                configuration.addAnnotatedClass(BalloonAd.class);
                configuration.addAnnotatedClass(SupportMessage.class);
                configuration.addAnnotatedClass(Admin.class);

                configuration.addAnnotatedClass(BroadcastingAd.class);
                configuration.addAnnotatedClass(EventAd.class);//TODO:
                configuration.addAnnotatedClass(InternetAd.class);//TODO:
                configuration.addAnnotatedClass(MediaNetAd.class);//TODO:
                configuration.addAnnotatedClass(MediaPrintedAd.class);//TODO:
                configuration.addAnnotatedClass(OthPrintedAd.class);//TODO:
                configuration.addAnnotatedClass(OutdoorAd.class);//TODO:
                configuration.addAnnotatedClass(SouvenirAd.class);//TODO:

                configuration.addAnnotatedClass(Deal.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                System.out.println("Exception: " + e);
            }
        }
        return sessionFactory;
    }
}

