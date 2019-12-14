package com.mrglint.algorithm.sort;

import java.util.Arrays;

/**
 * @author luhuancheng
 * @since 2019-11-30 10:19
 */
public class InsertSort implements SortFunction {

//    @Override
//    public void sort(int[] data) {
//        // i表示要插入的元素
//        for (int i = 1; i < data.length; i++) {
//            int insertValue = data[i];
//            int j;
//            // j表示第一个要比较的元素
//            for (j = i - 1; j >= 0; j--) {
//                if (insertValue < data[j]) {
//                    data[j + 1] = data[j];
//                } else {
//                    break;
//                }
//            }
//            // 此时分两种情况：
//            // 1. j < 0 说明前面没有元素可以比较了，data[0] = insertValue;
//            // 2. data[j] <= insertValue 说明此时的data[j]在正确的位置，data[j + 1] 就是要插入的位置
//            data[j + 1] = insertValue;
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
        int[] data = SortUtils.generateNearlyOrderArray(10000, 100);
        SortUtils.compareSort(data, Arrays.asList(new SelectSort(), new InsertSort()));
    }
}
