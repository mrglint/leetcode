package com.mrglint.leetcode.year2020.stack.solution20;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author luhuancheng
 * @since 2020-03-29 08:51
 */
public class Solution {

    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character top = stack.pop();
                if (!map.get(c).equals(top)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
