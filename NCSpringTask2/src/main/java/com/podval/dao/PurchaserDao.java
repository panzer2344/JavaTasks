package com.podval.dao;

import com.podval.models.Purchaser;

public class PurchaserDao extends BaseDaoImpl  {

    public PurchaserDao() {
        super(Purchaser.class);
    }

    private PurchaserDao(Class modelClass) {
        super(modelClass);
    }

}
