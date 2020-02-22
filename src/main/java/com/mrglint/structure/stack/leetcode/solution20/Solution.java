package com.mrglint.structure.stack.leetcode.solution20;

import java.util.Stack;

/**
 * @author luhuancheng
 * @since 2020-02-18 08:37
 */
public class Solution {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char topChar = stack.pop();
                if (topChar == '(' && c != ')') {
                    return false;
                }
                if (topChar == '{' && c != '}') {
                    return false;
                }
                if (topChar == '[' && c != ']') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
