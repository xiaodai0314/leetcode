package com.algorithm.offer;

import com.util.ListNode;
import com.util.ListNodeUtil;

/**
 * 翻转链表
 */
public class Offer24 {
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(2);
        listNode.next.next.next = new ListNode(3);
        System.out.println(ListNodeUtil.pringListNode(listNode));
        ListNode result = reverseList(listNode);
        System.out.println(ListNodeUtil.pringListNode(result));
    }
}
