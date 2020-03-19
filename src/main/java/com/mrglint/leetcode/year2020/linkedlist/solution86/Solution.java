package com.mrglint.leetcode.year2020.linkedlist.solution86;

import com.mrglint.leetcode.ListNode;

/**
 * @author luhuancheng
 * @since 2020-03-19 07:43
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyLeft = new ListNode(-1);
        ListNode dummyRight = new ListNode(-1);
        ListNode p = dummyLeft;
        ListNode q = dummyRight;

        while (head != null) {
            if (head.val < x) {
                p.next = head;
                p = p.next;
            } else {
                // 需要拷贝一个节点，避免在 p.next = dummyRight.next 时形成循环链表
                q.next = new ListNode(head.val);
                q = q.next;
            }
            head = head.next;
        }
        p.next = dummyRight.next;
        return dummyLeft.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 4, 3, 2, 5, 2});
        Solution solution = new Solution();
        solution.partition(head, 3);
    }
}
