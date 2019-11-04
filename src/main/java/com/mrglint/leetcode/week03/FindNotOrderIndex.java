package com.mrglint.leetcode.week03;

/**
 * @author luhuancheng
 * @since 2019-11-03 22:52
 */
public class FindNotOrderIndex {
    public int notOrderIndex(int[] data) {
        int lo = 0;
        int hi = data.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            // 中间数 > 尾端数，说明无序在右端
            if (data[mid] > data[hi]) {
                lo = mid + 1;
            } else {
                // 中间数 <= 尾端数，说明无序在左端
                hi = mid;
            }
        }
        return hi;
    }

    public static void main(String[] args) {
        FindNotOrderIndex findNotOrderIndex = new FindNotOrderIndex();
        System.out.println(findNotOrderIndex.notOrderIndex(new int[]{4, 5, 6, 7, 0, 1, 2}));
    }
}
