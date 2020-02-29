package com.mrglint.algorithm.sort;

/**
 * 从索引0开始遍历数组，遍历的每一轮循环开始前，「选定」索引为最小值位置；
 * 之后在该层循环内，另起一层循环，从索引+1开始遍历数组，每次循环都跟外层循环「选定」的最小值做比较，最终确定最小值位置；
 * 在外层循环中，交换最终的最小值位置到「选定」的最小值索引位置
 *
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
