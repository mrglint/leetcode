package com.mrglint.leetcode.week02.solution78;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luhuancheng
 * @since 2019-10-28 07:46
 */
public class Solution {

    /**
     * 分治思想
     * 问题可以抽象为从nums中选取数字来填充nums.length个格子，每个格子可以选择对应索引的数字，也可以不选。
     * 再将索引抽象为递归的层数，当层数达到nums.length时，说明已经没得挑选了，将走过路径的子结果放入结果集中。
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subResult = new ArrayList<>();
        subsets(0, subResult, result, nums);
        return result;
    }

    private void subsets(int index, List<Integer> subResult, List<List<Integer>> result, int[] nums) {
        // terminator
        if (index == nums.length) {
            result.add(new ArrayList<>(subResult));
            return;
        }

        // split big problem
        // drill down
        // 不选择当前索引所在的元素
        subsets(index + 1, subResult, result, nums);

        // 选择当前索引所在的元素
        subResult.add(nums[index]);
        subsets(index + 1, subResult, result, nums);
        // merge result
        // restore state，当前层污染了上一层的结果集，此处需要清理
        subResult.remove(subResult.size() - 1);
    }
}
