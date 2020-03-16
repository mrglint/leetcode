package com.mrglint.leetcode;

/**
 * @author luhuancheng
 * @since 2019/9/6 10:20 下午
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
    }

    public ListNode(int[] data) {
        this(data[0]);
        ListNode head = this;
        for (int i = 1; i < data.length; i++) {
            head.next = new ListNode(data[i]);
            head = head.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            res.append(cur.val);
            res.append(" -> ");
            cur = cur.next;
        }
        res.append("Null");
        return res.toString();

    }
}
