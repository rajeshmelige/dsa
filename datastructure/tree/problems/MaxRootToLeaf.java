package dsa.datastructure.tree.problems;

import dsa.datastructure.tree.BinaryTree;
import dsa.datastructure.tree.TreeNode;

import java.util.Stack;

public class MaxRootToLeaf extends BinaryTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = getBaseBinaryTree();

        System.out.println("Max root to leaf of Binary Tree Nodes: " +maxRootToLeaf(binaryTree.root));
        System.out.println("Max root to leaf of Binary Tree Nodes recursive: " +maxRootToLeafRecursive(binaryTree.root));
    }

    private static int maxRootToLeafRecursive(TreeNode root) {
        if(root == null) return Integer.MIN_VALUE;
        if(root.leftChild == null && root.rightChild == null) return root.value;
        int maxChild = Math.max(maxRootToLeafRecursive(root.leftChild), maxRootToLeafRecursive(root.rightChild));
        return root.value + maxChild;
    }

    private static int maxRootToLeaf(TreeNode root) {
        int maxPath = 0;
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) return Integer.MIN_VALUE;
        TreeNode current = root;
        TreeNode left = null;
        TreeNode right = null;
        while(current != null || !stack.empty()) {
            while(current != null) {
                stack.push(current);
                current = current.leftChild;
            }
            current = stack.pop();
            left = current;
            if(current.rightChild != null) {
                right = current.rightChild;
            }
            current = current.rightChild;

            maxPath = maxPath + Math.max(left.value, right.value);
        }
        /*while(!stack.empty()) {
            TreeNode current = stack.pop();
            if(current.leftChild == null && current.rightChild == null) {
                return maxPath + current.value;
            } else {
                maxPath = maxPath + current.value;
                if(current.leftChild.value > current.rightChild.value) {
                    stack.push(current.leftChild);
                } else {
                    stack.push(current.rightChild);
                }
            }
        }*/
        return maxPath;
    }
}
