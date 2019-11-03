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
            // 中间元素大于最后一个元素，说明[mid, data.length)是有序的，排除掉
            if (data[mid] < data[data.length - 1]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        FindNotOrderIndex findNotOrderIndex = new FindNotOrderIndex();
        System.out.println(findNotOrderIndex.notOrderIndex(new int[]{4, 5, 6, 7, 0, 1, 2}));
    }
}
