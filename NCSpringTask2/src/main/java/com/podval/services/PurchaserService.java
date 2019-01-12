package com.podval.services;

import com.podval.dao.PurchaserDao;
import com.podval.models.Purchaser;
import org.javatuples.Pair;

import java.util.LinkedList;
import java.util.List;

public class PurchaserService extends ServiceImpl implements IPurchaserService {

    //protected PurchaserDao purchaserDao = new PurchaserDao();

    /*public PurchaserService(){
    }

    public Purchaser find(int id){
        return (Purchaser)purchaserDao.findById(id);
    }

    public void save(IModel purchaser){
        purchaserDao.save(purchaser);
    }

    public void delete(IModel purchaser){
        purchaserDao.delete(purchaser);
    }

    public void update(IModel purchaser){
        purchaserDao.update(purchaser);
    }

    public List<Purchaser> findAll(){
        return purchaserDao.findAll();
    }*/

    public PurchaserService() {
        super(new PurchaserDao());
    }

    @Override
    public List<Purchaser> findAll() {
        return (List<Purchaser>) super.findAll();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<String> getDifferentResidenceArea() {
        return getDifferent("residenceArea", String.class);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Purchaser> getPurchesersByResidenseArea(String areaName) {
        return getModelsWithRestrictions("residenceArea = '" + areaName + "'");
    }

    @Override
    public List<Purchaser> getPurchesersInNizhegorodskiyDistrict() {
        return getPurchesersByResidenseArea("Нижегородский");
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Pair> getLastNamesAndDiscountsOfPurchasersInResidenseArea(String areaName) {
        List<Pair> namesAndDiscounts = new LinkedList<>();
        List<Purchaser> purchasers = getPurchesersByResidenseArea(areaName);
        for (Purchaser purchaser : purchasers) {
            namesAndDiscounts.add(new Pair(purchaser.getLastName(), purchaser.getDiscount()));
        }
        return namesAndDiscounts;
    }

    @Override
    public List<Pair> getLastNamesAndDiscountsOfPurchasersInNizhegorodskiyDisctrict() {
        return getLastNamesAndDiscountsOfPurchasersInResidenseArea("Нижегородский");
    }
}
