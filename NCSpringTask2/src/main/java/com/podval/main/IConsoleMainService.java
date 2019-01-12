package com.podval.main;

import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Supplier;

public interface IConsoleMainService {

    static Object getObjectFromInput(String message){
        System.out.print(message);
        Object o = new Scanner(System.in).nextLine().trim();
        System.out.println();
        return o;
    };

    Integer menu();
    Integer processAnswers(Integer answer);
    Integer abstractProcessing(Function<Integer, Integer> concreteProcess, Supplier<Integer> menuFunction);

    void run();
}
