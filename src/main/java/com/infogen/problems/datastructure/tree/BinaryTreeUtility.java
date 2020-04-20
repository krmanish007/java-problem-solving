package com.infogen.problems.datastructure.tree;

public class BinaryTreeUtility {
    private int min(Tree<Integer> root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        if (root.left == null) {
            return root.data;
        }

        return min(root.left);
    }

    private int max(Tree<Integer> root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        if (root.right == null) {
            return root.data;
        }

        return max(root.right);
    }


    private int depth(Tree<Integer> root) {
        if (root == null) {
            return 0;
        }
        if (root.right == null && root.left == null) {
            return 0;
        }

        int leftMaxDepth = 1+depth(root.left);
        int rightMaxDepth = 1+depth(root.right);
        return Math.max(leftMaxDepth, rightMaxDepth);
    }

    public static void main(String[] args) {

        int min = new BinaryTreeUtility().min(Tree.createSampleTree());
        System.out.println("min = " + min);

        int max = new BinaryTreeUtility().max(Tree.createSampleTree());
        System.out.println("max = " + max);

        int depth = new BinaryTreeUtility().depth(Tree.createSampleTree());
        System.out.println("depth = " + depth);
    }
}
