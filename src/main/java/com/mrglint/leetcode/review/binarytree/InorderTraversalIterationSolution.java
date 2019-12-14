package com.mrglint.leetcode.review.binarytree;

import com.mrglint.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author luhuancheng
 * @since 2019-12-11 07:58
 */
public class InorderTraversalIterationSolution {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            // 左孩子入栈，当cur为空时，说明上一次cur指向的节点为叶子节点
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // 取出栈顶元素，开始右子树的遍历
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
}
