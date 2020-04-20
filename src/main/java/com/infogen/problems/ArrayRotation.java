package com.infogen.problems;

import java.util.Arrays;

public class ArrayRotation {
    public static void main(String[] args) {
        ArrayRotation binaryGap = new ArrayRotation();
        int[] A = {1, 1, 2, 3, 5};
        int[] solution = binaryGap.solution(A, 42);

        System.out.println("result = " + Arrays.toString(solution));
    }

    public int[] solution(final int[] A, int K) {
        if (K<=0 || A.length == 0) {
            return A;
        }
        int[] lastRotatedArray = new int[A.length];
        int[] currentArray = new int[A.length];

        System.arraycopy(A,0, lastRotatedArray, 0, A.length);
        for (int i = 0; i < K; i++) {
            currentArray[0] = lastRotatedArray[A.length-1];
            System.arraycopy(lastRotatedArray, 0, currentArray, 1, A.length - 1);
            System.arraycopy(currentArray,0, lastRotatedArray, 0, A.length);
        }
        return lastRotatedArray;
    }
}
