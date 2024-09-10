package com.leetcode.solutions;

/**
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/
 */
public class CountGoodNodesInBinaryTree {

    int goodNodesCount;

    public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return goodNodesCount;
    }

    private void dfs(TreeNode node, int max) {
        if (node == null) {
            return;
        }
        if (node.val >= max) {
            max = node.val;
            goodNodesCount += 1;
        }
        if (node.left != null) {
            dfs(node.left, max);
        }
        if (node.right != null) {
            dfs(node.right, max);
        }
    }

    private class TreeNode {
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
}
