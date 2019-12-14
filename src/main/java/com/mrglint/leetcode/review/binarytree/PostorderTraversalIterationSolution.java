package com.mrglint.leetcode.review.binarytree;

import com.mrglint.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author luhuancheng
 * @since 2019-12-11 07:58
 */
public class PostorderTraversalIterationSolution {

    /**
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        TreeNode cur = root;
        TreeNode last = null;
        Stack<TreeNode> stack = new Stack<>();
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // 左子树到底了，看一下最后一个节点是否有右子树
            cur = stack.peek();
            // 栈顶元素的右子树为空，或者右子树被访问过了，则可以放入结果集中
            if (cur.right == null || cur.right == last) {
                res.add(cur.val);
                // 访问完子树根节点
                stack.pop();
                // 记录右节点被访问
                last = cur;
                // 不需要转向，继续谈栈
                cur = null;
            } else {
                cur = cur.right;
            }
        }
        return res;
    }
}
