package dsa.datastructure.tree.problems;

import dsa.datastructure.tree.BinaryTree;
import dsa.datastructure.tree.TreeNode;

import java.util.Stack;

public class SumOfTreeNodes extends BinaryTree {

    public static void main(String[] args) {
        BinaryTree binaryTree = getBaseBinaryTree();
        int sumOfTreeNodes = sumOfTreeNodes(binaryTree.root);

        System.out.println("Sum of Binary Tree Nodes: " +sumOfTreeNodes);
        System.out.println("Sum of Binary Tree Nodes Recursive: " +sumRecursive(binaryTree.root));
    }

    private static int sumOfTreeNodes(TreeNode root) {
        int sum = 0;
        if(root == null) return sum;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()) {
            TreeNode current = stack.pop();
            sum+= current.value;
            if(current.leftChild != null) stack.push(current.leftChild);
            if(current.rightChild != null) stack.push(current.rightChild);
        }
        return sum;
    }

    private static int sumRecursive(TreeNode root) {
        if(root == null) return 0;
        return root.value + sumRecursive(root.rightChild) + sumRecursive(root.leftChild);
    }
}
