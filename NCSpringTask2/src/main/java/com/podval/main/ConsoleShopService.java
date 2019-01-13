package com.podval.main;

import com.podval.models.IModel;
import com.podval.models.Shop;
import com.podval.services.ShopService;

public class ConsoleShopService extends ConsoleObjectService {

    public ConsoleShopService() {
        super(Shop.class, new ShopService());
    }

    @Override
    public IModel init() {

        System.out.println("------------Init shop--------------");

        return new Shop(
                (String) IConsoleMainService.getObjectFromInput("Input name: "),
                (String) IConsoleMainService.getObjectFromInput("Input area: "),
                Integer.parseInt ((String) IConsoleMainService.getObjectFromInput("Input fee: "))
        );
    }

}