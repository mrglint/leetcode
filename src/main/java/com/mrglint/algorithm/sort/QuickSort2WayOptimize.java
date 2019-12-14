package com.mrglint.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 优化版本
 * 优化点：
 * 1. 采用双路快排的思路，避免存在大量重复元素时退化为O(n ^ 2)
 *
 * @author luhuancheng
 * @since 2019-11-30 22:25
 */
public class QuickSort2WayOptimize implements SortFunction {

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

        // 双路快排
        // data[lo + 1, i) <= value; data(j, hi] >= value
        int i = lo + 1, j = hi;
        while (true) {
            while (i <= hi && data[i] < value) {
                i++;
            }
            while (j >= lo + 1 && data[j] > value) {
                j--;
            }
            if (i >= j) {
                break;
            }
            SortUtils.swap(data, i, j);
            i++;
            j--;
        }
        SortUtils.swap(data, lo, j);
        return j;
    }

    public static void main(String[] args) {
        int[] data = SortUtils.generateRandomArray(1000000, 1, 10);
        SortUtils.compareSort(data, Arrays.asList(new MergeSort(), new QuickSort2WayOptimize()));
    }

}
