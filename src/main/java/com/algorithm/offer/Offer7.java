package com.algorithm.offer;

import com.util.TreeNode;

import java.util.HashMap;
import java.util.Map;
import com.binarytree.BinaryTree;

/**
 * 重建二叉树
 */
public class Offer7 {
    private static Map<Integer, Integer> indexForInOrders = new HashMap<>();

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++) {
            indexForInOrders.put(in[i], i);
        }
        return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
    }

    private static TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
        if (preL > preR) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preL]);
        int inIndex = indexForInOrders.get(root.val);
        int leftTreeSize = inIndex - inL;
        root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);
        root.right = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1);
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = reConstructBinaryTree(new int[]{1,2,4,7,3,5,6,8},new int[]{4,7,2,1,5,3,8,6});

        System.out.println("前序遍历");
        BinaryTree.preOrderTraveral(treeNode);
        System.out.println("中序遍历");
        BinaryTree.inOrderTraveral(treeNode);
        System.out.println("后序遍历");
        BinaryTree.postOrderTraveral(treeNode);
    }
}
