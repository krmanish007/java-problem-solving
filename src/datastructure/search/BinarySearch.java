package datastructure.search;

import java.util.Arrays;

//O(LOGN)
public class BinarySearch {

    private int search(int[] input, int toSearch) {
        Arrays.sort(input);
        System.out.println("Arrays.toString(input) = " + Arrays.toString(input));
        int min = 0;
        int max = input.length - 1;

        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (input[mid] == toSearch) {
                return mid;
            }
            if (input[mid] < toSearch) {
                //go right
                min = mid + 1;
            } else {
                //go left
                max = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {23, 4, 36, 3, 15};
        System.out.println("new datastructure.BinarySearch = " + new BinarySearch().search(a, 15));
    }
}

