package com.podval.main;

import com.podval.tests.fifth.main.MainFifth;
import com.podval.tests.first.ci.main.MainFirstCI;
import com.podval.tests.first.si.main.MainFirstSI;
import com.podval.tests.fourth.main.MainFourth;
import com.podval.tests.second.ci.main.MainSecondCI;
import com.podval.tests.second.si.main.MainSecondSI;
import com.podval.tests.seventh.main.MainSeventh;
import com.podval.tests.sixth.main.MainSixth;

import java.util.function.Consumer;

public class Main {

    public static void space(int count){
        for(int i = 0; i < count; i++){
            System.out.println();
        }
    }

    private static void runTask(String[] args, String number, Consumer<String[]>... tasks){
        System.out.println("------------------" + number + " task -----------------------");
        space(1);

        for(Consumer<String[]> task : tasks){
            space(2);
            task.accept(args);
        }

        space(4);
    }


    public static void main(String[] args) {

        runTask(args, "First", MainFirstCI::main, MainFirstSI::main);

        runTask(args, "Second", MainSecondCI::main, MainSecondSI::main);

        runTask(args, "Third", MainFirstCI::main, MainFirstSI::main);

        runTask(args, "Fourth", MainFourth::main);

        runTask(args, "Fifth", MainFifth::main);

        runTask(args, "Sixth", MainSixth::main);

        runTask(args, "Seventh", MainSeventh::main);

    }

}
