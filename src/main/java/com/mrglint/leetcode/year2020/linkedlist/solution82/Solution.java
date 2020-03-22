package com.mrglint.leetcode.year2020.linkedlist.solution82;

import com.mrglint.leetcode.ListNode;

/**
 * @author luhuancheng
 * @since 2020-03-22 09:55
 */
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        ListNode cur = head;

        while (cur != null) {
            // 如果cur节点所在的值存在重复，则移动到最后一个节点
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }

            if (prev.next == cur) {
                // 说明cur不存在重复值
                prev = prev.next;
            } else {
                prev.next = cur.next;
            }

            cur = cur.next;
        }

        return dummyHead.next;
    }
}
