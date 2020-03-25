package com.mrglint.leetcode.year2020.linkedlist.solution19;

import com.mrglint.leetcode.ListNode;

/**
 * @author luhuancheng
 * @since 2020-03-25 20:54
 */
public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode slow = dummyHead;
        ListNode fast = dummyHead;

        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return dummyHead.next;
    }
}
