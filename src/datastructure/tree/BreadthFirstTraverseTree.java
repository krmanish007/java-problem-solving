package datastructure.tree;

import datastructure.linear.Queue;

public class BreadthFirstTraverseTree<E> {
    private void traverse(Tree<E> root) {
        if(root == null){
            return;
        }

        Queue<Tree<E>> queue = new Queue<>();
        queue.enqueue(root);

        while (!queue.isEmpty()) {
            Tree<E> node = queue.dequeue();

            System.out.println("node.data = " + node);
            if (node.left != null) queue.enqueue(node.left);
            if (node.right != null) queue.enqueue(node.right);
        }
    }

    public static void main(String[] args) {
        new BreadthFirstTraverseTree<Integer>().traverse(Tree.createSampleTree());
    }
}
