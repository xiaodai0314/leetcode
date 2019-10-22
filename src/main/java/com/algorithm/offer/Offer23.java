package com.algorithm.offer;

import com.util.ListNode;

/**
 * 链表中环的入口节点
 */
public class Offer23 {
    public static ListNode entryNodeOfLoop(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        p1 = p1.next;
        p2 = p2.next.next;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                p1 = head;
                while (p1 != p2) {
                    p1 = p1.next;
                    p2 = p2.next;
                }
                return p1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(2);
        ListNode loop = new ListNode(3);
        listNode.next.next.next = loop;
        loop.next = new ListNode(4);
        loop.next.next = new ListNode(5);
        loop.next.next.next = new ListNode(6);
        loop.next.next.next.next = new ListNode(7);
        loop.next.next.next.next.next = loop;
        ListNode result = entryNodeOfLoop(listNode);
        System.out.println(result.val);

    }
}
