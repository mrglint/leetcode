package com.mrglint.leetcode.week02.solution22;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author luhuancheng
 * @since 2019-10-26 23:02
 */
public class Solution {

    /**
     * 第一种写法，按照递归的方式生成所有可能的括号组合
     * @param n
     * @return
     */
    public List<String> generateParenthesis1(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis1(0, 2 * n, "", result);
        return result;
    }
    private void generateParenthesis1(int stringLength, int maxLength, String parenthesis, List<String> result) {
        // 如果拼装的字符串长度达到上限，检验递归终止
        if (stringLength == maxLength) {
            // 检查生成的字符串是否符合括号对的要求
            if (checkValid(parenthesis)) {
                result.add(parenthesis);
            }
            return;
        }

        // 可以加左括号，后者右括号
        generateParenthesis1(stringLength + 1, maxLength, parenthesis + "(", result);
        generateParenthesis1(stringLength + 1, maxLength, parenthesis + ")", result);

    }
    /**
     * 检查符号是否合法
     * @param parenthesis
     * @return
     */
    private boolean checkValid(String parenthesis) {
        Stack<Character> stack = new Stack<>();
        for (Character c : parenthesis.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else {
                if (stack.isEmpty() || ')' != stack.pop()) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    /**
     * 递归解法
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        // 初始时，左右括号都未拼装，因此leftCount = 0，rightCount = 0，quota = n, 字符串为空字符串
        generateParenthesis(0, 0, n, "", result);
        return result;
    }

    /**
     *
     * @param leftCount 左括号已用个数
     * @param rightCount 右括号已用个数
     * @param quota 每种括号的配额数量
     * @param parenthesis 拼装上左右括号之后的字符串
     * @param result 结果集
     */
    private void generateParenthesis(int leftCount, int rightCount, int quota, String parenthesis, List<String> result) {
        if (leftCount == quota && rightCount == quota) {
            result.add(parenthesis);
            return;
        }

        // 选择性地添加左括号
        if (leftCount < quota) {
            generateParenthesis(leftCount + 1, rightCount, quota, parenthesis + "(", result);
        }
        // 选择性的添加右括号
        if (leftCount > rightCount) {
            generateParenthesis(leftCount, rightCount + 1, quota, parenthesis + ")", result);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> strings = solution.generateParenthesis1(3);
        System.out.println(strings); // [((())), (()()), (())(), ()(()), ()()()]
    }
}
