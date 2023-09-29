package dsa.datastructure.tree.problems;

import dsa.datastructure.tree.BinaryTree;
import dsa.datastructure.tree.TreeNode;

import java.util.Stack;

public class MinimumOfTree extends BinaryTree {

    public static void main(String[] args) {
        BinaryTree binaryTree = getBaseBinaryTree();

        System.out.println("Min of Binary Tree Nodes: " +minOfTreeNodes(binaryTree.root));
        System.out.println("Min of Binary Tree Nodes: " +minOfTreeNodesRecursive(binaryTree.root));
    }

    private static int minOfTreeNodes(TreeNode root) {
        int min = Integer.MAX_VALUE;
        if(root == null) return min;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()) {
            TreeNode current = stack.pop();
            min = Math.min(min, current.value);
            if(current.leftChild != null) stack.push(current.leftChild);
            if(current.rightChild != null) stack.push(current.rightChild);
        }
        return min;
    }

    private static int minOfTreeNodesRecursive(TreeNode root) {
        if(root == null) return Integer.MAX_VALUE;
        int min = Math.min(minOfTreeNodesRecursive(root.leftChild), minOfTreeNodesRecursive(root.rightChild));
        return Math.min(root.value, min);
    }
}
