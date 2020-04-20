package datastructure.sorting;

import java.util.Arrays;


public class SelectionSort {
    int[] sort(int[] arrayToSort) {
        for (int i = 0; i < arrayToSort.length; i++) {
            for (int j = i; j < arrayToSort.length; j++) {
                if (arrayToSort[i] < arrayToSort[j]) {
                    int temp = arrayToSort[i];
                    arrayToSort[i] = arrayToSort[j];
                    arrayToSort[j] = temp;
                }
            }
            System.out.println("arrayToSort = " + Arrays.toString(arrayToSort));
        }
        return arrayToSort;
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] a = {20, 37, 34, 8, 18};
        int[] sort = selectionSort.sort(a);
        System.out.println("sort = " + Arrays.toString(sort));
    }
}
