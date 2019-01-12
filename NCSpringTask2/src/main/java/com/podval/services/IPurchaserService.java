package com.podval.services;

import org.javatuples.Pair;

import java.util.List;

public interface IPurchaserService extends IService {
    List getDifferentResidenceArea();
    List getPurchesersByResidenseArea(String areaName);
    List getPurchesersInNizhegorodskiyDistrict();
    List<Pair> getLastNamesAndDiscountsOfPurchasersInResidenseArea(String areaName);
    List<Pair> getLastNamesAndDiscountsOfPurchasersInNizhegorodskiyDisctrict(); // rofl name, written in 2 am

}
