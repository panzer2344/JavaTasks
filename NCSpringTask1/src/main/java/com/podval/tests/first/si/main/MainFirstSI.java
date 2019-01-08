package com.podval.tests.first.si.main;

import com.podval.tests.first.si.tests.IComputer;
import com.podval.tests.first.si.tests.Laptop;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainFirstSI {
    public static void main(String[] args) {


        System.out.println("----------------------SI-----------------------------");
        System.out.println();

        //ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        ApplicationContext context = new ClassPathXmlApplicationContext("beans1.2.xml");


        System.out.println("Laptop si tests");
        IComputer laptop = context.getBean(Laptop.class);
        laptop.copyFromDvd();

        System.out.println();
        System.out.println();

        System.out.println("PC si tests");
        IComputer pc = context.getBean(Laptop.class);
        pc.copyFromDvd();


    }
}
