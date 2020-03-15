package com.mrglint.leetcode.year2020.queryset.solution447;


import java.util.HashMap;
import java.util.Map;

/**
 * @author luhuancheng
 * @since 2020-03-15 08:28
 */
public class Solution {

    public int numberOfBoomerangs(int[][] points) {

        int res = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> distanceMap = new HashMap<>();

            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    distanceMap.put(distance(points[i], points[j]), distanceMap.getOrDefault(distance(points[i], points[j]), 0) + 1);
                }
            }

            // 计算以点 point[i] 为中心，与之距离相等的3元组个数
            for (Map.Entry<Integer, Integer> entry : distanceMap.entrySet()) {
                // 存在两个点距离与 point[i] 相等时，计算
                if (entry.getValue() > 1) {
                    res += entry.getValue() * (entry.getValue() - 1);
                }
            }
        }

        return res;
    }

    /**
     * 计算两点距离
     * @param a
     * @param b
     * @return
     */
    private int distance(int[] a, int[] b) {
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }
}
