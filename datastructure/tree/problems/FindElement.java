package dsa.datastructure.tree.problems;

import dsa.datastructure.tree.BinaryTree;
import dsa.datastructure.tree.TreeNode;

import java.util.Stack;

public class FindElement extends BinaryTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = getBaseBinaryTree();
        boolean isPresent = isElementPresent(binaryTree.root, 0);
        boolean isPresentRecursive = isElementPresentRecursive(binaryTree.root, 4);

        System.out.println("Is value present in Binary Tree: " +isPresent);
        System.out.println("Is value present in Binary Tree Recursive approach: " +isPresentRecursive);
    }

    public static boolean isElementPresentRecursive(TreeNode root, int i) {
        if(root == null) return false;
        if(root.value == i) return true;
        return isElementPresentRecursive(root.leftChild, i) || isElementPresentRecursive(root.rightChild,i);
    }

    public static boolean isElementPresent(TreeNode root, int i) {
        if(root == null) return false;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()) {
            TreeNode current = stack.pop();
            if(current.value == i) return true;
            if(current.leftChild != null) stack.push(current.leftChild);
            if(current.rightChild != null) stack.push(current.rightChild);
        }
        return false;
    }
}
