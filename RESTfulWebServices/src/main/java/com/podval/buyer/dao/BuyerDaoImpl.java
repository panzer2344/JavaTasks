package com.podval.buyer.dao;

import com.podval.buyer.models.Buyer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository("BuyerDao")
@Transactional
public class BuyerDaoImpl extends BuyerDao {

    public BuyerDaoImpl(){
        super();
    }

    @Override
    public Buyer findById(int id) {
        return getSession().get(Buyer.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Buyer> findAll() {
        CriteriaQuery criteria = getCriteriaBuilder().createQuery(Buyer.class);
        Root<Buyer> root = criteria.from(Buyer.class);
        criteria.select(root);
        return getSession().createQuery(criteria).getResultList();
    }

    @Override
    public void save(Buyer buyer) {
        getSession().save(buyer);
    }

    @Override
    public void updateById(Integer id, Buyer buyer) {
        //getSession().update(buyer);
        Buyer oldBuyer = getSession().byId(Buyer.class).load(id);
        oldBuyer.setLastName(buyer.getLastName());
        oldBuyer.setResidenceArea(buyer.getResidenceArea());
        oldBuyer.setDiscount(buyer.getDiscount());
        getSession().flush();
    }

    @Override
    public Boolean deleteById(Integer id) {
        Buyer buyer = getSession().byId(Buyer.class).load(id);
        if(buyer == null)
            return false;
        getSession().delete(buyer);
        getSession().flush();
        return true;
    }

    @Override
    public List<Integer> getAllId(){
        CriteriaQuery<Integer> criteriaQuery = getCriteriaBuilder().createQuery(Integer.class);
        Root<Buyer> buyerRoot = criteriaQuery.from(Buyer.class);
        criteriaQuery.select(buyerRoot.<Integer>get("id"));
        return getSession().createQuery(criteriaQuery).getResultList();
    }

    @Override
    public Integer deleteAll(){
        return getSession().createQuery("delete from " + Buyer.class.getName()).executeUpdate();
    }
}
