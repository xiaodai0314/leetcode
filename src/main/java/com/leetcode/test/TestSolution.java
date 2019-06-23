package com.leetcode.test;

import com.leetcode.first.ListNode;
import com.leetcode.first.Solution;
import com.leetcode.first.SolutionB;

public class TestSolution {

    public static void main(String[] args) {
        /*int[] nums = new int[]{2,15,7,11};
        int target = 9;
        int[] result = Solution.twoSum(nums, target);
        for (int i : result) {
            System.out.println(i);
        }*/
        ListNode l1 = new ListNode(-1);
        ListNode l2 = new ListNode(-1);
        l1.next = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next = new ListNode(3);
        l2.next = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next = new ListNode(4);
        ListNode result =  SolutionB.addTwoNumbers(l1, l2);
        while (result.next == null) {
            System.out.println(result.val);
            result = result.next;

        }
    }
}
