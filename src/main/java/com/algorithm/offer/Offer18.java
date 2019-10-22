package com.algorithm.offer;

import com.util.ListNode;


public class Offer18 {

    /**
     * 删除单向链表的一个节点  时间复杂度O(1)
     */
    public static ListNode deleteNode(ListNode head, ListNode del) {
        if (head == null || del == null) {
            return null;
        }
        if (del.next != null) {
            //要删除的节点不是尾节点
            ListNode next = del.next;
            del.val = next.val;
            del.next = next.next;
        } else {
            if (head == del) {
                //只有一个节点
                return null;
            } else {
                //要删除的节点是尾节点,遍历删除
                ListNode cur = head;
                while (cur.next != del) {
                    cur = cur.next;
                }
                cur.next = null;
            }
        }
        return head;
    }


    /**
     * 删除排序链表的重复节点
     * @param head
     * @return
     */
    public static ListNode deleteDuplication(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        if (head.val == next.val) {
            while (next != null && head.val == next.val) {
                next = next.next;
            }
            return deleteDuplication(next);
        } else {
            head.next = deleteDuplication(head.next);
            return head;
        }
    }

    private static void printListNoed(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
            printListNoed(head);
            break;
        }

    }
    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(1);
        ListNode del = new ListNode(1);
        listNode.next.next.next = del;
        del.next = new ListNode(4);
        del.next.next = new ListNode(5);
        deleteDuplication(listNode);
        printListNoed(listNode);
    }
}
