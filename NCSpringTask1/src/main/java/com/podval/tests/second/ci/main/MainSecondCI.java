package com.podval.tests.second.ci.main;

import com.podval.tests.second.ci.tests.ForestList;
import com.podval.tests.second.ci.tests.ForestMap;
import com.podval.tests.second.ci.tests.ForestSet;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainSecondCI {
    public static void main(String[] args) {

        System.out.println("----------------------CI-----------------------------");
        System.out.println();

        //ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        ApplicationContext context = new ClassPathXmlApplicationContext("beans2.1.xml");


        System.out.println("---------------ForestList ci tests-----------");
        System.out.println();

        ForestList forestList = context.getBean(ForestList.class);
        forestList.sway();


        System.out.println();


        System.out.println("-----------------ForestSet ci tests----------");
        System.out.println();

        ForestSet forestSet = context.getBean(ForestSet.class);
        forestSet.sway();


        System.out.println();


        System.out.println("-----------------ForestMap ci tests----------");
        System.out.println();

        ForestMap forestMap = context.getBean(ForestMap.class);
        forestMap.sway();

    }
}
