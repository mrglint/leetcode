package com.mrglint.leetcode.review.stack;

import java.util.Stack;

/**
 * 栈实现队列
 * @author luhuancheng
 * @since 2019-12-26 08:15
 */
public class MyQueue {

    private Stack<Integer> inStack = new Stack<>();
    private Stack<Integer> outStack = new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        inStack.push(x);
    }

    /** Removes the element from q1 front of queue and returns that element. */
    public int pop() {
        // 1. 先看下outStack是否有值，有则直接弹出
        // 2. 没有值则将inStack所有值放到outStack
        if (!outStack.isEmpty()) {
            return outStack.pop();
        }
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
        return outStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (!outStack.isEmpty()) {
            return outStack.peek();
        }
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
        return outStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

}
