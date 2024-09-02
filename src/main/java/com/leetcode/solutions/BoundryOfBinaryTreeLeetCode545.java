package com.leetcode.solutions;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/boundary-of-binary-tree
 * <p>
 * https://www.youtube.com/watch?v=Jk3AbY-aH3g
 */


public class BoundryOfBinaryTreeLeetCode545 {

    public static void main(String[] args) {
        BoundryOfBinaryTreeLeetCode545 main = new BoundryOfBinaryTreeLeetCode545();
        main.boundaryOfBinaryTree(new TreeNode());
    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        result.add(root.val);

        // get the left boundary elements
        traverseLeftBoundary(root.left, result);

        // get the left side leaves
        processLeaves(root.left, result);

        // get the right side leaves
        processLeaves(root.right, result);

        // get the right boundary elements
        traverseRightBoundary(root.right, result);

        return result;

    }

    private void traverseLeftBoundary(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            result.add(node.val);
            traverseLeftBoundary(node.left, result);
        } else if (node.right != null) {
            result.add(node.val);
            traverseLeftBoundary(node.right, result);
        }
    }

    private void traverseRightBoundary(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        if (node.right != null) {
            traverseRightBoundary(node.right, result);
            result.add(node.val);
        } else if (node.left != null) {
            traverseRightBoundary(node.left, result);
            result.add(node.val);
        }

    }

    private void processLeaves(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        processLeaves(node.left, result);
        if (node.left == null && node.right == null) {
            result.add(node.val);
        }
        processLeaves(node.right, result);
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


