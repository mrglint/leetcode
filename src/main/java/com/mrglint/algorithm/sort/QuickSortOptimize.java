package com.mrglint.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 优化版本
 * 优化点：
 * 1. 当子数组的数据量较小时，直接使用插入排序进行这一部分的排序操作
 * 2. 使用随机分界点来切分数组，避免极端情况下退化为O(n ^ 2)
 *
 * @author luhuancheng
 * @since 2019-11-30 22:25
 */
public class QuickSortOptimize implements SortFunction {

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
        int p = partition(data, lo, hi);
        sort(data, lo, p - 1);
        sort(data, p + 1, hi);
    }

    private int partition(int[] data, int lo, int hi) {
        // 随机分界点. random.nextInt(hi - lo + 1) 生成 [0, hi - lo + 1) 之间的数值（即[0, hi - lo])
        // random.nextInt(hi - lo + 1) + lo ==> 数值范围为 [lo, hi]
        int randomIndex = random.nextInt(hi - lo + 1) + lo;
        SortUtils.swap(data, lo, randomIndex);

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
        int[] data = SortUtils.generateRandomArray(1000000, 1, 10);
        SortUtils.compareSort(data, Arrays.asList(new MergeSort(), new QuickSortOptimize()));
    }

}
