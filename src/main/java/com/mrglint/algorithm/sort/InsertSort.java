package com.mrglint.algorithm.sort;

import java.util.Arrays;

/**
 * @author luhuancheng
 * @since 2019-11-30 10:19
 */
public class InsertSort implements SortFunction {

//    @Override
//    public void sort(int[] data) {
//        // 由于[0, 1)已经是有序的了，因此从第二个元素开始遍历
//        for (int i = 1; i < data.length; i++) {
//            for (int j = i; j > 0 && data[j - 1] > data[j]; j--) {
//                // data[j - 1] > data[j]
//                SortUtils.swap(data, j, j - 1);
//            }
//        }
//    }

    @Override
    public void sort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            // 要插入的位置
            int insertIndex;
            // 要插入的值
            int insertValue = data[i];
            // 当前一个元素大于要插入的值时，将前一个元素后移一个位置
            for (insertIndex = i; insertIndex > 0 && data[insertIndex - 1] > insertValue; insertIndex--) {
                data[insertIndex] = data[insertIndex - 1];
            }
            // 移动到第一个元素时、或者 data[insertIndex - 1] <= insertValue, 要插入的位置找到
            data[insertIndex] = insertValue;
        }
    }

    public static void main(String[] args) {
        int[] data = SortUtils.generateNearlyOrderArray(100000, 0);
        SortUtils.compareSort(data, Arrays.asList(new SelectSort(), new InsertSort()));
    }
}
