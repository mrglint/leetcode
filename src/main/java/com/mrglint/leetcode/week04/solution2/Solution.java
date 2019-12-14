package com.mrglint.leetcode.week04.solution2;

import com.mrglint.leetcode.ListNode;

import java.util.Objects;

/**
 * @author luhuancheng
 * @since 2019-11-08 06:57
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 哨兵节点
        ListNode sentinel = new ListNode(0);
        ListNode head = sentinel;
        int carry = 0;
        while (Objects.nonNull(l1) || Objects.nonNull(l2)) {
            int sum = carry;
            if (Objects.nonNull(l1)) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (Objects.nonNull(l2)) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            int val = sum % 10;
            // 利用哨兵，减少判空处理
            head.next = new ListNode(val);
            head = head.next;
        }
        if (carry != 0) {
            head.next = new ListNode(carry);
        }
        return sentinel.next;
    }
}
