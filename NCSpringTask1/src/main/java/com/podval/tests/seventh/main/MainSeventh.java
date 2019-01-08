package com.podval.tests.seventh.main;

import com.podval.tests.seventh.tests.Shawarma;
import com.podval.tests.seventh.tests.ShawarmaKiosk;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainSeventh {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans7.xml");
        ShawarmaKiosk shawarmaKiosk = (ShawarmaKiosk) context.getBean("shawarmaKiosk");

        Shawarma shawarma = shawarmaKiosk.makeShawarma();
        System.out.println(shawarma);

        Shawarma spicyShawarma = shawarmaKiosk.makeSpicyShawarma();
        System.out.println(spicyShawarma);

    }
}
