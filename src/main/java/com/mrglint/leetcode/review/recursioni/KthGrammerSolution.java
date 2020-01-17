package com.mrglint.leetcode.review.recursioni;

/**
 * @author luhuancheng
 * @since 2020-01-06 07:35
 */
public class KthGrammerSolution {
    /**
     * @param n 第 n 层，从1起始
     * @param k 第 k 个数，从1起始
     * @return
     */
    public int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        }

        if (k % 2 == 0) {
            return kthGrammar(n - 1, k / 2) == 0 ? 1 : 0;
        } else {
            return kthGrammar(n - 1, (k + 1) / 2) == 0 ? 0 : 1;
        }

    }

    public static void main(String[] args) {
        KthGrammerSolution solution = new KthGrammerSolution();
        int i = solution.kthGrammar(4, 5);
        System.out.println(i);
    }
}
