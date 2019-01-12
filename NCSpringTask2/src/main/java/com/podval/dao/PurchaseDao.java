package com.podval.dao;

import com.podval.models.Purchase;

import java.util.List;

public class PurchaseDao extends BaseDaoImpl {

    public PurchaseDao() {
        super(Purchase.class);
    }

    private PurchaseDao(Class modelClass) {
        super(modelClass);
    }

    @SuppressWarnings("unchecked")
    public List<Purchase> getBuyedInStorageArea() {
        /*return getModelsWithRestrictionsAndInnerJoin(
                "true",
                Shop.class.getName() + " shop" //+
                        *//*" inner join " + Purchaser.class.getName() + " as purchaser"*//*
                );*/
        /*String[] strings = Shop.class.getName().split("\\.");
        String name = strings[strings.length - 1].toLowerCase();
        return  getModelsWithInnerJoin(name + " on " + name + ".");*/
        return getModelsWithRestrictionAndInnerJoin(
                "shop", "s", "s.id = t.seller",
                "purchaser", "p", "p.id = t.purchaser",
                "s.area = p.residence_area"
        );
    }


}
