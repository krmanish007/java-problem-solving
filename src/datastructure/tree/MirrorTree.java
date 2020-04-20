package datastructure.tree;

public class MirrorTree<E> {
    private void mirror(Tree<E> root) {
        if(root == null){
            return;
        }

        mirror(root.left);
        mirror(root.right);

        Tree<E> temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public static void main(String[] args) {
        Tree<Integer> tree = Tree.createSampleTree();
        new MirrorTree<Integer>().mirror(tree);
        System.out.println("tree = " + tree);
    }
}
