package com.mrglint.leetcode.year2020.linkedlist.solution2;

import com.mrglint.leetcode.ListNode;

/**
 * @author luhuancheng
 * @since 2020-03-21 08:36
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultDummyHead = new ListNode(-1);
        ListNode p = resultDummyHead;

        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum;

            if (l1 != null && l2 != null) {
                sum = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 == null) {
                sum = l2.val + carry;
                l2 = l2.next;
            } else {
                sum = l1.val + carry;
                l1 = l1.next;
            }

            p.next = new ListNode((sum % 10));
            p = p.next;
            carry = sum / 10;
        }
        if (carry != 0) {
            p.next = new ListNode(carry);
        }

        return resultDummyHead.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = solution.addTwoNumbers(new ListNode(new int[]{2, 4}), new ListNode(new int[]{5, 6, 4}));
        System.out.println(listNode);
    }

}
