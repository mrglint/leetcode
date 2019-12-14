package com.mrglint.algorithm.sort;

import com.mrglint.algorithm.heap.MaxHeap;

/**
 * 缺点：O(n)空间复杂度
 * @author luhuancheng
 * @since 2019-12-01 21:33
 */
public class HeapifySort implements SortFunction {
    @Override
    public void sort(int[] data) {
        MaxHeap maxHeap = new MaxHeap(data);
        for (int i = data.length - 1; i >= 0; i--) {
            data[i] = maxHeap.extractMax();
        }
    }

    public static void main(String[] args) {
        int[] data = SortUtils.generateRandomArray(10, 1, 10);
        SortUtils.testSort(data, new HeapifySort());
    }
}
