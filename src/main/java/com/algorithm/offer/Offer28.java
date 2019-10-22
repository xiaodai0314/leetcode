package com.algorithm.offer;

import com.util.TreeNode;

/**
 * 对称的二叉树
 */
public class Offer28 {
    public static boolean isSymmetrical(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetrical(root.left, root.right);
    }
    private static boolean isSymmetrical(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 ==null || t2 == null) {
            return false;
        }
        if (t1.val != t2.val) {
            return false;
        }
        return isSymmetrical(t1.left, t2.right) && isSymmetrical(t1.right, t2.left);
    }
}
