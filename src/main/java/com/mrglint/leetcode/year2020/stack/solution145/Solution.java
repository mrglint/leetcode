package com.mrglint.leetcode.year2020.stack.solution145;

import com.mrglint.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author luhuancheng
 * @since 2020-03-31 21:52
 */
public class Solution {

    /**
     * 一个节点可以直接访问的条件：
     * 1. 该节点没有左右孩子
     * 2. 该节点的左、右子树都已经访问过
     *
     * 因此遍历时，我们使用一个变量来保存访问过的节点
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode prev = null;
        TreeNode cur;
        while (!stack.isEmpty()) {
            cur = stack.peek();
            boolean leafNode = (cur.left == null && cur.right == null);
            boolean childVisited = (prev != null && (cur.left == prev || cur.right == prev));
            if (leafNode || childVisited) {
                stack.pop();
                prev = cur;
                res.add(cur.val);
            } else {
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }
        }

        return res;
    }

}
