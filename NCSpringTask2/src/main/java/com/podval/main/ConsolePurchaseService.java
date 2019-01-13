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
                                Integer.parseInt((String) IConsoleMainService.getObjectFromInput("Input year: ")),
                                Integer.parseInt(((String) IConsoleMainService.getObjectFromInput("Input month: "))) - 1,
                                Integer.parseInt((String) IConsoleMainService.getObjectFromInput("Input day: "))
                        )
                                .getTime()
                                .getTime()
                ),
                Integer.parseInt((String) IConsoleMainService.getObjectFromInput("Input shop ID: ")),
                Integer.parseInt((String) IConsoleMainService.getObjectFromInput("Input purchaser ID: ")),
                Integer.parseInt((String) IConsoleMainService.getObjectFromInput("Input book ID: ")),
                Integer.parseInt((String) IConsoleMainService.getObjectFromInput("Input count: ")),
                Integer.parseInt((String) IConsoleMainService.getObjectFromInput("Input sum: "))
        );
    }

}
