package com.leetcode.date613;

import com.util.ListNode;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class SolutionA {
    public ListNode mergeTowLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        } else if(l2 == null) {
            return l1;
        } else if(l1.val < l2.val) {
            l1.next = mergeTowLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTowLists(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeTowLists2(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2:l1;
        return prehead.next;
    }

    public ListNode mergeThreeLists(ListNode l1, ListNode l2, ListNode l3) {
        ListNode listNode =  mergeTowLists2(l2, l3);
        ListNode result = mergeTowLists(l1, listNode);
        return result;
    }

    /**
     * 多个链表合并
     * @param lists
     * @return
     */
    //TODO
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode listNode = lists[0];
        for(int i=1;i<lists.length;i++) {
            listNode =  mergeTowLists2(listNode,lists[i]);
        }
        return listNode;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next = new ListNode(4);
        new SolutionA().mergeTowLists2(l1, l2);
    }
}
