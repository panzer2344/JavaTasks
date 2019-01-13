package com.podval.services;

import com.podval.dao.BookDao;
import com.podval.dao.PurchaseDao;
import com.podval.dao.PurchaserDao;
import com.podval.dao.ShopDao;
import com.podval.models.*;
import org.javatuples.Pair;
import org.javatuples.Quintet;
import org.javatuples.Triplet;

import java.sql.Timestamp;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.*;

public class PurchaseService extends ServiceImpl implements IPurchaseService {


    protected PurchaserDao purchaserDao = new PurchaserDao();
    protected ShopDao shopDao = new ShopDao();
    protected BookDao bookDao = new BookDao();

    public PurchaseService() {
        super(new PurchaseDao());
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Purchase> findAll() {
        return (List<Purchase>) super.findAll();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<String> getDifferentMonth() {

        List<Timestamp> dates = getDifferent("date", Timestamp.class);
        List<String> months = new LinkedList<>();

        for (Timestamp date : dates) {
            Month month = Month.of(date.getMonth() + 1);
            Locale loc = Locale.forLanguageTag("ru");
            String curStringMonth = month.getDisplayName(TextStyle.FULL_STANDALONE, loc);
            if (!months.contains(curStringMonth))
                months.add(curStringMonth);
        }

        return months;
    }

    @Override
    public Purchaser getPurchaserByPurchaseId(int id) {
        return (Purchaser) purchaserDao.findById(
                ((Purchase) find(id))
                        .getPurchaserId()
        );
    }

    @Override
    public Purchaser getPurchaserByPurchase(Purchase purchase) {
        return getPurchaserByPurchaseId(purchase.getId());
    }

    @Override
    public String getPurchaserLastNameByPurchaseId(int id) {
        return getPurchaserByPurchaseId(id).getLastName();
    }

    @Override
    public String getPurchaserLastNameByPurchase(Purchase purchase) {
        return getPurchaserByPurchase(purchase).getLastName();
    }

    @Override
    public Shop getShopByPurchaseId(int id) {
        return (Shop) shopDao.findById(
                ((Purchase) find(id))
                        .getSellerId()
        );
    }

    @Override
    public Shop getShopByPurhcase(Purchase purchase) {
        return getShopByPurchaseId(purchase.getId());
    }

    @Override
    public String getShopNameByPurchaseId(int id) {
        return getShopByPurchaseId(id).getName();
    }

    @Override
    public String getShopNameByPurchase(Purchase purchase) {
        return getShopByPurhcase(purchase).getName();
    }

    @Override
    public Pair<String, String> getPurchaserLastNameAndShopNameByPurchaseId(int id) {
        return new Pair<>(getPurchaserLastNameByPurchaseId(id), getShopNameByPurchaseId(id));
    }

    @Override
    public Pair<String, String> getPurchaserLastNameAndShopNameByPurchase(Purchase purchase) {
        return new Pair<>(getPurchaserLastNameByPurchase(purchase), getShopNameByPurchase(purchase));
    }

    @Override
    public Integer getPurchaserDiscountByPurchaseId(int id) {
        return getPurchaserByPurchaseId(id).getDiscount();
    }

    @Override
    public Integer getPurchaserDiscountByPurchase(Purchase purchase) {
        return getPurchaserByPurchase(purchase).getDiscount();
    }

    @Override
    public Book getBookByPurchaseId(int id) {
        return (Book) bookDao.findById(
                ((Purchase) find(id))
                        .getBookId()
        );
    }

    @Override
    public Book getBookByPurchase(Purchase purchase) {
        return getBookByPurchaseId(purchase.getId());
    }

    @Override
    public String getBookNameByPuchaseId(int id) {
        return getBookByPurchaseId(id).getName();
    }

    @Override
    public String getBookNameByPurchase(Purchase purchase) {
        return getBookByPurchase(purchase).getName();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Quintet getDatePurchaserLastNameDiscountBookNameAndBooksCountByPurchaseId(int id) {
        return new Quintet(
                ((Purchase) find(id)).getDate(),
                getPurchaserLastNameByPurchaseId(id),
                getPurchaserDiscountByPurchaseId(id),
                getBookNameByPuchaseId(id),
                (((Purchase) find(id)).getCount())
        );
    }

    @Override
    public Quintet getDatePurchaserLastNameDiscountBookNameAndBooksCountByPurchase(Purchase purchase) {
        return getDatePurchaserLastNameDiscountBookNameAndBooksCountByPurchaseId(purchase.getId());
    }

    @Override
    public List<Pair> getPurchaserLastNameAndShopNameOfAllPurchases() {
        List<Pair> pairList = new LinkedList<>();
        for (Integer id : (List<Integer>) findAllId()) {
            pairList.add(getPurchaserLastNameAndShopNameByPurchaseId(id));
        }
        return pairList;
    }

    @Override
    public List<Quintet> getDatePurchaserLastNameDiscountBookNameAndBooksCountOfAllPurchases() {
        List<Quintet> pairList = new LinkedList<>();
        for (Integer id : (List<Integer>) findAllId()) {
            pairList.add(getDatePurchaserLastNameDiscountBookNameAndBooksCountByPurchaseId(id));
        }
        return pairList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Purchase> getPurchasesWithSumLessThan(Integer conditionSum) {
        return (List<Purchase>) getModelsWithRestrictions("summa < " + conditionSum);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Purchase> getPurchasesWithSumLessOrEqualThan(Integer conditionSum) {
        return (List<Purchase>) getModelsWithRestrictions("summa <= " + conditionSum);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Purchase> getPurchasesWithSumGreaterThan(Integer conditionSum) {
        return (List<Purchase>) getModelsWithRestrictions("summa > " + conditionSum);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Purchase> getPurchasesWithSumGreaterOrEqualThan(Integer conditionSum) {
        return (List<Purchase>) getModelsWithRestrictions("summa >= " + conditionSum);
    }

    @SuppressWarnings("unchecked")
    private List<Purchase> filterPurchasesListByBuingInPurchasersOwnArea(List<Purchase> purchaseList) {
        List<Purchase> filteredPurchaseList = new LinkedList<>();
        for (Purchase purchase : purchaseList) {
            if (getPurchaserByPurchase(purchase).getResidenceArea().equals(
                    getShopByPurhcase(purchase).getArea()
            )) {
                filteredPurchaseList.add(purchase);
            }
        }
        return filteredPurchaseList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Purchase> getPurchasesByPurchasersInOwnAreaWithMonthLessThen(Month month) {
        List<Purchase> purchaseList = (List<Purchase>) getModelsWithRestrictions("month(date) < " + month.getValue());
        return filterPurchasesListByBuingInPurchasersOwnArea(purchaseList);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Purchase> getPurchasesByPurchasersInOwnAreaWithMonthLessOrEqualThen(Month month) {
        List<Purchase> purchaseList = (List<Purchase>) getModelsWithRestrictions("month(date) <= " + month.getValue());
        return filterPurchasesListByBuingInPurchasersOwnArea(purchaseList);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Purchase> getPurchasesByPurchasersInOwnAreaWithMonthGreaterThen(Month month) {
        List<Purchase> purchaseList = (List<Purchase>) getModelsWithRestrictions("month(date) > " + month.getValue());
        return filterPurchasesListByBuingInPurchasersOwnArea(purchaseList);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Purchase> getPurchasesByPurchasersInOwnAreaWithMonthGreaterOrEqualThen(Month month) {
        List<Purchase> purchaseList = (List<Purchase>) getModelsWithRestrictions("month(date) >= " + month.getValue());
        return filterPurchasesListByBuingInPurchasersOwnArea(purchaseList);
    }

    @SuppressWarnings("unchecked")
    public List<Triplet> getInfoAboutPurchaseWithSumGraterOrEqualThan(Integer sum) {
        List<Triplet> purchasesInfoList = new LinkedList<>();//getPurchasesWithSumGreaterOrEqualThan(sum);
        for (Purchase purchase : getPurchasesWithSumGreaterOrEqualThan(sum)) {//purchasesList){
            purchasesInfoList.add(
                    new Triplet(
                            purchase.getId(),
                            getPurchaserLastNameByPurchase(purchase),
                            purchase.getDate()
                    ));
        }
        return purchasesInfoList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Triplet> getPurchaseInfoByPurchasersInOwnAreaWithMonthLessThen(Month month) {
        List<Triplet> infoList = new LinkedList<>();
        for (Purchase purchase :
                filterPurchasesListByBuingInPurchasersOwnArea(
                        (List<Purchase>) getModelsWithRestrictions("month(date) < " + month.getValue())
                )
        ) {
            Purchaser purchaser = (Purchaser) purchaserDao.findById(purchase.getPurchaserId());
            infoList.add(new Triplet(
                    purchaser.getLastName(),
                    purchaser.getResidenceArea(),
                    purchase.getDate()
            ));
        }
        return infoList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Triplet> getPurchaseInfoByPurchasersInOwnAreaWithMonthLessOrEqualThen(Month month) {
        List<Triplet> infoList = new LinkedList<>();
        for (Purchase purchase :
                filterPurchasesListByBuingInPurchasersOwnArea(
                        (List<Purchase>) getModelsWithRestrictions("month(date) <= " + month.getValue())
                )
        ) {
            Purchaser purchaser = (Purchaser) purchaserDao.findById(purchase.getPurchaserId());
            infoList.add(new Triplet(
                    purchaser.getLastName(),
                    purchaser.getResidenceArea(),
                    purchase.getDate()
            ));
        }
        return infoList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Triplet> getPurchaseInfoByPurchasersInOwnAreaWithMonthGreaterThen(Month month) {
        List<Triplet> infoList = new LinkedList<>();
        for (Purchase purchase :
                filterPurchasesListByBuingInPurchasersOwnArea(
                        (List<Purchase>) getModelsWithRestrictions("month(date) > " + month.getValue())
                )
        ) {
            Purchaser purchaser = (Purchaser) purchaserDao.findById(purchase.getPurchaserId());
            infoList.add(new Triplet(
                    purchaser.getLastName(),
                    purchaser.getResidenceArea(),
                    purchase.getDate()
            ));
        }
        return infoList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Triplet> getPurchaseInfoByPurchasersInOwnAreaWithMonthGreaterOrEqualThen(Month month) {
        List<Triplet> infoList = new LinkedList<>();
        for (Purchase purchase :
                filterPurchasesListByBuingInPurchasersOwnArea(
                        (List<Purchase>) getModelsWithRestrictions("month(date) >= " + month.getValue())
                )
        ) {
            Purchaser purchaser = (Purchaser) purchaserDao.findById(purchase.getPurchaserId());
            infoList.add(new Triplet(
                    purchaser.getLastName(),
                    purchaser.getResidenceArea(),
                    purchase.getDate()
            ));
        }
        return infoList;
    }

    @Override
    public List<Quintet> getDatePurchaserLastNameDiscountBookNameAndBooksCountByPurchase() {
        List<Quintet> quintetList = new LinkedList<>();
        for (Integer id : (List<Integer>) findAllId()) {
            quintetList.add(getDatePurchaserLastNameDiscountBookNameAndBooksCountByPurchaseId(id));
        }
        return quintetList;
    }
}
