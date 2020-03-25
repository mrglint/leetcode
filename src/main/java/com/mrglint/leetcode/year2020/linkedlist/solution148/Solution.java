package com.mrglint.leetcode.year2020.linkedlist.solution148;

import com.mrglint.leetcode.ListNode;
import javafx.util.Pair;

/**
 * O(nlogn) 时间复杂度排序列表
 *
 * @author luhuancheng
 * @since 2020-03-24 22:10
 */
public class Solution {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 计算出链表长度
        int len = 1;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode left;
        ListNode right;
        ListNode tail;

        for (int n = 1; n < len; n <<= 1) {
            cur = dummyHead.next;
            tail = dummyHead;
            while (cur != null) {
                left = cur;
                // 切出n个节点后，返回后半部分。n分别为[1、2、4、8 ... len)
                right = split(left, n);
                cur = split(right, n);

                // 合并两个有序链表
                Pair<ListNode, ListNode> merge = merge(left, right);
                tail.next = merge.getKey();
                tail = merge.getValue();
            }
        }
        return dummyHead.next;
    }

    private Pair<ListNode, ListNode> merge(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode prev = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        // 取得合并后链表最后一个节点
        while (prev.next != null) {
            prev = prev.next;
        }
        // 返回合并后链表的头节点和尾结点
        return new Pair<>(dummyHead.next, prev);
    }

    /**
     * 切分链表，返回后半部分
     *
     * @param head
     * @param n
     * @return
     */
    private ListNode split(ListNode head, int n) {
        while (--n > 0 && head != null) {
            head = head.next;
        }
        ListNode rest = head != null ? head.next : null;
        if (head != null) {
            head.next = null;
        }
        return rest;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode split = solution.sortList(new ListNode(new int[]{5, 1, 9, 2}));
        System.out.println(split);
    }
}
