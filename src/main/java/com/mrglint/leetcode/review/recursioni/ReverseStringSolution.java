package com.mrglint.leetcode.review.recursioni;

/**
 * @author luhuancheng
 * @since 2020-01-01 10:31
 */
public class ReverseStringSolution {
    public void reverseString(char[] s) {
        reverseString(s, 0, s.length - 1);
    }

    private void reverseString(char[] s, int begin, int end) {
        if (begin >= end) {
            return;
        }
        char temp = s[begin];
        s[begin] = s[end];
        s[end] = temp;
        reverseString(s, begin + 1, end - 1);
    }
}
