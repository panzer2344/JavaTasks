package com.podval.tests.third.main;

import com.podval.tests.third.tests.Animal;
import com.podval.tests.third.tests.Lion;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainThird {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans3.xml");

        Animal lion = (Lion) context.getBean("lion");
        lion.voice();
    }
}
