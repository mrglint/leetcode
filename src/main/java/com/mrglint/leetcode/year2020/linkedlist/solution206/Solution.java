package com.mrglint.leetcode.year2020.linkedlist.solution206;

import com.mrglint.leetcode.ListNode;

/**
 * @author luhuancheng
 * @since 2020-03-16 07:51
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println(head);
        Solution solution = new Solution();
        ListNode res = solution.reverseList(head);
        System.out.println(res);
    }
}
