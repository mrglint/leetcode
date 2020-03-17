package com.mrglint.leetcode.year2020.linkedlist.solution92;

import com.mrglint.leetcode.ListNode;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author luhuancheng
 * @since 2020-03-17 08:23
 */
public class Solution {
    /**
     * 1->2->3->4->5->NULL, m = 2, n = 4
     * 1->4->3->2->5->NULL
     *
     * 1. 找到反转后的尾结点（即翻转前的首节点）
     * 2. 将翻转后的尾结点的下一个节点
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode pre = dummyHead;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }

        ListNode tail = pre.next;
        AtomicReference<ListNode> left = new AtomicReference<>();

        pre.next = reverse(pre.next, n - m, left);
        tail.next = left.get();

        return dummyHead.next;
    }

    private ListNode reverse(ListNode head, int index, AtomicReference<ListNode> left) {
        if (index == 0) {
            left.set(head.next);
            return head;
        }
        ListNode tail = head.next;
        ListNode ret = reverse(head.next, index - 1, left);
        tail.next = head;
        return ret;
    }
}
