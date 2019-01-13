package com.podval.buyer.services;

import com.podval.buyer.models.Buyer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("BuyerService")
@Transactional(readOnly = true)
public class BuyerServiceImpl extends BuyerService {

    @Override
    public Buyer findById(int id) {
        return getBuyerDao().findById(id);
    }

    @Override
    public List<Buyer> findAll() {
        return getBuyerDao().findAll();
    }

    @Override
    public void save(Buyer buyer) {
        getBuyerDao().save(buyer);
    }

    @Override
    public void updateById(Integer id, Buyer buyer) {
        getBuyerDao().updateById(id, buyer);
    }

    @Override
    public Boolean deleteById(Integer id) {
        return getBuyerDao().deleteById(id);
    }

    @Override
    public List<Integer> getAllId(){
        return getBuyerDao().getAllId();
    }


    @Override
    public Integer deleteAll() {
        return getBuyerDao().deleteAll();
    }
}
