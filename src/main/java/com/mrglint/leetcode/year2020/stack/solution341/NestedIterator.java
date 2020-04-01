package com.mrglint.leetcode.year2020.stack.solution341;

import com.mrglint.leetcode.NestedInteger;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * @author luhuancheng
 * @since 2020-04-01 07:51
 */
public class NestedIterator implements Iterator<Integer> {

    private Stack<NestedInteger> stack = new Stack<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        pushNestedInteger(stack, nestedList);
    }

    private void pushNestedInteger(Stack<NestedInteger> stack, List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            pushNestedInteger(stack, stack.pop().getList());
        }

        return !stack.isEmpty();
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            return null;
        }
        return stack.pop().getInteger();
    }
}
