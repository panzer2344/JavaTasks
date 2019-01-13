package com.podval.buyer.services;

import com.podval.buyer.dao.BuyerDao;
import com.podval.buyer.models.Buyer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class BuyerService {

    @Autowired
    private BuyerDao buyerDao;

    public abstract Buyer findById(int id);

    public abstract List<Buyer> findAll();

    public abstract void save(Buyer buyer);

    public abstract void updateById(Integer id, Buyer buyer);

    public abstract Boolean deleteById(Integer id);

    public BuyerDao getBuyerDao() {
        return buyerDao;
    }

    public abstract List<Integer> getAllId();

    public abstract Integer deleteAll();
}
