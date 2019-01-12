package com.podval.dao;

import com.podval.models.IModel;
import com.podval.utils.HibernateSessionFactoryUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import java.util.List;

public class BaseDaoImpl implements IBaseDao {

    protected Class modelClass;
    protected IBasicTransaction basicTransaction = new BasicTransactionImpl();

    public BaseDaoImpl() {
    }

    BaseDaoImpl(Class modelClass) {
        this.modelClass = modelClass;
    }

    @Override
    public IModel findById(int id) {
        return (IModel) HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .get(modelClass, id);
    }

    @Override
    public void save(IModel model) {
        basicTransaction.basicTransaction(Session::save, model);
    }

    @Override
    public void update(IModel model) {
        basicTransaction.basicTransaction(Session::update, model);
    }

    @Override
    public void delete(IModel model) {
        basicTransaction.basicTransaction(Session::delete, model);
    }

    @Override
    public List findAll() {
        return HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createQuery("From " + modelClass.getName(), modelClass)
                .list();
    }

    @Override
    public Integer count() {
        return ((Long) HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createQuery("select count(*) from " + modelClass.getName())
                .iterate()
                .next()
        )
                .intValue();
    }

    @Override
    public List getDifferent(String property, Class propertyClass) {
        return HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createQuery("select distinct " + property + " from " + modelClass.getName())
                //.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .list();
    }

    @Override
    public List getModelsWithRestrictions(String condition) {
        return HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createQuery("from " + modelClass.getName() + " where " + condition)
                .list();

    }

    /*@Override
    public List getModelsWithRestrictionsAndInnerJoin(String condition, String join) {
        return HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createQuery("from " + modelClass.getName() + " inner join " + join + " where " + condition)
                .list();
    }*/

    @Override
    public List getModelsWithRestrictionAndInnerJoin(String joinTableNameA, String pseudonimA, String joinOnA,
                                       String joinTableNameB, String pseudonimB, String joinOnB,
                                       String condition
                                       ) {
        String[] strings = modelClass.getName().split("\\.");
        String name = strings[strings.length - 1].toLowerCase();
        return HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createSQLQuery("select " + "t.* " /*+pseudonimA + ".name "*/ + " from " + name + " as t" +
                        " inner join " + joinTableNameA + " as " + pseudonimA + " on " + joinOnA +
                        " inner join " + joinTableNameB + " as " + pseudonimB + " on " + joinOnB
                        + " where " + condition
                        )
                .addEntity(modelClass)
                .list();
    }
}
