package dsa.datastructure.tree;

import dsa.datastructure.tree.problems.FindElement;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    public TreeNode root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(int value) {
        root = new TreeNode(value);
    }

    public static BinaryTree getBaseBinaryTree() {
        BinaryTree bTree = new BinaryTree(0);

        bTree.root.leftChild = new TreeNode(1);
        bTree.root.leftChild.leftChild = new TreeNode(11);
        bTree.root.leftChild.rightChild = new TreeNode(12);
        bTree.root.leftChild.leftChild.leftChild = new TreeNode(111);
        bTree.root.leftChild.leftChild.rightChild = new TreeNode(112);

        bTree.root.rightChild = new TreeNode(2);
        bTree.root.rightChild.leftChild = new TreeNode(21);
        bTree.root.rightChild.rightChild = new TreeNode(22);
        bTree.root.rightChild.rightChild.leftChild = new TreeNode(211);
        bTree.root.rightChild.rightChild.rightChild = new TreeNode(222);

        return bTree;
    }

    public boolean addNode(int value) {
        TreeNode newNode = new TreeNode(value);
        if(root == null) {
            root = newNode;
            return true;
        }
        if(FindElement.isElementPresent(root, value))
            return false;
        TreeNode current = root;
        while(current != null) {
            if(value < current.value) {
                if(current.leftChild == null) {
                    current.leftChild = newNode;
                    return true;
                }
                current = current.leftChild;
            } else if (value > current.value ) {
                if(current.rightChild == null) {
                    current.rightChild = newNode;
                    return true;
                }
                current = current.rightChild;
            }
        }
        return false;
    }

    public void traverseInOrderRecursion(TreeNode root) {
        if(root != null) {
            traverseInOrderRecursion(root.leftChild);
            System.out.println(root.value);
            traverseInOrderRecursion(root.rightChild);
        }
    }

    public void traversePreOrderRecursion(TreeNode root) {
        if(root != null) {
            System.out.println(root.value);
            traversePreOrderRecursion(root.leftChild);
            traversePreOrderRecursion(root.rightChild);
        }
    }

    public void traversePostOrderRecursion(TreeNode root) {
        if(root != null) {
            traversePostOrderRecursion(root.leftChild);
            traversePostOrderRecursion(root.rightChild);
            System.out.println(root.value);
        }
    }

    public void traverseInOrder(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while(current != null || !stack.empty()) {
            while(current != null) {
                stack.push(current);
                current = current.leftChild;
            }
            current = stack.pop();
            values.add(current.value);
            current = current.rightChild;
        }
        values.stream().forEach(v -> System.out.println(v));
    }

    public void traversePreOrder(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while(current != null || !stack.empty()) {
            while(current != null) {
                values.add(current.value);
                stack.push(current);
                current = current.leftChild;
            }
            current = stack.pop().rightChild;
        }
        values.stream().forEach(v -> System.out.println(v));
    }

    public void traversePostOrder(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) {
            return;
        }
        stack.push(root);
        while(!stack.empty()) {
            TreeNode current = stack.pop();
            values.add(0,current.value);
            if(current.leftChild != null) {
                stack.push(current.leftChild);
            }
            if(current.rightChild != null) {
                stack.push(current.rightChild);
            }
        }
        values.stream().forEach(v -> System.out.println(v));
    }

    public void dfs(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()) {
            TreeNode current = stack.pop();
            values.add(current.value);
            if(current.rightChild != null) {
                stack.push(current.rightChild);
            }
            if(current.leftChild != null) {
                stack.push(current.leftChild);
            }
        }
        values.stream().forEach(v -> System.out.println(v));
    }

    public void bfs(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode current = queue.poll();
            values.add(current.value);
            if(current.leftChild != null) queue.add(current.leftChild);
            if(current.rightChild != null) queue.add(current.rightChild);
        }
        values.stream().forEach(v -> System.out.println(v));
    }
}