package com.podval.tests.fifth.main;

import com.podval.tests.fifth.tests.IComputer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainFifthByType {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans5_byType.xml");
        IComputer pc = (IComputer) context.getBean("pc");
        pc.copyFromDvd();

    }
}
