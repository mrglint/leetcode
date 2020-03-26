package com.mrglint.leetcode.year2020.linkedlist.solution61;

import com.mrglint.leetcode.ListNode;

/**
 * @author luhuancheng
 * @since 2020-03-26 07:31
 */
public class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        // 获取链表长度
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }

        // 由于进行 len 次旋转后，恢复为原链表. 因此实际上只需要 k % len 次旋转
        int mod = k % len;
        ListNode end = head;
        for (int i = 0; i < mod; i++) {
            end = end.next;
        }
        ListNode start = head;
        while (end.next != null) {
            start = start.next;
            end = end.next;
        }
        end.next = head;
        head = start.next;
        start.next = null;
        return head;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        long l = System.currentTimeMillis();
        ListNode listNode = solution.rotateRight(new ListNode(new int[]{1, 2, 3}), 2000000000);
        System.out.println(System.currentTimeMillis() - l);
        System.out.println(listNode);
    }
}
