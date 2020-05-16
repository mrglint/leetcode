package com.mrglint.leetcode.year2020.linkedlist.solution141;

import com.mrglint.leetcode.ListNode;

/**
 * @author luhuancheng
 * @since 2020-05-16 21:07
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
