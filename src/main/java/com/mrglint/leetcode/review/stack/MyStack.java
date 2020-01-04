package com.mrglint.leetcode.review.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列实现栈
 *
 * @author luhuancheng
 * @since 2019-12-27 08:40
 */
public class MyStack {

    Queue<Integer> q1;
    Queue<Integer> q2;
    int top;

    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q1.offer(x);
        top = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (q1.size() > 1) {
            top = q1.poll();
            q2.offer(top);
        }
        Integer res = q1.remove();
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return res;
    }

    /** Get the top element. */
    public int top() {
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}
