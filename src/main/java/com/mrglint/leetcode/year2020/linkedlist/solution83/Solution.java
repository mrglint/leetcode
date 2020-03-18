package com.mrglint.leetcode.year2020.linkedlist.solution83;

import com.mrglint.leetcode.ListNode;

/**
 * @author luhuancheng
 * @since 2020-03-18 08:40
 */
public class Solution {

    /**
     * 递归语义：删除以head开头的链表中，重复的元素
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }
}
