package com.mrglint.leetcode.year2020.linkedlist.solution21;

import com.mrglint.leetcode.ListNode;

/**
 * @author luhuancheng
 * @since 2020-03-22 12:10
 */
public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;

        while (l1 != null && l2 != null) {
            ListNode node;
            if (l1.val < l2.val) {
                node = l1;
                l1 = l1.next;
            } else {
                node = l2;
                l2 = l2.next;
            }
            cur.next = node;
            cur = cur.next;
        }
        cur.next = (l1 == null) ? l2 : l1;
        return dummyHead.next;
    }
}
