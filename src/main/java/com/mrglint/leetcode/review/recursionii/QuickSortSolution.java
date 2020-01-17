package com.mrglint.leetcode.review.recursionii;

/**
 * @author luhuancheng
 * @since 2020-01-12 17:38
 */
public class QuickSortSolution {
    public void quickSort(int [] data) {
        quickSort(data, 0, data.length - 1);
    }

    private void quickSort(int[] data, int lo, int hi) {
        if (lo > hi) {
            return;
        }
        int p = partition(data, lo, hi);
        quickSort(data, lo, p - 1);
        quickSort(data, p + 1, hi);
    }

    private int partition(int[] data, int lo, int hi) {
        // 标定点
        int value = data[lo];
        // 规定 [lo + 1, j] < value
        int j = lo;
        // 规定 [j + 1， i) > value
        for (int i = lo + 1; i <= hi; i++) {
            // 当data[i] < value 说明它应该处于左端，那么将data[i] 与 data[j + 1] 交换
            if (data[i] < value) {
                int temp = data[j + 1];
                data[j + 1] = data[i];
                data[i] = temp;
                j++;
            }
        }
        // 将标定点的值放到排好序的位置
        int temp = data[j];
        data[j] = data[lo];
        data[lo] = temp;

        return j;
    }
}
