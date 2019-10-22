package com.algorithm.offer;

import com.util.ListNode;

/**
 * 链表中倒数第K个节点
 */
public class Offer22 {
    public static ListNode findKthToTail(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode p1 = head;
        while (p1 != null && k-- > 0) {
            p1 = p1.next;
        }
        if (k > 0) {
            return null;
        }
        ListNode p2 = head;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(2);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(4);
        ListNode result = findKthToTail(listNode, 2);
        System.out.println(result.val);
    }
}
