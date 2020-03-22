package com.mrglint.leetcode.year2020.linkedlist.solution445;

import com.mrglint.leetcode.ListNode;

import java.util.Stack;

/**
 * @author luhuancheng
 * @since 2020-03-22 07:59
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> l1Stack = new Stack<>();
        Stack<Integer> l2Stack = new Stack<>();

        while (l1 != null) {
            l1Stack.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            l2Stack.push(l2.val);
            l2 = l2.next;
        }

        ListNode list = new ListNode(0);
        int sum = 0;
        while (!l1Stack.isEmpty() || !l2Stack.isEmpty()) {
            if (!l1Stack.isEmpty()) {
                sum += l1Stack.pop();
            }
            if (!l2Stack.isEmpty()) {
                sum += l2Stack.pop();
            }
            // 维护链表
            list.val = sum % 10;
            // 链表头节点设置为进位值，方便返回时判断是否需要保留头节点
            ListNode head = new ListNode(sum / 10);
            head.next = list;
            list = head;

            sum /= 10;
        }

        return list.val == 0 ? list.next : list;
    }
}
