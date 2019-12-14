package com.mrglint.algorithm.sort;

/**
 * 自顶向上 归并排序
 * @author luhuancheng
 * @since 2019-11-30 15:53
 */
public class BottomUpMergeSort implements SortFunction {

    @Override
    public void sort(int[] data) {
        for (int size = 1; size < data.length; size += size) {
            for (int i = 0; i + size < data.length; i += size + size) {
                merge(data, i, i + size - 1, Math.min(i + size + size - 1, data.length - 1));
            }
        }
    }

    private void merge(int[] data, int lo, int mid, int hi) {
        // 要归并的数据移动到temp
        int[] temp = new int[hi - lo + 1];
        for (int i = lo; i <= hi; i++) {
            temp[i - lo] = data[i];
        }

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                data[k] = temp[j - lo];
                j++;
            } else if (j > hi) {
                data[k] = temp[i - lo];
            } else if (temp[i - lo] < temp[j - lo]) {
                data[k] = temp[i - lo];
                i++;
            } else {
                data[k] = temp[j - lo];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] data = SortUtils.generateRandomArray(100, 1, 100);
        SortUtils.testSort(data, new BottomUpMergeSort());
    }
}
