package com.podval.tests.first.ci.main;

import com.podval.tests.first.ci.tests.IComputer;
import com.podval.tests.first.ci.tests.Laptop;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainFirstCI {
    public static void main(String[] args) {


        System.out.println("----------------------CI-----------------------------");
        System.out.println();


        //ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        ApplicationContext context = new ClassPathXmlApplicationContext("beans1.1.xml");


        System.out.println("Laptop ci tests");
        IComputer laptop = context.getBean(Laptop.class);
        laptop.copyFromDvd();

        System.out.println();
        System.out.println();

        System.out.println("PC ci tests");
        IComputer pc = context.getBean(Laptop.class);
        pc.copyFromDvd();

    }
}
