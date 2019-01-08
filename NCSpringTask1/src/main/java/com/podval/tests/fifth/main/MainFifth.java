package com.podval.tests.fifth.main;

import com.podval.main.*;

public class MainFifth {
    public static void main(String[] args) {

        System.out.println("------------NO--------------");
        MainFifthNo.main(args);
        Main.space(3);

        System.out.println("-----------Constructor------");
        MainFifthConstructor.main(args);
        Main.space(3);

        System.out.println("-----------ByName-----------");
        MainFifthByName.main(args);
        Main.space(3);

        System.out.println("-----------ByType-----------");
        MainFifthByType.main(args);
        Main.space(3);
    }
}
