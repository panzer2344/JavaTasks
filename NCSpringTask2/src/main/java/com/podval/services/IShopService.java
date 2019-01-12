package com.podval.services;

import java.util.List;

public interface IShopService extends IService {
    List getShopsByDistricts(String... districtName);
    List getShopsInSovietAndSormovoDistricts();
    List getShopsInOtherDistrictsWhereBuyPurchasersWithDiscountBetween(String exceptedDistrict, Integer leftDiscountBorder, Integer rightDiscountBorder);
}
