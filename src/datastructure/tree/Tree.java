package datastructure.tree;

public class Tree<E> {
    E data;
    Tree<E> left;
    Tree<E> right;

    public Tree(E data) {
        this.data = data;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Tree<E> getLeft() {
        return left;
    }

    public void setLeft(Tree<E> left) {
        this.left = left;
    }

    public Tree<E> getRight() {
        return right;
    }

    public void setRight(Tree<E> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }


    public static Tree<Integer> createSampleTree() {
        Tree<Integer> node4 = new Tree<>(1);
        node4.right = new Tree<>(10);

        Tree<Integer> node3 = new Tree<>(3);
        node3.right = node4;

        Tree<Integer> node1 = new Tree<>(2);
        node1.left = new Tree<>(1);
        node1.right = node3;

        Tree<Integer> node2 = new Tree<>(6);
        node2.left = new Tree<>(5);
        node2.right = new Tree<>(7);

        Tree<Integer> root = new Tree<>(8);
        root.left = node1;
        root.right = node2;

        return root;
    }
}
