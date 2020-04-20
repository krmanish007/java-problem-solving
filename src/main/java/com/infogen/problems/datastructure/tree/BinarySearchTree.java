package com.infogen.problems.datastructure.tree;

public class BinarySearchTree<E> {
    private int countNodes(Tree<E> root) {
        if(root == null){
            return 0;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }


    public Tree<Integer> addNode(Tree<Integer> head, Tree<Integer> nodeToAdd) {
        if (head == null) {
            return nodeToAdd;
        }
        if (head.data < nodeToAdd.data) {
            head.right = addNode(head.right, nodeToAdd);
        } else {
            head.left = addNode(head.left, nodeToAdd);
        }
        return head;
    }

    public Tree<Integer> lookup(Tree<Integer> head, Integer data) {
        if (head == null) {
            return null;
        } else if (head.data == data){
            return head;
        }

        if (head.data < data) {
            return lookup(head.right, data);
        } else {
            return lookup(head.left, data);
        }
    }

    public static void main(String[] args) {
        int countNodes = new BinarySearchTree<Integer>().countNodes(Tree.createSampleTree());
        System.out.println("countNodes = " + countNodes);

        Tree<Integer> insertTree = new BinarySearchTree<Integer>().addNode(Tree.createSampleTree(), new Tree<>(8));
        System.out.println("insertTree = " + insertTree);

        Tree<Integer> lookupTree = new BinarySearchTree<Integer>().lookup(insertTree, 3);
        System.out.println("lookupTree = " + lookupTree);


    }
}
