package com.mrglint.leetcode.week03.solution435;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 每次选取最早结束、且开始时间不与之前区间重叠的区间。
 * 思路：结束时间越早，留给之后的空间就越多
 * @author luhuancheng
 * @since 2019-11-04 13:31
 */
public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[1]));

        int bound = intervals[0][1];
        int result = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < bound) {
                result++;
            } else {
                bound = intervals[i][1];
            }
        }
        return result;
    }
}
