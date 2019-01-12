package com.podval.main;

import com.podval.models.IModel;
import com.podval.models.Purchase;
import com.podval.services.PurchaseService;

import java.sql.Timestamp;
import java.util.GregorianCalendar;

public class ConsolePurchaseService extends ConsoleObjectService {

    public ConsolePurchaseService() {
        super(Purchase.class, new PurchaseService());
    }

    @Override
    public IModel init() {

        System.out.println("------------Init purchase--------------");

        return new Purchase(
                new Timestamp(
                        new GregorianCalendar(
                                (Integer) IConsoleMainService.getObjectFromInput("Input year: "),
                                ((Integer) IConsoleMainService.getObjectFromInput("Input month: ")) - 1,
                                (Integer) IConsoleMainService.getObjectFromInput("Input day: ")
                        )
                                .getTime()
                                .getTime()
                ),
                (Integer) IConsoleMainService.getObjectFromInput("Input shop ID: "),
                (Integer) IConsoleMainService.getObjectFromInput("Input purchaser ID: "),
                (Integer) IConsoleMainService.getObjectFromInput("Input book ID: "),
                (Integer) IConsoleMainService.getObjectFromInput("Input count: "),
                (Integer) IConsoleMainService.getObjectFromInput("Input sum: ")
        );
    }

}
