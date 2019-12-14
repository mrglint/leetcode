package com.mrglint.leetcode.week04;

/**
 * 实现正则表达式：通配符有：*，匹配任意个任意字符；?, 匹配0个或1个任意字符
 *
 * @author luhuancheng
 * @since 2019-11-07 07:21
 */
public class PatternSolution {

    private boolean match = false;

    public boolean match(String pattern, String input) {
        match(pattern.toCharArray(), input.toCharArray(), 0, 0);
        return match;
    }

    private void match(char[] patternChar, char[] inputChar, int patternIndex, int inputIndex) {
        if (match) {
            return;
        }
        if (patternIndex == patternChar.length) {
            // 正则表达式遍历完毕时，输入字符串也遍历完毕。说明匹配成功
            if (inputIndex == inputChar.length) {
                match = true;
            }

            // 正则表达式遍历完毕时，输入字符串未遍历完毕
            return;
        }
        // 正则表达式未遍历完毕，继续考察
        if (patternChar[patternIndex] == '*') {
            for (int i = inputIndex; i < inputChar.length - inputIndex; i++) {
                match(patternChar, inputChar, patternIndex + 1, inputIndex + 1);
            }
        } else if (patternChar[patternIndex] == '?') {
            // 匹配0个任意字符
            match(patternChar, inputChar, patternIndex + 1, inputIndex);
            // 匹配一个任意字符
            match(patternChar, inputChar, patternIndex + 1, inputIndex + 1);
        } else if (inputIndex < inputChar.length && patternChar[patternIndex] == inputChar[inputIndex]) {
            // 非元字符，需要比对字符是否相等
            match(patternChar, inputChar, patternIndex + 1, inputIndex + 1);
        }
    }
}
