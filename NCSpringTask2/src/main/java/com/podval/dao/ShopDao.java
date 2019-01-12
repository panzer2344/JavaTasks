package com.podval.dao;

import com.podval.models.Shop;

public class ShopDao extends BaseDaoImpl {

    public ShopDao(){
        super(Shop.class);
    }

    private ShopDao(Class modelClass){
        super(modelClass);
    }

}
