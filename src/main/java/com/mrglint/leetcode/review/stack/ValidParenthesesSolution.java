package com.mrglint.leetcode.review.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

/**
 * @author luhuancheng
 * @since 2019-12-21 07:59
 */
public class ValidParenthesesSolution {

    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (map.values().contains(c)) {
                stack.push(c);
            } else if (stack.isEmpty() || !Objects.equals(stack.pop(), map.get(c))){
                return false;
            }
        }
        return stack.isEmpty();
    }

}
