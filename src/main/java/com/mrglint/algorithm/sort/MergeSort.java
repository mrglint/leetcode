package com.mrglint.algorithm.sort;

import java.util.Arrays;

/**
 * 自顶向下 归并排序
 * @author luhuancheng
 * @since 2019-11-30 15:53
 */
public class MergeSort implements SortFunction {

    @Override
    public void sort(int[] data) {
        mergeSort(data, 0, data.length - 1);
    }

    private void mergeSort(int[] data, int lo, int hi) {
        // 优化2：小数据量时使用插入排序进行排序
        // 因为归并排序的时间复杂度为O(nlogn)、插入排序最差时间复杂度为O(n ^ 2)
        if (hi - lo < 15) {
            SortUtils.insertSort(data, lo, hi);
            return;
        }

        int mid = lo + ((hi - lo) >> 1);
        mergeSort(data, lo, mid);
        mergeSort(data, mid + 1, hi);
        // 优化1：左右子数组都有序时，不进行归并
        if (data[mid] > data[mid + 1]) {
            merge(data, lo, mid, hi);
        }
    }

    private void merge(int[] data, int lo, int mid, int hi) {
        // 要归并的数据移动到temp
        int[] temp = new int[hi - lo + 1];
        for (int i = lo; i <= hi; i++) {
            temp[i - lo] = data[i];
        }

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                data[k] = temp[j - lo];
                j++;
            } else if (j > hi) {
                data[k] = temp[i - lo];
            } else if (temp[i - lo] < temp[j - lo]) {
                data[k] = temp[i - lo];
                i++;
            } else {
                data[k] = temp[j - lo];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] data = SortUtils.generateRandomArray(100000, 0, 100000);
        SortUtils.compareSort(data, Arrays.asList(new MergeSort(), new InsertSort()));
    }
}
