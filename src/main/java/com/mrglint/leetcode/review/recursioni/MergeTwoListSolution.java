package com.mrglint.leetcode.review.recursioni;

import com.mrglint.leetcode.ListNode;

/**
 * @author luhuancheng
 * @since 2020-01-05 07:27
 */
public class MergeTwoListSolution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        // 以l1作为链表头
        if (l1.val < l2.val) {
            // 分解为子问题：合并以l1.next开头、l2两个链表
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            // 分解为子问题：合并以l1开头、l2.next两个链表
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

}
