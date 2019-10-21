package com.mrglint.leetcode.solution20;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

/**
 * @author luhuancheng
 * @since 2019-10-20 22:14
 */
public class Solution {

    public boolean isValid1(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> dict = new HashMap<>();
        dict.put(']', '[');
        dict.put(')', '(');
        dict.put('}', '{');
        for (Character c : s.toCharArray()) {
            if (c == '[') {
                stack.push(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty() || !Objects.equals(stack.pop(), dict.get(c))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    /**
     * 简化版本
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '(') {
                stack.push(')');
            } else {
                if (stack.isEmpty() || !Objects.equals(stack.pop(), c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
