package com.mrglint.leetcode.year2020.linkedlist.solution147;

import com.mrglint.leetcode.ListNode;

/**
 * @author luhuancheng
 * @since 2020-03-24 07:41
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode helper = new ListNode(0);
        ListNode pre = helper;
        ListNode current = head;

        while (current != null) {
            pre = helper;
            while (pre.next != null && pre.next.val < current.val) {
                pre = pre.next;
            }

            ListNode next = current.next;
            current.next = pre.next;
            pre.next = current;
            current = next;
        }
        return helper.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = solution.insertionSortList(new ListNode(new int[]{4, 2, 1, 3}));
        System.out.println(listNode);
    }
}
