package com.mrglint.leetcode.review.recursioni;

import com.mrglint.leetcode.ListNode;

/**
 * @author luhuancheng
 * @since 2020-01-03 08:10
 */
public class ReverListSolution {
    // 1 -> 2 -> 3 -> 4 -> null
    public ListNode reverseList(ListNode head) {
        // 空链表(head == null) ;最后一个节点，或者单节点的链表(head.next == null)
        if (head == null || head.next == null) {
            return head;
        }
        // 递归调用，反转head.next开头的链表
        ListNode p = reverseList(head.next);
        // p为以及反转完成的链表表头节点
        head.next.next = head;
        head.next = null;
        return p;
    }
}
