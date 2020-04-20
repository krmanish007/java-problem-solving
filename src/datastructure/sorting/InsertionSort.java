package datastructure.sorting;

import java.util.Arrays;


//create a sorted sublist, and keep adding new item in the sorted position
//doesn't require an extra loop to check if nothing has changed
//it has lesser swap than bubble
public class InsertionSort {
    int[] sort(int[] arrayToSort) {
        for (int j = 0; j < arrayToSort.length-1; j++) {
            for (int i = j; i >= 0; i--) {
                if (arrayToSort[i] > arrayToSort[i + 1]) {
                    int temp = arrayToSort[i];
                    arrayToSort[i] = arrayToSort[i + 1];
                    arrayToSort[i + 1] = temp;
                }
            }
            System.out.println("arrayToSort = " + Arrays.toString(arrayToSort));
        }
        return arrayToSort;
    }

    public static void main(String[] args) {
        InsertionSort selectionSort = new InsertionSort();
        int[] a = {150,29, 37, 34, 8, 11};
        int[] sort = selectionSort.sort(a);
        System.out.println("sort = " + Arrays.toString(sort));
    }
}
