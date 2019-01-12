package com.podval.services;

import org.javatuples.Pair;

import java.util.List;

public interface IBookService extends IService {
    List getDifferentPrices();
    List getDifferentNames();

    /*night forces to do such name. if i have time, i'll redo it  */
    List getBooksContainingWordInNameOrWithGreaterPrice(String word, Integer price);
    List getBooksContainingWordInNameOrWithSpecialPriceTest();
    List<Pair> getNameAndPriceOfBooksContainingWordInNameOrWithGreaterPrice(String word, Integer price);
    List<Pair> getNameAndPriceOfBooksContainingWordInNameOrWithSpecialPriceTest();
    List getPurchasesWithBooksBuyedInStorageAreaContainedInStockMoreThanCount(Integer count);
    List getBooksInfoBuyedInStorageAreaContainedInStockMoreThanCount(Integer count);
}
