package com.infogen.problems.datastructure.sorting;

import java.util.Arrays;


//default sorting algorithm in most of the library
//divide and conquer
//complexity is O(NLOGN), SPACE is O(N)
//Mergesort uses extra space, quicksort requires little space and exhibits good cache locality.
//Mergesort is a stable sort, unlike quicksort
public class QuickSort {
    void sort(int[] arrayToSort, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivotPosition = partition(arrayToSort, low, high);
        sort(arrayToSort, low, pivotPosition - 1);
        sort(arrayToSort, pivotPosition + 1, high);
    }

    //half array is half the size of input
    private int partition(int[] input, int low, int high) {
        int pivot = input[low];
        int currentLow = low;
        int currentHigh = high;

        while (currentLow < currentHigh) {
            while (input[currentLow] <= pivot && currentLow < currentHigh) {
                currentLow++;
            }
            while (input[currentHigh] > pivot) {
                currentHigh--;
            }
            //swap lower than pivot with higher than pivot
            if (currentLow < currentHigh) {
                int temp = input[currentLow];
                input[currentLow] = input[currentHigh];
                input[currentHigh] = temp;
            }
        }
        //swap pivot to current high
        input[low] = input[currentHigh];
        input[currentHigh] = pivot;

        return currentHigh;
    }

    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        int[] a = {150, 29, 37, 33, 45, 34, 8, 55, 11};
        sort.sort(a, 0, a.length - 1);
        System.out.println("sort = " + Arrays.toString(a));
    }
}
