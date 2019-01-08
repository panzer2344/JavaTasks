package com.podval.tests.second.si.main;

import com.podval.tests.second.si.tests.ForestList;
import com.podval.tests.second.si.tests.ForestMap;
import com.podval.tests.second.si.tests.ForestSet;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainSecondSI {
    public static void main(String[] args) {

        System.out.println("----------------------SI-----------------------------");
        System.out.println();

        //ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        ApplicationContext context = new ClassPathXmlApplicationContext("beans2.2.xml");


        System.out.println("---------------ForestList si tests-----------");
        System.out.println();

        ForestList forestList = context.getBean(ForestList.class);
        forestList.sway();


        System.out.println();


        System.out.println("-----------------ForestSet si tests----------");
        System.out.println();

        ForestSet forestSet = context.getBean(ForestSet.class);
        forestSet.sway();


        System.out.println();


        System.out.println("-----------------ForestMap si tests----------");
        System.out.println();

        ForestMap forestMap = context.getBean(ForestMap.class);
        forestMap.sway();

    }
}
