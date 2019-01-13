package com.podval.main;

import com.podval.services.BookService;
import com.podval.services.PurchaseService;
import com.podval.services.PurchaserService;
import com.podval.services.ShopService;

import java.time.Month;

public class Main {

    public static void main(String[] args) {
        new ConsoleMainService().run();

    }
}
