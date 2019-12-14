package com.mrglint.algorithm.sort;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 排序算法 辅助工具类
 *
 * @author luhuancheng
 * @since 2019-11-30 09:33
 */
public class SortUtils {

    /**
     * 生成size个元素的随机数组，数据范围[rangeLeft, rangeRight]
     *
     * @param size
     * @param rangeLeft
     * @param rangeRight
     * @return
     */
    static int[] generateRandomArray(int size, int rangeLeft, int rangeRight) {
        if (rangeLeft > rangeRight) {
            throw new IllegalArgumentException("rangeLeft必须小于等于rangeRight");
        }
        Random random = new Random();
        int[] res = new int[size];
        for (int i = 0; i < res.length; i++) {
            // random.nextInt(rangeRight - rangeLeft + 1) 生成数值范围 [0, rangeRight - rangeLeft + 1)
            res[i] = random.nextInt(rangeRight - rangeLeft + 1) + rangeLeft;
        }
        return res;
    }

    static int[] generateNearlyOrderArray(int size, int swapSize) {
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = i;
        }
        Random random = new Random();
        for (int i = 0; i < swapSize; i++) {
            // [0, size)
            int i1 = random.nextInt(size);
            int i2 = random.nextInt(size);
            int temp = res[i1];
            res[i1] = res[i2];
            res[i2] = temp;
        }
        return res;
    }

    static void compareSort(int[] data, List<SortFunction> sortFunctions) {
        for (SortFunction function : sortFunctions) {
            int[] copyData = new int[data.length];
            System.arraycopy(data, 0, copyData, 0, data.length);
            testSort(copyData, function);
        }
    }

    static void testSort(int[] data, SortFunction sortFunction) {
        long begin = System.currentTimeMillis();
        sortFunction.sort(data);
        long end = System.currentTimeMillis();
        checkSortResult(data);
        System.out.println(sortFunction.getClass().getSimpleName() + "sort " + data.length + " numbers, cost: " + (end - begin));
    }

    private static void checkSortResult(int[] data) {
        for (int i = 1; i < data.length; i++) {
            if (data[i] < data[i - 1]) {
                throw new IllegalStateException("排序结果不正确");
            }
        }
    }

    public static void insertSort(int[] data, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            int insertValue = data[i];
            int insertIndex;
            for (insertIndex = i; insertIndex > lo && data[insertIndex - 1] > insertValue; insertIndex--) {
                data[insertIndex] = data[insertIndex - 1];
            }
            data[insertIndex] = insertValue;
        }
    }

    public static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

}
