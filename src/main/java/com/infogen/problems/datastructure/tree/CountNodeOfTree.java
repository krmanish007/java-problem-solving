package com.infogen.problems.datastructure.tree;

public class CountNodeOfTree<E> {
    private int countNodes(Tree<E> root) {
        if(root == null){
            return 0;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static void main(String[] args) {

        int countNodes = new CountNodeOfTree<Integer>().countNodes(Tree.createSampleTree());
        System.out.println("countNodes = " + countNodes);
    }
}
