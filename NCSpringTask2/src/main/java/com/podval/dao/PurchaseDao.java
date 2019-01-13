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
        return getModelsWithRestrictionAndInnerJoin(
                "shop", "s", "s.id = t.seller",
                "purchaser", "p", "p.id = t.purchaser",
                "s.area = p.residence_area"
        );
    }


}
