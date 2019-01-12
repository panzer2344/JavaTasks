package com.podval.services;

import com.podval.models.Book;
import com.podval.models.Purchase;
import com.podval.models.Purchaser;
import com.podval.models.Shop;
import org.javatuples.Pair;
import org.javatuples.Quintet;

import java.time.Month;
import java.util.List;

public interface IPurchaseService extends IService {
    List getDifferentMonth();

    Purchaser getPurchaserByPurchaseId(int id);

    Purchaser getPurchaserByPurchase(Purchase purchase);

    String getPurchaserLastNameByPurchaseId(int id);

    String getPurchaserLastNameByPurchase(Purchase purchase);

    Shop getShopByPurchaseId(int id);

    Shop getShopByPurhcase(Purchase purchase);

    String getShopNameByPurchaseId(int id);

    String getShopNameByPurchase(Purchase purchase);

    Pair<String, String> getPurchaserLastNameAndShopNameByPurchaseId(int id);

    Pair<String, String> getPurchaserLastNameAndShopNameByPurchase(Purchase purchase);

    Integer getPurchaserDiscountByPurchaseId(int id);

    Integer getPurchaserDiscountByPurchase(Purchase purchase);

    Book getBookByPurchaseId(int id);

    Book getBookByPurchase(Purchase purchase);

    String getBookNameByPuchaseId(int id);

    String getBookNameByPurchase(Purchase purchase);

    Quintet getDatePurchaserLastNameDiscountBookNameAndBooksCountByPurchaseId(int id);

    Quintet getDatePurchaserLastNameDiscountBookNameAndBooksCountByPurchase(Purchase purchase);

    List<Quintet> getDatePurchaserLastNameDiscountBookNameAndBooksCountByPurchase();

    List getPurchaserLastNameAndShopNameOfAllPurchases();

    List getDatePurchaserLastNameDiscountBookNameAndBooksCountOfAllPurchases();

    List getPurchasesWithSumLessThan(Integer conditionSum);

    List getPurchasesWithSumLessOrEqualThan(Integer conditionSum);

    List getPurchasesWithSumGreaterThan(Integer conditionSum);

    List getPurchasesWithSumGreaterOrEqualThan(Integer conditionSum);

    List getPurchasesByPurchasersInOwnAreaWithMonthLessThen(Month month);

    List getPurchasesByPurchasersInOwnAreaWithMonthLessOrEqualThen(Month month);

    List getPurchasesByPurchasersInOwnAreaWithMonthGreaterThen(Month month);

    List getPurchasesByPurchasersInOwnAreaWithMonthGreaterOrEqualThen(Month month);

    List getPurchaseInfoByPurchasersInOwnAreaWithMonthLessThen(Month month);

    List getPurchaseInfoByPurchasersInOwnAreaWithMonthLessOrEqualThen(Month month);

    List getPurchaseInfoByPurchasersInOwnAreaWithMonthGreaterThen(Month month);

    List getPurchaseInfoByPurchasersInOwnAreaWithMonthGreaterOrEqualThen(Month month);

}
