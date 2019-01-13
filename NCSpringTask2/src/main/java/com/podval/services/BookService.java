package com.podval.services;

import com.podval.dao.BookDao;
import com.podval.dao.PurchaseDao;
import com.podval.dao.ShopDao;
import com.podval.models.Book;
import com.podval.models.Purchase;
import com.podval.models.Shop;
import org.javatuples.Pair;
import org.javatuples.Quartet;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BookService extends ServiceImpl implements IBookService {

    //protected BookDao bookDao = new BookDao();

    public BookService() {
        super(new BookDao());
    }

    protected PurchaseDao purchaseDao = new PurchaseDao();
    protected ShopDao shopDao = new ShopDao();

    @Override
    public List<Book> findAll() {
        return (List<Book>) super.findAll();
    }

    public List<String> getDifferentNames() {
        //return (List<String>) super.baseDao.getDifferent("name", String.class);
        return getDifferent("name", String.class);
    }

    public List<Integer> getDifferentPrices() {
        //return (List<Integer>) super.baseDao.getDifferent("price", Integer.class);
        return getDifferent("price", Integer.class);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Book> getBooksContainingWordInNameOrWithGreaterPrice(String word, Integer price) {
        return getModelsWithRestrictions("name like '%" + word + "%' or price > " + price + " order by price desc");
    }

    @Override
    public List<Book> getBooksContainingWordInNameOrWithSpecialPriceTest() {
        return getBooksContainingWordInNameOrWithGreaterPrice("Windows", 20000);
    }

    @Override
    public List<Pair> getNameAndPriceOfBooksContainingWordInNameOrWithGreaterPrice(String word, Integer price) {
        List<Pair> pairList = new LinkedList<>();
        for (Book book : getBooksContainingWordInNameOrWithGreaterPrice(word, price)) {
            pairList.add(new Pair<>(book.getName(), book.getPrice()));
        }
        return pairList;
    }

    @Override
    public List<Pair> getNameAndPriceOfBooksContainingWordInNameOrWithSpecialPriceTest() {
        return getNameAndPriceOfBooksContainingWordInNameOrWithGreaterPrice("Windows", 20000);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Purchase> getPurchasesWithBooksBuyedInStorageAreaContainedInStockMoreThanCount(Integer count) {
        //List<Purchase> purchaseList = purchaseDao.
        List<Book> books = findAll();
        Map<Integer, Book> bookMap = new HashMap<>();
        for (Book book : books) {
            bookMap.put(book.getId(), book);
        }
        List<Purchase> purchaseList = new LinkedList<>();
        for (Purchase purchase : purchaseDao.getBuyedInStorageArea()) {
            if (bookMap.get(purchase.getBookId()).getCount() > count)
                purchaseList.add(purchase);
        }
        return purchaseList;
        //return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Quartet> getBooksInfoBuyedInStorageAreaContainedInStockMoreThanCount(Integer count) {

        List<Book> books = findAll();
        Map<Integer, Book> bookMap = new HashMap<>();
        for (Book book : books) {
            bookMap.put(book.getId(), book);
        }

        List<Shop> shops = shopDao.findAll();
        Map<Integer, Shop> shopMap = new HashMap<>();
        for (Shop shop : shops) {
            shopMap.put(shop.getId(), shop);
        }

        List<Quartet> bookInfoList = new LinkedList<>();
        for (Purchase purchase : purchaseDao.getBuyedInStorageArea()) {
            Book book = bookMap.get(purchase.getBookId());
            if (book.getCount() > count)
                bookInfoList.add(new Quartet<>(
                        book.getName(),
                        shopMap.get(purchase.getSellerId()).getArea(),
                        purchase.getCount(),
                        purchase.getSum()
                ));
        }
        return bookInfoList;
    }
}
