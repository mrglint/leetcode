package com.mrglint.leetcode.year2020.linkedlist.solution143;

import com.mrglint.leetcode.ListNode;

/**
 * 1 -> 2 -> 3 -> 4 -> 5
 * 1 -> 2 -> 3 -> 5 -> 4 从中间点之后第一个节点反转链表
 * 1 -> 5 -> 2 -> 4 -> 3 合并链表
 *
 * @author luhuancheng
 * @since 2020-03-27 08:06
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode leftHead = head;
        ListNode rightHead = slow.next;
        slow.next = null;
        rightHead = reverse(rightHead);

        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        for (int i = 0; leftHead != null || rightHead != null; i++) {
            if (i % 2 == 0) {
                cur.next = leftHead;
                cur = cur.next;
                leftHead = leftHead.next;
            } else {
                cur.next = rightHead;
                cur = cur.next;
                rightHead = rightHead.next;
            }
        }
        head = dummyHead.next;

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
        ListNode root = new ListNode(new int[]{1, 2, 3, 8});
        System.out.println(root);
        solution.reorderList(root);
        System.out.println(root);
    }
}
