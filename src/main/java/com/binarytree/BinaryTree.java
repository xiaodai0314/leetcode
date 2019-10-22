package com.binarytree;

import com.util.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    /**
     * 构建二叉树
     * @param inputList 输入序列0
     * @return
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;
        if(inputList == null || inputList.isEmpty()) {
            return null;
        }
        Integer data = inputList.removeFirst();
        if(data != null) {
            node = new TreeNode(data);
            node.left = createBinaryTree(inputList);
            node.right = createBinaryTree(inputList);
        }
        return node;
    }

    /**
     * 前序遍历
     * @param node
     */
    public static void preOrderTraveral(TreeNode node) {
        if(node == null) {
            return;
        }
        System.out.println(node.val);
        preOrderTraveral(node.left);
        preOrderTraveral(node.right);
    }

    /**
     * 中序遍历
     * @param node
     */
    public static void inOrderTraveral(TreeNode node) {
        if(node == null) {
            return;
        }
        inOrderTraveral(node.left);
        System.out.println(node.val);
        inOrderTraveral(node.right);
    }

    /**
     * 后序遍历
     * @param node
     */
    public static void postOrderTraveral(TreeNode node) {
        if(node == null) {
            return;
        }
        postOrderTraveral(node.left);
        postOrderTraveral(node.right);
        System.out.println(node.val);
    }

    /**
     * 层序遍历
     * @param root
     */
    public static void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.val);
            if(node.left != null) {
                queue.offer(node.left);
            }
            if(node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(new Integer[]{3,2,9,null,null,10,null,null
        ,8,null,4}));
        TreeNode treeNode = createBinaryTree(inputList);
        System.out.println("前序遍历");
        preOrderTraveral(treeNode);
        System.out.println("中序遍历");
        inOrderTraveral(treeNode);
        System.out.println("后序遍历");
        postOrderTraveral(treeNode);
    }
}
