package com.mrglint.algorithm.sort;

import java.util.Random;

/**
 * 寻找数组中第N大元素
 * @author luhuancheng
 * @since 2019-12-01 15:10
 */
public class NLargestNumber {

    private Random random = new Random();

    /**
     * 寻找第n大元素，n从1开始计算
     * @param data
     * @param n
     * @return
     */
    public int findNlargest(int[] data, int n) {
        return findNlargest(data, 0, data.length - 1, n - 1);
    }

    private int findNlargest(int[] data, int lo, int hi, int n) {
        int randomIndex = random.nextInt(hi - lo + 1) + lo;
        SortUtils.swap(data, lo, randomIndex);
        int value = data[lo];

        // data[lo + 1, j] > value
        // data[j + 1, i) < value
        int j = lo;
        for (int i = lo + 1; i <= hi; i++) {
            if (data[i] > value) {
                SortUtils.swap(data, i, j + 1);
                j++;
            }
        }
        SortUtils.swap(data, lo, j);
        // 索引j代表第 j + 1 个元素
        if (j == n) {
            return data[j];
        } else if (j < n) {
            return findNlargest(data, j + 1, hi, n);
        } else {
            return findNlargest(data, lo, j - 1, n);
        }
    }

    public static void main(String[] args) {
        NLargestNumber nLargestNumber = new NLargestNumber();
        int[] data = new int[]{2, 3, 7, 1, 6}; // 1, 2, 3, 6, 7
        for (int i = 1; i <= 5; i++) {
            int nlargest = nLargestNumber.findNlargest(data, i);
            System.out.println(nlargest);
        }
    }
}
