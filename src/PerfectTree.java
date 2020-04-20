import datastructure.tree.Tree;

import java.util.Arrays;
import java.util.stream.IntStream;

public class PerfectTree {

    static String areTheyEqual(int[] array_a, int[] array_b) {

        if (array_a.length!=array_b.length) {
            return "No";
        }
        Arrays.sort(array_a);
        Arrays.sort(array_b);

        return IntStream.range(0, array_a.length).anyMatch(i-> array_a[i]!=array_b[i]) ? "No" : "Yes";

    }

    public static void main(String[] args) {
        int a[] = {1,2,3};
        int b[] = {2,1,4};
        String s = areTheyEqual(a, b);
        
        System.out.println("s = " + s);
    }
    public int solution(Tree T) {
        PerfectBinaryTree perfectBinaryTree = findPerfectBinaryTree(T);
        return countNodes(perfectBinaryTree.tree);
    }

    private int countNodes(Tree root) {
        if(root == null){
            return 0;
        }

        return 1 + countNodes(root.getLeft()) + countNodes(root.getRight());
    }

    static class PerfectBinaryTree {
        boolean isPerfect;
        int height;
        Tree tree;
    };

    private PerfectBinaryTree findPerfectBinaryTree(Tree root) {

        final PerfectBinaryTree perfectBinaryTree = new PerfectBinaryTree();

        if (root == null) {
            perfectBinaryTree.isPerfect = true;
            perfectBinaryTree.height = 0;
            perfectBinaryTree.tree = null;
            return perfectBinaryTree;
        }

        PerfectBinaryTree leftPerfectBinaryTree = findPerfectBinaryTree(root.getLeft());
        PerfectBinaryTree rightPerfectBinaryTree = findPerfectBinaryTree(root.getRight());

        if (leftPerfectBinaryTree.isPerfect && rightPerfectBinaryTree.isPerfect && leftPerfectBinaryTree.height == rightPerfectBinaryTree.height) {
            perfectBinaryTree.height = leftPerfectBinaryTree.height + 1;
            perfectBinaryTree.isPerfect = true;
            perfectBinaryTree.tree = root;
            return perfectBinaryTree;
        }

        perfectBinaryTree.isPerfect = false;
        perfectBinaryTree.height = Math.max(leftPerfectBinaryTree.height, rightPerfectBinaryTree.height);
        perfectBinaryTree.tree = (leftPerfectBinaryTree.height > rightPerfectBinaryTree.height ? leftPerfectBinaryTree.tree : rightPerfectBinaryTree.tree);

        if (root.getLeft() == null || root.getRight() == null) {
            perfectBinaryTree.isPerfect = true;
            perfectBinaryTree.tree = null;
        }
        return perfectBinaryTree;
    }
}
