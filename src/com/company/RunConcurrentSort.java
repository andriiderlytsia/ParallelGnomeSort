package com.company;

import java.util.concurrent.CountDownLatch;

public class RunConcurrentSort<T extends Comparable<T>> implements Runnable {
    CountDownLatch latch;
    private final T[] arr;

    public RunConcurrentSort(CountDownLatch latch, T[] arr) {
        this.latch = latch;
        this.arr = arr;
    }

    @Override
    public void run() {
        try{
            GnomeSort gnomeSort = new GnomeSort(arr);
            gnomeSort.sort();
            latch.countDown();
        }catch(Exception err){
            err.printStackTrace();
        }
    }
}
