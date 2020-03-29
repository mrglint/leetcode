package com.mrglint.leetcode.year2020.stack.solution150;

import java.util.Stack;

/**
 * @author luhuancheng
 * @since 2020-03-29 10:36
 */
public class Solution {

    public int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                Integer num2 = nums.pop();
                Integer num1 = nums.pop();
                switch (s) {
                    case "+":
                        nums.push(num1 + num2);
                        break;
                    case "-":
                        nums.push(num1 - num2);
                        break;
                    case "*":
                        nums.push(num1 * num2);
                        break;
                    case "/":
                        nums.push(num1 / num2);
                        break;
                    default:
                }
            } else {
                nums.push(Integer.valueOf(s));
            }
        }
        return nums.pop();
    }
}
