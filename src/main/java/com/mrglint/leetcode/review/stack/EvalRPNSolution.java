package com.mrglint.leetcode.review.stack;

import java.util.Objects;
import java.util.Stack;

/**
 * @author luhuancheng
 * @since 2019-12-23 08:13
 */
public class EvalRPNSolution {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (Objects.equals("+", s) || Objects.equals("-", s) || Objects.equals("*", s) || Objects.equals("/", s)) {
                Integer n2 = stack.pop();
                Integer n1 = stack.pop();
                switch (s) {
                    case "+":
                        stack.push(n1 + n2);
                        break;
                    case "-":
                        stack.push(n1 - n2);
                        break;
                    case "*":
                        stack.push(n1 * n2);
                        break;
                    case "/":
                        stack.push(n1 / n2);
                        break;
                    default:

                }
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}
