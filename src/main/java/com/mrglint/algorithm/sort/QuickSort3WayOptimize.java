package com.mrglint.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 优化版本
 * 优化点：
 * 1. 采用三路快排的思路，避免存在大量重复元素时退化为O(n ^ 2)
 *
 * @author luhuancheng
 * @since 2019-11-30 22:25
 */
public class QuickSort3WayOptimize implements SortFunction {

    private Random random = new Random();

    @Override
    public void sort(int[] data) {
        sort(data, 0, data.length - 1);
    }

    private void sort(int[] data, int lo, int hi) {
        // 优化一：数据量较小时，直接使用插入排序进行排序操作
        if (hi - lo <= 15) {
            SortUtils.insertSort(data, lo, hi);
            return;
        }

        // 随机分界点. random.nextInt(hi - lo + 1) 生成 [0, hi - lo + 1) 之间的数值（即[0, hi - lo])
        // random.nextInt(hi - lo + 1) + lo ==> 数值范围为 [lo, hi]
        int randomIndex = random.nextInt(hi - lo + 1) + lo;
        SortUtils.swap(data, lo, randomIndex);

        // 选择第一个元素作为「分界点」
        int value = data[lo];

        // partition
        // data[lo + 1, lt] < value
        int lt = lo;

        // data[gt, hi] > value
        int gt = hi + 1;

        // data[lt + 1, i) == value，其中i为需要考察大小的元素索引
        int i = lo + 1;

        while (i < gt) {
            if (data[i] < value) {
                SortUtils.swap(data, i, lt + 1);
                lt++;
                i++;
            } else if (data[i] > value) {
                SortUtils.swap(data, i, gt - 1);
                gt--;
            } else {
                i++;
            }
        }
        SortUtils.swap(data, lo, lt);
        // 继续排序 < value 部分
        sort(data, lo, lt - 1);
        // 继续排序 > value 部分
        sort(data, gt, hi);
    }

    public static void main(String[] args) {
        int[] data = SortUtils.generateRandomArray(1000000, 1, 1000000);
        SortUtils.compareSort(data, Arrays.asList(new MergeSort(), new QuickSort3WayOptimize()));
    }

}
