package com.mrglint.algorithm.sort;

/**
 * @author luhuancheng
 * @since 2019-11-29 22:46
 */
public class SelectSort implements SortFunction {

    @Override
    public void sort(int[] data) {

        for (int i = 0; i < data.length; i++) {
            // 寻找[i, data.length)中的最小值索引位置；初始化为i
            int minIndex = i;
            // 从[i + 1, data.length)中寻找最小值索引位置
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = data[i];
            data[i] = data[minIndex];
            data[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        // 1w : 51ms
        // 10w : 4541ms
        // O(n ^ 2)
        int[] data = SortUtils.generateRandomArray(100000, 1, 100000);
        SortUtils.testSort(data, new SelectSort());
    }
}
