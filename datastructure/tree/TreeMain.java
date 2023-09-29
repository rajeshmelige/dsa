package dsa.datastructure.tree;

public class TreeMain {

    public static void main(String[] args) {
        BinaryTree bTree = new BinaryTree(0);

        bTree.root.leftChild = new TreeNode(1);
        bTree.root.leftChild.leftChild = new TreeNode(11);
        bTree.root.leftChild.rightChild = new TreeNode(12);
        //bTree.root.leftChild.leftChild.leftChild = new TreeNode(111);
        //bTree.root.leftChild.leftChild.rightChild = new TreeNode(112);

        bTree.root.rightChild = new TreeNode(2);
        bTree.root.rightChild.leftChild = new TreeNode(21);
        bTree.root.rightChild.rightChild = new TreeNode(22);
        //bTree.root.rightChild.rightChild.leftChild = new TreeNode(211);
        //bTree.root.rightChild.rightChild.rightChild = new TreeNode(222);

        System.out.println("In Order Recursion");
        bTree.traverseInOrderRecursion(bTree.root);
        System.out.println("In Order Stack ");
        bTree.traverseInOrder(bTree.root);
        System.out.println("Pre Order Recursion");
        bTree.traversePreOrderRecursion(bTree.root);
        System.out.println("Pre Order Stack");
        bTree.traversePreOrder(bTree.root);
        System.out.println("Post Order Recursion");
        bTree.traversePostOrderRecursion(bTree.root);
        System.out.println("Post Order Stack");
        bTree.traversePostOrder(bTree.root);

        System.out.println("DFS Stack");
        bTree.dfs(bTree.root);
        System.out.println("BFS Queue");
        bTree.bfs(bTree.root);

    }
}
