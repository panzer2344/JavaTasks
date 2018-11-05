package com.podval;

public class OneDimArraysProblems {

    private static int[] generateArray(int size, int minVal, int maxVal){
        int[] array = new int[size];
        for(int i = 0; i < size; i++){
            array[i] = minVal + (int)(Math.random() * (maxVal - minVal + 1));
        }
        return array;
    }

    public static void test(){
        /* a. */
        /*Createing an array of odd numbers*/
        final int ODD_ARR_SIZE = 100;
        int[] oddArrays = new int[ODD_ARR_SIZE];

        for(int i = 0; i < ODD_ARR_SIZE; i++){
            oddArrays[i] = i;
        }

        System.out.print("forward: ");
        /*printing array in forward direction*/
        for ( int i = 0; i < ODD_ARR_SIZE; i++){
            System.out.print(oddArrays[i] + " ");
        }
        System.out.println();
        System.out.println();

        System.out.print("reverse: ");
        /*printing array in reverse direction*/
        for(int i = ODD_ARR_SIZE - 1; i >= 0; i--){
            System.out.print(oddArrays[i] + " ");
        }
        System.out.println();
        System.out.println();
        System.out.println();

        /* b. */
        /* twenty random numbers */
        final int RAND_ARR_SIZE = 20;
        int[] randArr = generateArray(RAND_ARR_SIZE, 0, 10);
        int odd = 0, even = 0;
        for(int x : randArr){
            System.out.print(x + " ");
             if( x % 2 == 0 )
                 even++;
             else
                 odd++;
        }
        System.out.println();
        System.out.println("Even = " + even + " Odd = " + odd);
        System.out.println();


        /* c. */
        /* replace zeros */
        final int ZERO_ARR_SIZE = 10;
        int[] arr = generateArray(ZERO_ARR_SIZE, 1, 100);

        System.out.print("arr: ");
        for(int x : arr){
            System.out.print(x + " ");
        }
        System.out.println();

        for(int i = 1; i < ZERO_ARR_SIZE; i += 2){
            arr[i] = 0;
        }

        System.out.print("replaced: ");
        for (int x: arr){
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println();
        System.out.println();

        /* d. */
        /* min and max */
        final int MINMAX_ARR_SIZE = 15;
        final int MINMAX_ARR_MAX_VAL = 50, MINMAX_ARR_MIN_VAL = -50;
        int min_index = 0, max_index = 0;

        arr = generateArray(MINMAX_ARR_SIZE, MINMAX_ARR_MIN_VAL, MINMAX_ARR_MAX_VAL);
        for(int x : arr)
            System.out.print(x + " ");
        System.out.println();

        for(int i = 0; i < MINMAX_ARR_SIZE; i++){
            if(arr[i] <= arr[min_index])
                min_index = i;
            if(arr[i] >= arr[max_index])
                max_index = i;
        }
        System.out.println("Min = " + arr[min_index] + " by index = " + min_index);
        System.out.println("Max = " + arr[max_index] + " by index = " + max_index);
        System.out.println();

        /* e. */
        /* avg */
        final int AVG_ARR_SIZE = 10;
        final int AVG_MIN_VAL = 0, AVG_MAX_VAL = 10;
        double avg1 = 0.0, avg2 = 0.0;

        int[] arr1 = generateArray(AVG_ARR_SIZE, AVG_MIN_VAL, AVG_MAX_VAL);
        int[] arr2 = generateArray(AVG_ARR_SIZE, AVG_MIN_VAL, AVG_MAX_VAL);

        for(int x : arr1){
            avg1 += x;
            System.out.print(x + " ");
        }
        avg1 /= (double) AVG_ARR_SIZE;
        System.out.println();

        for(int y : arr2){
            avg2 += y;
            System.out.print(y + " ");
        }
        avg2 /= (double) AVG_ARR_SIZE;
        System.out.println();

        if(avg1 == avg2)
            System.out.println("avg1 = avg2");
        if(avg1 > avg2)
            System.out.println("avg1 > avg2");
        if(avg1 < avg2)
            System.out.println("avg1 < avg2");
        System.out.println();


        /* f. */
        /* frequencies*/
        final int FREQ_ARR_SIZE = 20;
        final int FREQ_MIN_VAL = -1, FREQ_MAX_VAL = 1;

        arr = generateArray(FREQ_ARR_SIZE, FREQ_MIN_VAL, FREQ_MAX_VAL);
        for(int x : arr)
            System.out.print(x + " ");
        System.out.println();

        int[] freqs = new int[3]; // freqs[0] for -1, freqs[1] for 0, freqs[2] for 1
        int max_freq = 0;

        for(int i = 0; i < 3; i++){
            freqs[i] = 0;
        }

        for(int i = 0; i < FREQ_ARR_SIZE; i++){
            int tmp = ++freqs[arr[i] + 1];
            if( tmp > max_freq )
                max_freq = tmp;
        }

        System.out.print("Max frequencies at: ");
        for(int i = 0; i < 3; i++){
            if(freqs[i] == max_freq)
                System.out.print(i - 1 + " ");
        }

        System.out.println();
        System.out.println();
        System.out.println();
    }
}
