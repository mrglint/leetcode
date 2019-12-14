package com.mrglint.algorithm.dp;

/**
 * @author luhuancheng
 * @since 2019-12-05 07:27
 */
public class LongestCommonSubsequence {

    /**  text1
     * t   a b c d e
     * e   a 1 1 1 1 1
     * x   c 1
     * 2   e 1
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        char[] text1Char = text1.toCharArray();
        char[] text2Char = text2.toCharArray();
        int text1Length = text1Char.length;
        int text2Length = text2Char.length;

        int[][] dp = new int[text1Length + 1][text2Length + 1];
        for (int i = 1; i <= text1Length; i++) {
            for (int j = 1; j <= text2Length; j++) {
                if (text1Char[i - 1] == text2Char[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1Length][text2Length];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence subsequence = new LongestCommonSubsequence();
        int i = subsequence.longestCommonSubsequence("bklgfivmpozinybwlovcnafqfybodkhabyrglsnen", "lcnqdmvsdopkvqvejijcdyxetuzonuhuzkpelmva");
        System.out.println(i);
    }
}
