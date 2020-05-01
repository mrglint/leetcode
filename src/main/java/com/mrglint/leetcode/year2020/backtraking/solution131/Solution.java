package com.mrglint.leetcode.year2020.backtraking.solution131;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luhuancheng
 * @since 2020-05-01 07:54
 */
public class Solution {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> subRes = new ArrayList<>();

        partition(s, res, subRes, 0);
        return res;
    }

    private void partition(String s, List<List<String>> res, List<String> subRes, int index) {
        if (index >= s.length() && subRes.size() > 0) {
            res.add(new ArrayList<>(subRes));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (validate(s, index, i)) {
                if (i == index) {
                    subRes.add(Character.toString(s.charAt(i)));
                } else {
                    subRes.add(s.substring(index, i + 1));
                }

                partition(s, res, subRes, i + 1);
                subRes.remove(subRes.size() - 1);
            }
        }
    }

    private boolean validate(String s, int index, int i) {
        if (index == i) {
            return true;
        }
        while (index < i) {
            if (s.charAt(index) != s.charAt(i)) {
                return false;
            }
            index++;
            i--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> list = solution.partition("aab");
        System.out.println(list);
    }
}
