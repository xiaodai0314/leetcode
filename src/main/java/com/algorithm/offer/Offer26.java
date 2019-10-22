package com.algorithm.offer;

import com.util.TreeNode;

/**
 * 树的子结构
 */
public class Offer26 {
    public static boolean hasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        return isSubtreeWithRoot(root1, root2) || hasSubtree(root1.left, root2) || hasSubtree(root1.right, root2);
    }

    private static boolean isSubtreeWithRoot(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return false;
        }
        if (root2 == null) {
            return true;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isSubtreeWithRoot(root1.left, root2.left) && isSubtreeWithRoot(root1.right, root2.right);
    }

    public static void main(String[] args) {
    }
}
