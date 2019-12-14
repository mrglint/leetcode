package com.mrglint.algorithm.sort;

import java.util.Arrays;

/**
 * 基础实现
 * 存在问题：
 * 1. 每次选取第一个元素作为分界点，可能导致分出来的两个部分不均衡。
 * 极端情况下(接近有序的数组)，除了第一个元素等于分界点，右边所有元素都大于分界点。退化为O(n ^ 2)
 *
 * @author luhuancheng
 * @since 2019-11-30 22:25
 */
public class QuickSortBasicImpl implements SortFunction {

    @Override
    public void sort(int[] data) {
        sort(data, 0, data.length - 1);
    }

    private void sort(int[] data, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int p = partition(data, lo, hi);
        sort(data, lo, p - 1);
        sort(data, p + 1, hi);
    }

    private int partition(int[] data, int lo, int hi) {
        // 选择第一个元素作为「分界点」
        int value = data[lo];
        // j定义为小于value的最后一个元素的索引, 那么j + 1则为第一个大于value的元素的索引
        // data[lo + 1, j] < v && data[j + 1, i) > v
        int j = lo;
        for (int i = lo + 1; i <= hi; i++) {
            if (data[i] < value) {
                SortUtils.swap(data, j + 1, i);
                j++;
            }
        }
        SortUtils.swap(data, lo, j);
        return j;
    }

    public static void main(String[] args) {
        int[] data = SortUtils.generateRandomArray(1000000, 1, 1000000);
        SortUtils.compareSort(data, Arrays.asList(new QuickSortBasicImpl(), new MergeSort()));
    }

}
