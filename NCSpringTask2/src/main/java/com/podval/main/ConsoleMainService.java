package com.podval.main;

import com.podval.services.BookService;
import com.podval.services.PurchaseService;
import com.podval.services.PurchaserService;
import com.podval.services.ShopService;

import java.time.Month;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConsoleMainService implements IConsoleMainService {

    ConsoleBookService consoleBookService = new ConsoleBookService();
    ConsolePurchaserService consolePurchaserService = new ConsolePurchaserService();
    ConsolePurchaseService consolePurchaseService = new ConsolePurchaseService();
    ConsoleShopService consoleShopService = new ConsoleShopService();

    @Override
    public Integer menu() {
        System.out.println("With what type of objects do u want to work?");
        System.out.println("1. Books");
        System.out.println("2. Purchasers");
        System.out.println("3. Shops");
        System.out.println("4. Purchases");
        System.out.println("5. Run tests !!!");

        System.out.print("Input: ");
        int result = new Scanner(System.in).nextInt();
        System.out.println();

        return result;
    }

    @Override
    public Integer processAnswers(Integer answer) {
        switch (answer){
            case 0:
                return 0;
            case 1:
                //abstractProcessing(Main::processAnswerBooks, Main::menuBooks);
                abstractProcessing(
                        consoleBookService::processAnswer, consoleBookService::menu
                );
                return 1;
            case 2:
                //abstractProcessing(Main::processAnswerPurchasers, Main::menuPurchasers);
                abstractProcessing(
                        consolePurchaserService::processAnswer, consolePurchaserService::menu
                );
                return 2;
            case 3:
                abstractProcessing(
                            consoleShopService::processAnswer, consoleShopService::menu
                );
                return 3;
            case 4:
                abstractProcessing(
                        consolePurchaseService::processAnswer, consolePurchaseService::menu
                );
                return 4;
            case 5:
                runTests();
            default:
                return -2;
        }
    }

    @Override
    public Integer abstractProcessing(Function<Integer, Integer> concreteProcess, Supplier<Integer> menuFunction) {
        int status = -1;
        while (status != 0){
            //status = processAnswerPurchasers(menuPurchasers());
            status = (Integer) concreteProcess.apply(menuFunction.get());
            if(status == -2) {
                System.out.println("Bad answer.");
            }
        }

        processAnswers(menu());

        return status;
    }

    @Override
    public void run() {
        processAnswers(menu());
    }

    private void runTests(){
        BookService bookService = new BookService();
        PurchaserService purchaserService = new PurchaserService();
        PurchaseService purchaseService = new PurchaseService();
        ShopService shopService = new ShopService();

        System.out.println("=========  2  =============");
        System.out.println();

        System.out.println("a. ");
        System.out.println(bookService.getDifferentNames());
        System.out.println(bookService.getDifferentPrices());
        System.out.println();


        System.out.println("b.");
        System.out.println(purchaserService.getDifferentResidenceArea());
        System.out.println();


        System.out.println("c. ");
        System.out.println(purchaseService.getDifferentMonth());
        System.out.println();

        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("==========  3  =============");
        System.out.println();

        System.out.println("a. ");
        System.out.println(purchaserService.getLastNamesAndDiscountsOfPurchasersInNizhegorodskiyDisctrict());
        System.out.println();

        System.out.println("b.");
        System.out.println(shopService.getShopsInSovietAndSormovoDistricts());
        System.out.println();

        System.out.println("c. ");
        System.out.println(bookService.getNameAndPriceOfBooksContainingWordInNameOrWithSpecialPriceTest());
        System.out.println();

        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("==========  4  ===========");
        System.out.println();

        System.out.println("a. ");
        System.out.println(purchaseService.getPurchaserLastNameAndShopNameOfAllPurchases());
        System.out.println();

        System.out.println("b. ");
        System.out.println(purchaseService.getDatePurchaserLastNameDiscountBookNameAndBooksCountByPurchase());
        System.out.println();

        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("========= 5 ============");
        System.out.println();

        System.out.println("a. ");
        System.out.println(purchaseService.getInfoAboutPurchaseWithSumGraterOrEqualThan(60000));
        System.out.println();

        System.out.println("b. ");
        System.out.println(purchaseService.getPurchasesByPurchasersInOwnAreaWithMonthGreaterOrEqualThen(Month.MARCH));
        System.out.println();

        System.out.println("c. ");
        System.out.println(shopService.getShopsInOtherDistrictsWhereBuyPurchasersWithDiscountBetween(
                "Автозаводский",
                10,
                15
                ));
        System.out.println();

        System.out.println("d. ");
        System.out.println(bookService.getBooksInfoBuyedInStorageAreaContainedInStockMoreThanCount(10));
        System.out.println();

        processAnswers(menu());

    }
}
