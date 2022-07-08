package com.company;

import java.util.stream.IntStream;

public class GnomeSort<T extends Comparable<T>> {

    private final T[] arr;

    public GnomeSort(T[] arr) {
        this.arr = arr;
    }

    public void sort() {
        int i=1;
        int j=2;

        while(i < arr.length) {
            if ( arr[i-1].compareTo( arr[i]) <0)
            {
                i = j; j++;
            } else {
                T tmp = arr[i-1];
                arr[i-1] = arr[i];
                arr[i--] = tmp;
                i = (i==0) ? j++ : i;
            }
        }
    }
}
