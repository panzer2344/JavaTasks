package com.podval.dao;

import com.podval.models.IModel;
import com.podval.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.function.BiConsumer;

public class BasicTransactionImpl implements IBasicTransaction{
    @Override
    public void basicTransaction(BiConsumer<Session, IModel> sessionFunction, IModel model) {
        Session session = HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession();
        Transaction transaction = session.beginTransaction();
        sessionFunction.accept(session, model);
        transaction.commit();
        session.close();
    }
}
