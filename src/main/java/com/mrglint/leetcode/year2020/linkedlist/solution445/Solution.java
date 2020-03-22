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
        Stack<Integer> resultStack = new Stack<>();

        while (l1 != null) {
            l1Stack.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            l2Stack.push(l2.val);
            l2 = l2.next;
        }

        ListNode dummyHead = new ListNode(-1);
        ListNode p = dummyHead;
        int carry = 0;
        while (!l1Stack.isEmpty() || !l2Stack.isEmpty()) {
            int sum;
            if (!l1Stack.isEmpty() && !l2Stack.isEmpty()) {
                sum = carry + l1Stack.pop() + l2Stack.pop();
            } else if (l1Stack.isEmpty()) {
                sum = carry + l2Stack.pop();
            } else {
                sum = carry + l1Stack.pop();
            }
            carry = sum / 10;
            resultStack.push(sum % 10);
        }

        if (carry != 0) {
            resultStack.push(carry);
        }

        while (!resultStack.isEmpty()) {
            p.next = new ListNode(resultStack.pop());
            p = p.next;
        }
        return dummyHead.next;
    }
}
