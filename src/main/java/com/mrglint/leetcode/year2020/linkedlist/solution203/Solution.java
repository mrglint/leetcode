package com.mrglint.leetcode.year2020.linkedlist.solution203;

import com.mrglint.leetcode.ListNode;

/**
 * @author luhuancheng
 * @since 2020-03-22 08:33
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {

        // 删除头节点等于val的情况
        while (head != null && head.val == val) {
            ListNode delNode = head;
            head = delNode.next;
        }

        if (head == null) {
            return null;
        }

        // 删除链表中间节点等于val的情况
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val == val) {
                // 删除节点
                ListNode delNode = cur.next;
                cur.next = delNode.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
