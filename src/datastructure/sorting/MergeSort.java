package datastructure.sorting;

import java.util.Arrays;


//divide and conquer
//complexity is O(NLOGN), SPACE is O(N)
public class MergeSort {
    void sort(int[] arrayToSort) {
        int size = arrayToSort.length;
        if (size < 2) {
            return;
        }
        int mid = size / 2;
        int[] firstHalf = new int[mid];
        int[] secondHalf = new int[size - mid];
        split(arrayToSort, firstHalf, secondHalf);

        sort(firstHalf);
        sort(secondHalf);

        merge(arrayToSort, firstHalf, secondHalf);
    }

    //half array is half the size of input
    private void split(int[] input, int[] firstHalf, int[] secondHalf) {
        int index = 0;
        int secondHalfStartingIndex = firstHalf.length;
        for (int element : input) {
            if (index < secondHalfStartingIndex) {
                firstHalf[index] = element;
            } else {
                secondHalf[index - secondHalfStartingIndex] = element;
            }
            index++;
        }
    }

    private void merge(int[] output, int[] firstHalf, int[] secondHalf) {
        int firstHalfLength = firstHalf.length;
        int secondHalfLength = secondHalf.length;

        int firstHalfPosition = 0;
        int secondHalfPosition = 0;
        int mergedArrayPosition = 0;

        while (firstHalfPosition < firstHalfLength && secondHalfPosition < secondHalfLength) {
            if (firstHalf[firstHalfPosition] <= secondHalf[secondHalfPosition] ) {
                output[mergedArrayPosition] = firstHalf[firstHalfPosition];
                firstHalfPosition++;
            } else {
                output[mergedArrayPosition] = secondHalf[secondHalfPosition];
                secondHalfPosition++;
            }
            mergedArrayPosition++;
        }

        while (firstHalfPosition < firstHalfLength) {
            output[mergedArrayPosition++] = firstHalf[firstHalfPosition++];
        }
        while (secondHalfPosition < secondHalfLength) {
            output[mergedArrayPosition++] = secondHalf[secondHalfPosition++];
        }
    }

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        int[] a = {150, 29, 37, 34, 8, 11};
        sort.sort(a);
        System.out.println("sort = " + Arrays.toString(a));
    }
}
