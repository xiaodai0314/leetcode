package com.algorithm.offer;

import com.util.TreeNode;

/**
 * 二叉树的镜像
 */
public class Offer27 {
    public static void mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        swap(root);
        mirror(root.left);
        mirror(root.right);
    }
    private static void swap(TreeNode root) {
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
    }
}
