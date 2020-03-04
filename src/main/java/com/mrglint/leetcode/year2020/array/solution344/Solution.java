package com.mrglint.leetcode.year2020.array.solution344;

/**
 * @author luhuancheng
 * @since 2020-03-04 22:50
 */
public class Solution {
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            char c = s[i];
            s[i] = s[j];
            s[j] = c;
            i++;
            j--;
        }
    }
}
