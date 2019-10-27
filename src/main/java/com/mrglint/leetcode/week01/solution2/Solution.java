package com.mrglint.leetcode.week01.solution2;

import com.mrglint.leetcode.ListNode;

/**
 * @author luhuancheng
 * @since 2019/9/6 10:21 下午
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1Header = l1;
        ListNode l2Header = l2;
        ListNode result = null;
        int carryValue = 0;
        ListNode resultHeader = null;
        while (l1Header != null || l2Header != null) {
            // 计算当前位的和
            int currentSum = carryValue;
            if (l1Header != null) {
                currentSum += l1Header.val;
                l1Header = l1Header.next;
            }
            if (l2Header != null) {
                currentSum += l2Header.val;
                l2Header = l2Header.next;
            }
            // 计算进位
            carryValue = currentSum / 10;
            // 进位后，当前位的值
            int current = currentSum % 10;
            if (result == null) {
                result = new ListNode(current);
                resultHeader = result;
            } else {
                result.next = new ListNode(current);
                result = result.next;
            }
        }
        if (carryValue != 0) {
            result.next = new ListNode(carryValue);
        }
        return resultHeader;
    }

}
