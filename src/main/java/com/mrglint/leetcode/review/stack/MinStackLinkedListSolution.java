package com.mrglint.leetcode.review.stack;

/**
 * @author luhuancheng
 * @since 2019-12-20 08:28
 */
public class MinStackLinkedListSolution {

    private Node head;

    public void push(int x) {
        if (head == null) {
            head = new Node(x, x);
        } else {
            head = new Node(x, Math.min(x, head.min), head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.value;
    }

    public int getMin() {
        return head.min;
    }

    private class Node {
        int value;
        int min;
        Node next;

        Node(int value, int min) {
            this.value = value;
            this.min = min;
        }

        Node(int value, int min, Node next) {
            this(value, min);
            this.next = next;
        }
    }
}
