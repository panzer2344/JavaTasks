package com.podval.main;

import com.podval.services.BookService;
import com.podval.services.PurchaseService;
import com.podval.services.PurchaserService;
import com.podval.services.ShopService;

import java.time.Month;

public class Main {


    /*private static PurchaserService purchaserService = new PurchaserService();
    private static BookService bookService = new BookService();*/

    /*private static Object getObjectFromInput(String message){
        System.out.print(message);
        Object o = new Scanner(System.in).nextLine().trim();
        System.out.println();
        return o;
    }

    private static Purchaser initPurchaser(){

        System.out.println("------------Init purchaser--------------");

        return new Purchaser(
                (String) getObjectFromInput("Input last name: "),
                (String) getObjectFromInput("Input residence area: "),
                Integer.parseInt((String) getObjectFromInput("Input discount: "))
                );
    }

    private static Book initBook(){

        System.out.println("------------Init book----------------");

        return new Book(
                (String) getObjectFromInput("Input name: "),
                Integer.parseInt((String) getObjectFromInput("Input price: ")),
                (String) getObjectFromInput("Input warehouse: "),
                Integer.parseInt((String) getObjectFromInput("Input count: "))
        );

    }*/

    /*private static int mainMenu(){
        System.out.println("With what type of objects do u want to work?");
        System.out.println("1. Books");
        System.out.println("2. Purchasers");
        System.out.println("3. Shops");
        System.out.println("4. Purchases");

        System.out.print("Input: ");
        int result = new Scanner(System.in).nextInt();
        System.out.println();

        return result;
    }*/

    /*private static int processMainAnswers(int answer){
        switch (answer){
            case 0:
                return 0;
            case 1:
                abstractProcessing(Main::processAnswerBooks, Main::menuBooks);
                return 1;
            case 2:
                abstractProcessing(Main::processAnswerPurchasers, Main::menuPurchasers);
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            default:
                return -2;
        }
    }*/

    /*private static Integer abstractProcessing(Function<Integer, Integer> concreteProcess, Supplier<Integer> menuFunction){
        int status = -1;
        while (status != 0){
            //status = processAnswerPurchasers(menuPurchasers());
            status = (Integer) concreteProcess.apply(menuFunction.get());
            if(status == -2) {
                System.out.println("Bad answer.");
            }
        }

        return status;
    }*/

    /*private static int menuAbstractModel(String modelName){
        System.out.println("What do you want to do?");
        System.out.println("0. Exit");
        System.out.println("1. Add new " + modelName);
        System.out.println("2. Delete " + modelName + " by id");
        System.out.println("3. Update " + modelName + " by id");
        System.out.println("4. Print all " + modelName);

        System.out.print("Input: ");
        int result = new Scanner(System.in).nextInt();
        System.out.println();

        return result;
    }*/

    /*private static int menuBooks(){
        return menuAbstractModel("book");
    }

    private static void printAllBooks(){
        System.out.println(bookService.findAll());
    }

    private static void addNewBook(){
        bookService.save(initBook());
    }

    private static void deleteBookById(){
        System.out.println("Input id: ");
        bookService.delete(
                bookService.find(new Scanner(System.in).nextInt())
        );
    }

    private static void updateBookById(){
        System.out.println("Input id: ");
        Book oldBook = bookService.find(new Scanner(System.in).nextInt());

        Book newBook = initBook(); //initBook
        newBook.setId(oldBook.getId());

        bookService.update(newBook);
    }

    private static Integer processAnswerAbstractModel(Integer answer, Runnable... actions){

        if(answer == 0)
            return 0;

        for(int i = 1; i <= actions.length; i++){
            if(answer.equals(i)){
                actions[i - 1].run();
                return i;
            }
        }

        return -2;
    }

    private static Integer processAnswerBooks(Integer answer){
        *//*switch (answer){
            case 0:
                return 0;
            case 1:
                addNewBook();
                return 1;
            case 2:
                deleteBookById();
                return 2;
            case 3:
                updateBookById();
                return 3;
            case 4:
                printAllBooks();
                return 4;
            default:
                return -2;
        }*//*
        return processAnswerAbstractModel(
                answer,
                Main::addNewBook,
                Main::deleteBookById,
                Main::updateBookById,
                Main::printAllBooks
                );
    }*/

    /*private static int menuPurchasers(){
        return menuAbstractModel("Purchaser");
    }

    private static void printAllPurchasers(){
        System.out.println(purchaserService.findAll());
    }

    private static void addNewPurchaser(){
        purchaserService.save(initPurchaser());
    }

    private static void deletePurchaserById(){
        System.out.println("Input id: ");
        purchaserService.delete(
                purchaserService.find(new Scanner(System.in).nextInt())
        );
    }

    private static void updatePurchaserById(){
        System.out.println("Input id: ");
        Purchaser oldPurchaser = purchaserService.find(new Scanner(System.in).nextInt());

        Purchaser newPurchaser = initPurchaser();
        newPurchaser.setId(oldPurchaser.getId());

        purchaserService.update(newPurchaser);
    }*/

    /*private static Integer processAnswerPurchasers(Integer answer){
     *//*switch (answer){
            case 0:
                return 0;
            case 1:
                addNewPurchaser();
                return 1;
            case 2:
                deletePurchaserById();
                return 2;
            case 3:
                updatePurchaserById();
                return 3;
            case 4:
                printAllPurchasers();
                return 4;
            default:
                return -2;
        }*//*

        return processAnswerAbstractModel(
                answer,
                Main::addNewPurchaser,
                Main::deletePurchaserById,
                Main::updatePurchaserById,
                Main::printAllPurchasers
                );
    }*/

    public static void main(String[] args) {
        new ConsoleMainService().run();
    /*
        *//*int status = -1;
        while (status != 0){
            status = processAnswerPurchasers(menuPurchasers());
            if(status == -2){
                System.out.println("Bad answer.");
            }
        }*//*

        //processMainAnswers(mainMenu());
        //new ConsoleMainService().run();
        *//*PurchaserService purchaserService = new PurchaserService();
        System.out.println(purchaserService.findAll());
        System.out.println(purchaserService.count());*//*

        BookService bookService = new BookService();
        PurchaserService purchaserService = new PurchaserService();
        ShopService shopService = new ShopService();
        PurchaseService purchaseService = new PurchaseService();

        *//*Book book = new Book(
                "1984",
                150,
                "3",
                2
        );*//*

        //bookService.save(book);

        *//*purchaserService.deleteById(2);
        purchaserService.deleteById(3);
        purchaserService.deleteById(5);
        purchaserService.deleteById(6);
        purchaserService.deleteById(7);

        purchaserService.save(new Purchaser(
                "Иванов",
                "Нижегородский",
                5
        ));

        purchaserService.save(new Purchaser(
                "Петров",
                "Ленинский",
                7
        ));

        purchaserService.save(new Purchaser(
                "Сидоров",
                "Автозаводский",
                12
        ));*//*

        System.out.println(bookService.findAll());
        System.out.println(bookService.getDifferentNames());
        System.out.println(bookService.getDifferentPrices());

        System.out.println(purchaserService.findAll());
        System.out.println(purchaserService.getDifferentResidenceArea());

        *//*shopService.save(new Shop(
                "Книжки",
                "Нижегородский",
                5
        ));

        shopService.save(new Shop(
                "Книжечки",
                "Сормовский",
                7
        ));

        shopService.save(new Shop(
                "КнигШоп",
                "Ленинский",
                4
        ));*//*

        System.out.println(shopService.findAll());

        *//*purchaseService.save(new Purchase(

        ));*//*

        *//*Purchase purchase = new Purchase(
                new Timestamp(new Date().getTime()),
                1,
                8,
                1,
                2,
                600
        );

        purchase.setId(1);

        purchaseService.update(purchase);*//*

        *//*Purchase purchase = new Purchase(
                new Timestamp(new GregorianCalendar(2018, 11, 21).getTime().getTime()),
                2,
                9,
                8,
                20,
                4000
        );

        purchase.setId(2);

        purchaseService.update(purchase);

        purchase = new Purchase(
                new Timestamp(new GregorianCalendar(2018, 11, 15).getTime().getTime()),
                3,
                10,
                7,
                100,
                30000
        );

        purchase.setId(3);

        purchaseService.update(purchase);*//*

        //purchaseService.deleteById(4);

        System.out.println(purchaseService.findAll());
        System.out.println(purchaseService.getDifferentMonth());

        System.out.println(purchaserService.getLastNamesAndDiscountsOfPurchasersInNizhegorodskiyDisctrict());

        *//*shopService.save(new Shop(
                "Буки",
                "Советский",
                9
        ));*//*

        System.out.println(shopService.getShopsInSovietAndSormovoDistricts());

       *//* bookService.save(new Book(
                "Windows for professional administrators",
                1299,
                "3",
                3
        ));*//*

        //bookService.deleteById(11);

        *//*Book book = new Book(
                "Proffesional programming in Windows",
                899,
                "4",
                2
        );
        book.setId(13);

        bookService.update(book);*//*

        System.out.println(bookService.findAll());
        System.out.println(bookService.getBooksContainingWordInNameOrWithSpecialPriceTest());
        System.out.println(bookService.getNameAndPriceOfBooksContainingWordInNameOrWithSpecialPriceTest());

        System.out.println(purchaseService.findAll());
        System.out.println(purchaseService.getDatePurchaserLastNameDiscountBookNameAndBooksCountByPurchaseId(1));
        System.out.println(purchaseService.getPurchaserLastNameAndShopNameByPurchaseId(1));
        System.out.println(purchaseService.getDatePurchaserLastNameDiscountBookNameAndBooksCountOfAllPurchases());

        *//*purchaseService.save(new Purchase(
                new Timestamp(
                        new GregorianCalendar(2018, 9, 15)
                                .getTime()
                                .getTime()
                ),
                1,
                8,
                1,
                2,
                600
        ));

        purchaseService.save(new Purchase(
                new Timestamp(
                        new GregorianCalendar(2018, 7, 15)
                                .getTime()
                                .getTime()
                ),
                1,
                9,
                1,
                2,
                600
        ));*//*

        System.out.println(purchaseService.getPurchasesByPurchasersInOwnAreaWithMonthLessThen(Month.DECEMBER));

        *//*shopService.save(new Shop(
                "Книжули",
                "Автозаводский",
                5
        ));*//*


        *//*purchaserService.save(new Purchaser(
                "Абрамович",
                "Советский",
                10
        ));*//*

        *//*purchaseService.save(new Purchase(
                new Timestamp(
                        new GregorianCalendar(2018, 8, 17)
                                .getTime()
                                .getTime()
                ),
                5,
                11,
                1,
                10,
                3000

        ));

        purchaseService.save(new Purchase(
                new Timestamp(
                        new GregorianCalendar(2018, 8, 17)
                                .getTime()
                                .getTime()
                ),
                2,
                11,
                1,
                10,
                3000

        ));

        purchaseService.save(new Purchase(
                new Timestamp(
                        new GregorianCalendar(2018, 8, 17)
                                .getTime()
                                .getTime()
                ),
                4,
                11,
                1,
                10,
                3000

        ));

        purchaseService.save(new Purchase(
                new Timestamp(
                        new GregorianCalendar(2018, 8, 17)
                                .getTime()
                                .getTime()
                ),
                2,
                10,
                1,
                10,
                3000

        ));*//*


        //System.out.println(shopService.findAll());
        System.out.println(purchaseService.findAll());
        System.out.println(
                shopService.getShopsInOtherDistrictsWhereBuyPurchasersWithDiscountBetween(
                        "Автозаводский",
                        10,
                        15
                ));

        System.out.println(purchaseService.getPurchaserLastNameAndShopNameOfAllPurchases());

        *//*bookService.save(
                new Book(
                        "professional java 8",
                        1500,
                        "3",
                        15
                )
        );*//*

        System.out.println(bookService.findAll());

        *//*purchaseService.save(new Purchase(
                new Timestamp(
                        new GregorianCalendar(2018, 7, 5)
                        .getTime()
                        .getTime()
                ),
                1,
                8,
                10,
                100,
                99900
        ));*//*

        System.out.println(purchaseService.getPurchaserLastNameAndShopNameOfAllPurchases());

        System.out.println(bookService.getBooksInfoBuyedInStorageAreaContainedInStockMoreThanCount(9));

        System.out.println(purchaseService.getPurchasesWithSumGreaterOrEqualThan(60000));

        System.out.println(purchaseService.getInfoAboutPurchaseWithSumGraterOrEqualThan(60000));*/

    }
}
