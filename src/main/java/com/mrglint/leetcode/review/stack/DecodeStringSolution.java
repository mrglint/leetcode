package com.mrglint.leetcode.review.stack;

import java.util.Stack;

/**
 * 使用两个栈，一个存放数字，一个存放字符串；声明一个字符串变量
 * 当遇到 [ 时，将数字放入数字的栈中，将字符串放入字符串的栈中
 * 当遇到 ] 时，弹出数字栈顶元素 * 字符串栈顶元素
 * 其余情况 字符串拼接
 *
 * @author luhuancheng
 * @since 2019-12-27 21:43
 */
public class DecodeStringSolution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder res = new StringBuilder();
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                k = k * 10 + s.charAt(i) - '0';
            } else if (s.charAt(i) == '[') {
                strStack.push(res);
                numStack.push(k);
                k = 0;
                res = new StringBuilder();
            } else if (s.charAt(i) == ']') {
                StringBuilder temp = res;
                res = strStack.pop();
                Integer repeatTimes = numStack.pop();
                for (int j = 0; j < repeatTimes; j++) {
                    res.append(temp);
                }
            } else {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        DecodeStringSolution solution = new DecodeStringSolution();
        System.out.println(solution.decodeString("3[a]2[bc]"));
        System.out.println(solution.decodeString("100[leetcode]"));
    }
}
