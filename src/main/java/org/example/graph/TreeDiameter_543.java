package org.example.graph;

public class TreeDiameter_543 {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return max;

    }

    private int height(TreeNode node) {
        if (node == null) return 0;

        // post order traversal
        int left = height(node.left);
        int right = height(node.right);

        int diameter = left + right;
        max = Math.max(max, diameter);
        return 1 + Math.max(left, right);
    }
}
