package com.mrglint.leetcode.review.stack;

import java.util.Objects;
import java.util.Stack;

/**
 * @author luhuancheng
 * @since 2019-12-20 08:28
 */
public class MinStack {
    /**
     * initialize your data structure here.
     */
    private Stack<Integer> min;
    private Stack<Integer> storage;

    public MinStack() {
        min = new Stack<>();
        storage = new Stack<>();
    }

    public void push(int x) {
        storage.push(x);
        if (min.isEmpty() || min.peek() >= x) {
            min.push(x);
        }
    }

    public void pop() {
        Integer pop = storage.pop();
        if (!min.isEmpty() && Objects.equals(min.peek(), pop)) {
            min.pop();
        }
    }

    public int top() {
        return storage.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
