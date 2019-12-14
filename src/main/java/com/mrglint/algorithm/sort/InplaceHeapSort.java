package com.mrglint.algorithm.sort;

import java.util.Arrays;

/**
 * 原地的堆排序
 *
 * @author luhuancheng
 * @since 2019-12-01 22:29
 */
public class InplaceHeapSort implements SortFunction {

    @Override
    public void sort(int[] data) {
        // 从第一个非叶子节点开始，逐步将数组堆化
        for (int i = (data.length - 1) / 2; i >= 0; i--) {
            shiftDown(data, data.length, i);
        }
        // 交换堆顶元素和最后一个未排序的元素的位置
        for (int i = data.length - 1; i > 0; i--) {
            SortUtils.swap(data, 0, i);
            shiftDown(data, i, 0);
        }
    }

    private void shiftDown(int[] data, int size, int index) {
        // 2 * index + 1 为index所在节点的左孩子
        // 如果 2 * index + 1 < size, 说明左孩子存在
        while (2 * index + 1 < size) {
            int j = 2 * index + 1;
            if (j + 1 < size && data[j] < data[j + 1]) {
                j++;
            }
            // 当父节点 >= 两个子节点，不进行操作
            if (data[index] >= data[j]) {
                break;
            }
            // 将index所在元素和j进行交换
            SortUtils.swap(data, index, j);
            index = j;
        }
    }

    public static void main(String[] args) {
        int[] data = SortUtils.generateRandomArray(1000000, 1, 1000000);
        SortUtils.compareSort(data, Arrays.asList(new InplaceHeapSort(), new HeapSort(), new HeapifySort()));
    }
}
