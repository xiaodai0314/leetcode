package com.leetcode.first;

/*给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
        如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
        您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
        示例：
        输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
        输出：7 -> 0 -> 8
        原因：342 + 465 = 807*/
public class SolutionB {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int l1length = getLength(l1);
        int l2length = getLength(l2);
        ListNode listNode = new ListNode(-1);
        int index = l1length - l2length;
        if(index>0) {
            while (l2.next == null) {
                for(int i=0; i<index; i++) {
                    l2.next = new ListNode(0);
                }
            }
        } else {
            while (l1.next == null) {
                for(int i=0; i<index; i++) {
                    l1.next = new ListNode(0);
                }
            }
        }
        int temp = 0;
        while (l1.next != null && l1.val != -1) {
            int sum = l1.val + l2.val;
            if(sum>9) {
                sum = sum/10;
                if(temp == 1) {
                    listNode.next = new ListNode(sum+temp);
                }
                temp = 1;
                l1 = l1.next;
                l2 = l2.next;
            } else {
                temp = 0;
            }
        }
        return listNode;
    }
    public static int getLength(ListNode l1) {
        int result = 0;
        while (l1.next != null && l1.val != -1) {
            result ++;
        }
        return result;
    }
}
