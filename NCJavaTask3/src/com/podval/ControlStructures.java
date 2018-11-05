package com.podval;

public class ControlStructures {

    private enum Numbers {ONE, TWO, THREE, FOUR, FIVE};

    public static void test(){
        long startTime, estimatedTime;

        int a = (int)(Math.random() * 5);
        Numbers number = Numbers.values()[a];

        startTime = System.nanoTime();
        switch (number){
            case ONE:
                System.out.println("(switch)One");
                break;

            case TWO:
                System.out.println("(switch)Two");
                break;

            case THREE:
                System.out.println("(switch)Three");
                break;

            case FOUR:
                System.out.println("(switch)Four");
                break;

            case FIVE:
                System.out.println("(switch)Five");
                break;

            default:
                break;
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Estimated time(switch) " + estimatedTime + "ns");

        System.out.println();
        System.out.println();

        startTime = System.nanoTime();
        if(number == Numbers.ONE){
            System.out.println("(if-else)ONE");
        }
        else if(number == Numbers.TWO){
            System.out.println("(if-else)TWO");
        }
        else if(number == Numbers.THREE){
            System.out.println("(if-else)THREE");
        }
        else if(number == Numbers.FOUR){
            System.out.println("(if-else)FOUR");
        }
        else if(number == Numbers.FIVE){
            System.out.println("(if-else)FIVE");
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Estimated time(if-else): " + estimatedTime + "ns");

        System.out.println();
        System.out.println();


        /*with array*/
        final int ARR_SIZE = 50;
        final int MAX_VAL = 10;
        int[] arr = new int[ARR_SIZE];

        for(int i = 0; i < ARR_SIZE; i++){
            arr[i] = (int)(Math.random() * (MAX_VAL + 1));
        }

        /*switch*/
        startTime = System.nanoTime();
        for(int x : arr){
            switch (x){
                case 0:
                    System.out.println("(switch) " + x);
                    break;
                case 1:
                    System.out.println("(switch) " + x);
                    break;
                case 2:
                    System.out.println("(switch) " + x);
                    break;
                case 3:
                    System.out.println("(switch) " + x);
                    break;
                case 4:
                    System.out.println("(switch) " + x);
                    break;
                case 5:
                    System.out.println("(switch) " + x);
                    break;
                case 6:
                    System.out.println("(switch) " + x);
                    break;
                case 7:
                    System.out.println("(switch) " + x);
                    break;
                case 8:
                    System.out.println("(switch) " + x);
                    break;
                case 9:
                    System.out.println("(switch) " + x);
                    break;
                case 10:
                    System.out.println("(switch) " + x);
                    break;
                default:
                    break;
            }
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Estimated time(switch) " + estimatedTime + "ns");

        System.out.println();
        System.out.println();

        startTime = System.nanoTime();
        for (int x : arr){
            if(x == 0){
                System.out.println("(if-else)" + x);
            }
            else if(x == 1){
                System.out.println("(if-else)" + x);
            }
            else if(x == 2){
                System.out.println("(if-else)" + x);
            }
            else if(x == 3){
                System.out.println("(if-else)" + x);
            }
            else if(x == 4){
                System.out.println("(if-else)" + x);
            }
            else if(x == 5){
                System.out.println("(if-else)" + x);
            }
            else if(x == 6){
                System.out.println("(if-else)" + x);
            }
            else if(x == 7){
                System.out.println("(if-else)" + x);
            }
            else if(x == 8){
                System.out.println("(if-else)" + x);
            }
            else if(x == 9){
                System.out.println("(if-else)" + x);
            }
            else if(x == 10){
                System.out.println("(if-else)" + x);
            }
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Estimated time(if-else): " + estimatedTime + "ns");


        System.out.println();
        System.out.println();
        System.out.println();
    }
}
