package com.mrglint.leetcode.year2020.array.solution125;

/**
 * @author luhuancheng
 * @since 2020-03-04 22:31
 */
public class Solution {
    public boolean isPalindrome(String s) {

        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            char iChar = s.charAt(i);
            char jChar = s.charAt(j);
            if (!Character.isLetterOrDigit(iChar)) {
                i++;
            } else if (!Character.isLetterOrDigit(jChar)) {
                j--;
            } else {
                if (Character.toLowerCase(iChar) != Character.toLowerCase(jChar)) {
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }
}
