package datastructure.tree;

public class TreeNodeCount<E> {
    private int count(Tree<E> root) {
        if(root == null){
            return 0;
        }

        return 1 + count(root.left) + count(root.right);
    }

    public static void main(String[] args) {
        System.out.println("new BinaryTree<Integer>() = " + new TreeNodeCount<Integer>().count(Tree.createSampleTree()));
    }
}

