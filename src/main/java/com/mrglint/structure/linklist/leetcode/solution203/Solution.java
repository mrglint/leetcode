package com.mrglint.structure.linklist.leetcode.solution203;

import com.mrglint.leetcode.ListNode;

/**
 * @author luhuancheng
 * @since 2020-02-19 22:07
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {

        // 删除开头元素相等的
        while (head != null && head.val == val) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }

        if (head == null) {
            return null;
        }

        // 删除中间元素相等的
        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }

    public ListNode removeElements2(ListNode head, int val) {

        // 删除开头元素相等的
        while (head != null && head.val == val) {
            head = head.next;
        }

        if (head == null) {
            return null;
        }

        // 删除中间元素相等的
        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }

    public ListNode removeElements3(ListNode head, int val) {

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        // 删除中间元素相等的
        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }

    public ListNode removeElements4(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode res = removeElements4(head.next, val);
        if (head.val == val) {
            return res;
        } else {
            head.next = res;
            return head;
        }
    }

    public ListNode removeElements5(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        head.next = removeElements5(head.next, val);
        return head.val == val ? head.next : head;
    }



    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(2);
        list.next.next.next = new ListNode(1);

        Solution solution = new Solution();
        solution.removeElements3(list, 2);
    }
}
