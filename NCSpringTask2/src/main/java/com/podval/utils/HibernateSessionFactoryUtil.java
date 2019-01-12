package com.podval.utils;

import com.podval.models.Book;
import com.podval.models.Purchase;
import com.podval.models.Purchaser;
import com.podval.models.Shop;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil(){}

    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null){
            try{
                Configuration configuration = new Configuration().configure();

                configuration.addAnnotatedClass(Purchaser.class);
                configuration.addAnnotatedClass(Book.class);
                configuration.addAnnotatedClass(Purchase.class);
                configuration.addAnnotatedClass(Shop.class);

                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return sessionFactory;
    }
}
