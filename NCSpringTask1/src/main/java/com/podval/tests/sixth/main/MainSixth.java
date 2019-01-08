package com.podval.tests.sixth.main;

import com.podval.tests.sixth.tests.IClock;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainSixth {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans6.xml");
        IClock digitalClock = (IClock) context.getBean("digitalClock");
        digitalClock.showTime();
    }
}
