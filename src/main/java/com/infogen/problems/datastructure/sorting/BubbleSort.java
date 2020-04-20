package com.infogen.problems.datastructure.sorting;

import java.util.Arrays;


//compare two adjacent one, see if there was any swap, otherwise break
//requires an extra loop to check if nothing has changed
public class BubbleSort {
    int[] sort(int[] arrayToSort) {
        for (int j = 0; j < arrayToSort.length - 1; j++) {
            boolean swap = false;
            for (int i = 0; i < arrayToSort.length - j - 1; i++) {
                if (arrayToSort[i] > arrayToSort[i + 1]) {
                    int temp = arrayToSort[i];
                    arrayToSort[i] = arrayToSort[i + 1];
                    arrayToSort[i + 1] = temp;
                    swap=true;
                }
            }
            if (!swap) {
                return arrayToSort;
            }
            System.out.println("arrayToSort = " + Arrays.toString(arrayToSort));
        }
        return arrayToSort;
    }

    public static void main(String[] args) {
        BubbleSort selectionSort = new BubbleSort();
        int[] a = {0,2997, 378, 34, 8, 11};
        int[] sort = selectionSort.sort(a);
        System.out.println("sort = " + Arrays.toString(sort));
    }
}
