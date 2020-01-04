package com.mrglint.leetcode.review.recursion;

import com.mrglint.leetcode.ListNode;

/**
 * @author luhuancheng
 * @since 2020-01-01 10:45
 */
public class SwapPairSolution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = newHead.next;
        newHead.next = head;
        newHead.next.next = swapPairs(newHead.next.next);
        return newHead;
    }

    public static void main(String[] args) {
        SwapPairSolution solution = new SwapPairSolution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode listNode = solution.swapPairs(head);
        System.out.println(listNode);
    }
}
