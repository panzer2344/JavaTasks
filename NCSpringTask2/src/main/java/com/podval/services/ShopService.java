package com.podval.services;

import com.podval.dao.PurchaseDao;
import com.podval.dao.PurchaserDao;
import com.podval.dao.ShopDao;
import com.podval.models.Purchase;
import com.podval.models.Purchaser;
import com.podval.models.Shop;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class ShopService extends ServiceImpl implements IShopService {

    protected PurchaserDao purchaserDao = new PurchaserDao();
    protected PurchaseDao purchaseDao = new PurchaseDao();

    public ShopService() {
        super(new ShopDao());
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Shop> findAll() {
        return (List<Shop>) super.findAll();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Shop> getShopsByDistricts(String... districtsNames) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < districtsNames.length - 1; i++) {
            stringBuilder.append("area = '").append(districtsNames[i]).append("' or ");
        }
        stringBuilder.append("area = '").append(districtsNames[districtsNames.length - 1]).append("'");
        return getModelsWithRestrictions(stringBuilder.toString());
    }

    @Override
    public List<Shop> getShopsInSovietAndSormovoDistricts() {
        return getShopsByDistricts("Сормовский", "Советский");
    }

    private String listToString(List list){
        StringBuilder stringBuilder = new StringBuilder();
        for (Object element : list){
            stringBuilder.append(element);
            if(list.indexOf(element) < list.size() - 1){
                stringBuilder.append(", ");
            }
        }
        return stringBuilder.toString();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Shop> getShopsInOtherDistrictsWhereBuyPurchasersWithDiscountBetween(String exceptedDistrict, Integer leftDiscountBorder, Integer rightDiscountBorder) {
        List<Integer> shopIds = new LinkedList<>();
        List<Integer> purchaserIds = new LinkedList<>();

        List<Shop> shopList = (List<Shop>) getModelsWithRestrictions("area <> '" + exceptedDistrict + "'");
        List<Purchaser> purchaserList = (List<Purchaser>) purchaserDao.getModelsWithRestrictions("discount >= " + leftDiscountBorder + " and discount < " + rightDiscountBorder);

        for(Shop shop : shopList){
            shopIds.add(shop.getId());
        }

        for (Purchaser purchaser : purchaserList){
            purchaserIds.add(purchaser.getId());
        }

        List<Purchase> purchaseList = purchaseDao.getModelsWithRestrictions("seller in (" + listToString(shopIds) + ") and purchaser in (" + listToString(purchaserIds) + ")");
        List<Shop> outputShopList = new LinkedList<>();
        HashSet<Integer> outputShopIds = new HashSet<>();

        for(Purchase purchase : purchaseList){
            outputShopIds.add(purchase.getSellerId());
        }

        for (Integer id : outputShopIds){
            outputShopList.add((Shop) find(id));
        }

        return outputShopList;
    }
}
