package com.podval.tests.fourth.main;

import com.podval.tests.first.si.tests.IComputer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainFourth {
    public static void main(String[] args) {

        /*There are used test classes from first si task */

        ApplicationContext context = new ClassPathXmlApplicationContext("beans4.xml");

        IComputer pc = (IComputer) context.getBean("pc");
        pc.copyFromDvd();
    }
}
