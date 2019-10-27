package com.mrglint.leetcode.week01.solution3;

/**
 * @author luhuancheng
 * @since 2019/9/7 8:56 下午
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 滑动窗口的起点
        int from = 0;
        // 滑动窗口的终点，初始值为-1，以为着窗口大小为0
        int to = -1;
        // 记录窗口中每个字符的个数
        int[] frequency = new int[256];
        // 窗口大小，在窗口中的所有字符都是唯一的。在遍历字符串过程中，该值会记录下遍历过的最大子串长度，
        // 也就是说最大的不重复子串的长度为窗口大小
        int win = 0;
        while (from < s.length()) {
            if (to + 1 < s.length() && frequency[s.charAt(to + 1)] == 0) {
                frequency[s.charAt(++to)]++;
            } else {
                frequency[s.charAt(from++)]++;
            }
            win = Math.max(win, to - from + 1);
        }
        return win;
    }
}
