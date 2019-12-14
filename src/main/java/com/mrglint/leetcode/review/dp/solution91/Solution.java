package com.mrglint.leetcode.review.dp.solution91;

/**
 * @author luhuancheng
 * @since 2019-12-14 11:39
 */
public class Solution {
    /**
     * 定义状态 dp[i] 表示从索引0开始，到以索引i结尾所代表的字符串，解码数
     * dp方程 if (s[i - 1]s[i] <= 26) then dp[i] = dp[i - 2] + dp[i - 1]
     *       if (s[i - 1]s[i] > 26) then dp[i] = dp[i - 1]
     * 初始状态 dp[0] = s[0] == 0 ? 0 : 1
     *         dp[1] = s[0]s[1] <= 26 ? 2 : 1
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int pre = 1;
        int cur = 1;
        for (int i = 1; i < s.length(); i++) {
            int temp = cur;
            if (s.charAt(i) == '0') {
                // s[i - 1][i] = '10' or '20' 的时候
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                    cur = pre;
                } else {
                    // 例如：30 => 拆成3 和 0；0 无法解码，结果为0
                    return 0;
                }
            } else if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2' && s.charAt(i) >= '1' && s.charAt(i) <= '6') {
                cur += pre;
            }
            pre = temp;
        }
        return cur;
    }

}
