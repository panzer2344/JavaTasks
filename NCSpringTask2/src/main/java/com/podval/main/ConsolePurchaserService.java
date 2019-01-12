package com.podval.main;

import com.podval.models.IModel;
import com.podval.models.Purchaser;
import com.podval.services.PurchaserService;

public class ConsolePurchaserService extends ConsoleObjectService {

    public ConsolePurchaserService(){
        super(Purchaser.class, new PurchaserService());
    }

    @Override
    public IModel init(){

        System.out.println("------------Init purchaser--------------");

        return new Purchaser(
                (String) IConsoleMainService.getObjectFromInput("Input last name: "),
                (String) IConsoleMainService.getObjectFromInput("Input residence area: "),
                Integer.parseInt((String) IConsoleMainService.getObjectFromInput("Input discount: "))
        );
    }

}
