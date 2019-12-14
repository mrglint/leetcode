package com.mrglint.algorithm.sort;

import java.util.Arrays;

/**
 * @author luhuancheng
 * @since 2019-11-30 11:57
 */
public class BubbleSort implements SortFunction {

//    @Override
//    public void sort(int[] data) {
//        for (int i = 0; i < data.length; i++) {
//            for (int j = 0; j < data.length - i - 1; j++) {
//                if (data[j] > data[j + 1]) {
//                    swap(data, j, j + 1);
//                }
//            }
//        }
//    }


    /**
     * 优化1，如果没有发生交换，说明所有数据都是有序状态，提前终止外层循环
     * @param data
     */
//    @Override
//    public void sort(int[] data) {
//        for (int i = 0; i < data.length; i++) {
//            boolean flag = false;
//            for (int j = 0; j < data.length - i - 1; j++) {
//                if (data[j] > data[j + 1]) {
//                    swap(data, j, j + 1);
//                    flag = true;
//                }
//            }
//            if (!flag) {
//                break;
//            }
//        }
//    }

    /**
     * 优化2，每次记录最后一次交换的位置，可以让内层循环提前结束
     * @param data
     */
    @Override
    public void sort(int[] data) {
        int lastExchange = 0;
        int k = data.length - 1;
        for (int i = 0; i < data.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < k; j++) {
                if (data[j] > data[j + 1]) {
                    SortUtils.swap(data, j, j + 1);
                    flag = true;
                    lastExchange = j;
                }
            }
            k = lastExchange;
            if (!flag) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] data = SortUtils.generateRandomArray(10, 1, 10);
        System.out.println(Arrays.toString(data));
        SortUtils.testSort(data, new BubbleSort());
    }
}
