package com.mrglint.leetcode.year2020.linkedlist.solution234;

import com.mrglint.leetcode.ListNode;

/**
 * @author luhuancheng
 * @since 2020-03-28 08:27
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode rightHead = slow.next;
        slow.next = null;
        rightHead = reverse(rightHead);

        ListNode leftCur = head;
        ListNode rightCur = rightHead;
        while (leftCur != null && rightCur != null) {
            if (leftCur.val != rightCur.val) {
                return false;
            }
            leftCur = leftCur.next;
            rightCur = rightCur.next;
        }
        return true;
    }

    private ListNode reverse(ListNode node) {
        if (node.next == null) {
            return node;
        }
        ListNode ret = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return ret;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.isPalindrome(new ListNode(new int[]{1, 0, 1}));
    }
}
