package datastructure.tree;

public class DepthFirstTraverseTree<E> {
    private E traverse(Tree<E> root) {
        if(root == null){
            return null;
        }
        traverse(root.left);
        traverse(root.right);

        return root.getData();
        //print child and then parent
        //System.out.println("tree = " + root.getData());
    }

    public static void main(String[] args) {

        Integer traverse = new DepthFirstTraverseTree<Integer>().traverse(Tree.createSampleTree());
        System.out.println("traverse = " + traverse);
    }
}
