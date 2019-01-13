package com.podval.buyer.dao;

import com.podval.buyer.models.Buyer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public abstract class BuyerDao {

    public BuyerDao(){

    }

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    protected CriteriaBuilder getCriteriaBuilder(){
        return getSession().getCriteriaBuilder();
    }

    public abstract Buyer findById(int id);

    public abstract List<Buyer> findAll();

    public abstract void save(Buyer buyer);

    public abstract void updateById(Integer id, Buyer buyer);

    public abstract Boolean deleteById(Integer id);

    public abstract List<Integer> getAllId();

    public abstract Integer deleteAll();
}
