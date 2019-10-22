package com.algorithm.offer;

import com.util.ListNode;

public class Offer6 {
    public static void print(ListNode listNode) {
        if (listNode == null) {
            return;
        }
        print(listNode.next);
        System.out.printf(String.valueOf(listNode.val));
    }
    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(2);
        listNode.next.next.next = new ListNode(3);
        print(listNode);
    }
}
