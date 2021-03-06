package com.mrglint.leetcode.year2020.linkedlist.solution328;

import com.mrglint.leetcode.ListNode;

/**
 * @author luhuancheng
 * @since 2020-03-20 21:50
 */
public class Solution {
    /**
     * 使用双指针
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    /**
     * 这种写法太难懂了
     * @param head
     * @return
     */
    public ListNode oddEvenList2(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode begin = head;
        ListNode p = head;
        ListNode temp = null;
        int count = 1;

        while (p.next != null) {
            if ((count + 1) % 2 != 0) {
                temp = p.next;
                p.next = temp.next;
                temp.next = begin.next;
                begin.next = temp;
                begin = begin.next;
            } else {
                p = p.next;
            }
            count++;
        }
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode data = new ListNode(new int[]{1, 2, 3, 4, 5});
        ListNode listNode = solution.oddEvenList2(data);
        System.out.println(data);
        System.out.println(listNode);
    }
}
