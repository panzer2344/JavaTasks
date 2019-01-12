package com.podval.dao;

import com.podval.models.Purchaser;

public class PurchaserDao extends BaseDaoImpl  {

    public PurchaserDao() {
        super(Purchaser.class);
    }

    private PurchaserDao(Class modelClass) {
        super(modelClass);
    }

    /*public Purchaser findById(int id){
        return HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .get(Purchaser.class, id);
    }

    public void save(Purchaser purchaser){
        Session session = HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession();
        Transaction transaction = session.beginTransaction();
        session.save(purchaser);
        transaction.commit();
        session.close();
    }

    public void update(Purchaser purchaser){
        Session session = HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession();
        Transaction transaction = session.beginTransaction();
        session.update(purchaser);
        transaction.commit();
        session.close();
    }

    public void delete(Purchaser purchaser){
        Session session = HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(purchaser);
        transaction.commit();
        session.close();
    }

    public List<Purchaser> findAll(){
        List<Purchaser> purchasers = (List<Purchaser>) HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createQuery("From com.podval.models.Purchaser", Purchaser.class)
                .list();
        return purchasers;

    }*/
}
