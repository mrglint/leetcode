package com.mrglint.leetcode.review.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luhuancheng
 * @since 2020-01-02 07:47
 */
public class PascalTriangleIISolution {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        res.add(1);
        // 第二层开始计算
        for (int i = 1; i <= rowIndex; i++) {
            // 第一个数固定为1，因此每行从第二个数开始计算
            // 此处使用一个列表存储, 从尾部开始计算；从头部开始计算，将影响到后面的值
            for (int j = i - 1; j > 0; j--) {
                res.set(j, res.get(j - 1) + res.get(j));
            }
            res.add(i, 1);
        }
        return res;
    }

    public List<Integer> getRow1(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        res.add(1);

        getRow1(1, rowIndex, res);
        return res;
    }

    private void getRow1(int level, int rowIndex, List<Integer> res) {
        if (level > rowIndex) {
            return;
        }
        for (int i = level - 1; i > 0; i--) {
            res.set(i, res.get(i - 1) + res.get(i));
        }
        res.add(level, 1);
        getRow1(level + 1, rowIndex, res);
    }

    public static void main(String[] args) {
        PascalTriangleIISolution solution = new PascalTriangleIISolution();
        List<Integer> res = solution.getRow1(3);
        System.out.println(res);
    }
}
