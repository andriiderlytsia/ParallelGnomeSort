package com.company;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Main<T extends Comparable<T>> {

    public static void main(String[] args) {

        int length1 = 100000;
        int length2 = 200000;


        int numOfGroups = 45 ;
        CountDownLatch latch = new CountDownLatch(numOfGroups);
        Integer[] arr1 = new Integer[length1];
        Integer[] arr2 = new Integer[length1];

        Random randNum = new Random();


        for (int i = 0; i < length1; i++) {
            arr1[i] = randNum.nextInt(2000);
        }
        for (int i = 0; i < length1; i++) {
            arr2[i] = randNum.nextInt(2000);
        }


        //  Consequensual


        GnomeSort gnomeSort = new GnomeSort(arr2);

        long startTime1 = System.currentTimeMillis();

        gnomeSort.sort();



        long stopTime1 = System.currentTimeMillis();
        long elapsedTime1 = stopTime1 - startTime1;

        System.out.println("Time");

        System.out.println(elapsedTime1);
//        for (Comparable j:arr2) {
//                System.out.print(j);
//                System.out.print("\t");
//            }

        // Parallel

        System.out.println("Sorted");
        parallelSort sort = new parallelSort();
        Comparable[] result = new Comparable[length1];
        try {
            long startTime = System.currentTimeMillis();

            result = sort.parallelSortArray(arr1, numOfGroups, latch);

            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;

            System.out.println("Time2");

            System.out.println(elapsedTime);

            for (Comparable j:result) {
                System.out.print(j);
                System.out.print("\t");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();


    }
}
