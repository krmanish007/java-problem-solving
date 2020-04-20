package com.infogen.problems;

public class FrogJump {
    public int solution(int x, int y, int d) {
        if ((y - x) % d == 0) {
            return (y - x) / d;
        }
        return (y - x) / d + 1;
    }

    public static void main(String[] args) {
        int solution = new FrogJump().solution(Integer.MIN_VALUE, Integer.MAX_VALUE, 2);
        System.out.println("solution = " + solution);

    }
}
