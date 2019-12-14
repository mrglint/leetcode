package com.mrglint.leetcode.week05.solution1143;

/**
 * @author luhuancheng
 * @since 2019-11-15 07:53
 */
public class Solution {
    /**
     * 解题思路：将text1、text2转为二维数组；从后往前比对，将问题转换为子问题，由于子问题的最优解可以推出问题的最优解，符合
     * 最优子结构，可以使用动态规划来解决.
     * LCS(S, T)
     * if S[i - 1] == T[j - 1] then LCS(S, T) = LCS(S[0, i-1), T[0, j -1)) + 1
     * if S[i - 1] != T[j - 1] then LCS(S, T) = max(LCS(S[0, i-1], T[0, j -1)), LCS(S[0, i-1), T[0, j -1]))
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        char[] text1Chars = text1.toCharArray();
        char[] text2Chars = text2.toCharArray();
        int text1Length = text1Chars.length;
        int text2Length = text2Chars.length;

        int[][] dp = new int[text1Length + 1][text2Length + 1];
        for (int i = 1; i <= text1Length; i++) {
            for (int j = 1; j <= text2Length; j++) {
                if (text1Chars[i - 1] == text2Chars[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[text1Length][text2Length];
    }
}
