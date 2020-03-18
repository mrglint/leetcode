package com.mrglint.leetcode.year2020.linkedlist.solution92;

import com.mrglint.leetcode.ListNode;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author luhuancheng
 * @since 2020-03-17 08:23
 */
public class Solution {
    private ListNode succssor = null;

    /**
     * 从基本的链表反转 -> 反转前n个节点 -> 反转链表区间
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween3(ListNode head, int m, int n) {
        if (m <= 1) {
            return reverseN(head, n - m + 1);
        }
        // n - 1 ? 原来以head开头需要反转 m, n；下一层以head.next开头需要反转 m - 1, n - 1
        head.next = reverseBetween3(head.next, m - 1, n - 1);
        return head;
    }
    private ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            succssor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = succssor;
        return last;
    }

    /**
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween2(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        for (int i = 0; i < m - 1; i++) {
            prev = prev.next;
        }

        ListNode cur = prev.next;
        ListNode next = cur.next;
        for (int i = 0; i < n - m; i++) {
            cur.next = next.next;
            next.next = prev.next;
            prev.next = next;
            next = cur.next;
        }

        return dummyHead.next;

    }

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
