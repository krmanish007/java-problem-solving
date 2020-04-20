package com.infogen.problems;

public class ReverseString {


    private static String reverse(final String input) {
        return new StringBuilder(input)
                .reverse()
                .toString();
    }

    private static String reverseRecursive(final String input) {
        if (input.isEmpty()) {
            return input;
        }
        return reverseRecursive(input.substring(1)) + input.charAt(0);
    }

    public static void main(String[] args) {
        System.out.println("reverse(Manish) = " + reverse("Manish"));
        System.out.println("reverseRecursive(Manish) = " + reverseRecursive("Manish"));
    }
}
