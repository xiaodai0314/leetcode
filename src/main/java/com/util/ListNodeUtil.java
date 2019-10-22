package com.util;

public class ListNodeUtil {
    public static String pringListNode(ListNode head) {
        if (head == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) {
                sb.append(" --> ");
            }
            head = head.next;
        }
        return sb.toString();
    }
}
