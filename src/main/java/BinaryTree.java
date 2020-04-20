import datastructure.tree.Tree;

public class BinaryTree {

    public int solution(Tree T) {
        if(perfectTree(T)) {
            return countNodes(T);
        }
        if (T.getLeft() == null || perfectTree(T.getLeft())) {

        }
        return 0;
    }

    private int countNodes(Tree root) {
        if(root == null){
            return 0;
        }

        return 1 + countNodes(root.getLeft()) + countNodes(root.getRight());
    }

    private boolean perfectTree(Tree root) {
        int d = findADepth(root);
        return isPerfectRec(root, d, 0);
    }

    private int findADepth(Tree node) {
        int d = 0;
        while (node != null) {
            d++;
            node = node.getLeft();
        }
        return d;
    }

    private boolean isPerfectRec(Tree root, int d, int level) {
        if (root == null)
            return true;

        if (root.getLeft() == null && root.getRight() == null) {
            return (d == level + 1);
        }
        if (root.getLeft() == null || root.getRight() == null) {
            return false;
        }
        return isPerfectRec(root.getLeft(), d, level+1) && isPerfectRec(root.getRight(), d, level+1);
    }

    public static void main(String[] args) {
        BinaryTree solution = new BinaryTree();
        int result = solution.solution(null);
        System.out.println("result = " + result);
    }
}
