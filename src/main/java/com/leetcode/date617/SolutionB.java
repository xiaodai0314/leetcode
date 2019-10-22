package com.leetcode.date617;

import com.util.ListNode;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 说明：不允许修改给定的链表。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 */
public class SolutionB {

    private ListNode hasCycle1(ListNode head) {
        if(head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return slow;
            }
        }
        return null;
    }
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode listNode = hasCycle1(head);
        if (listNode == null) {
            return null;
        }
        while (head != listNode) {
            head = head.next;
            listNode = listNode.next;
        }
        return head;
    }
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next =   listNode.next;

        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(3);
        listNode1.next.next.next = new ListNode(4);
        listNode1.next.next.next.next = new ListNode(5);
//        System.out.println(new SolutionB().detectCycle(listNode1) == null? " " : new SolutionB().detectCycle(listNode).val);
//        System.out.println(new SolutionB().detectCycle(listNode) == null? "" : new SolutionB().detectCycle(listNode).val);
        new SolutionB().reverseList(listNode1);
    }
}
