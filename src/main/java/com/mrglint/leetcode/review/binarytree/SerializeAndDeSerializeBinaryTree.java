package com.mrglint.leetcode.review.binarytree;

import com.mrglint.leetcode.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @author luhuancheng
 * @since 2019-12-15 21:17
 */
public class SerializeAndDeSerializeBinaryTree {
    public String serialize(TreeNode root) {
        return serialize(root, "");
    }

    private String serialize(TreeNode root, String s) {
        if (root == null) {
            s += "null,";
        } else {
            s += root.val + ",";
            s = serialize(root.left, s);
            s = serialize(root.right, s);
        }
        return s;
    }

    public TreeNode deserialize(String data) {
        String[] strings = data.split(",");
        List<String> dataList = new LinkedList<>(Arrays.asList(strings));
        return deserialize(dataList);
    }

    private TreeNode deserialize(List<String> dataList) {
        if (Objects.equals(dataList.get(0), "null")) {
            dataList.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(dataList.get(0)));
        dataList.remove(0);
        root.left = deserialize(dataList);
        root.right = deserialize(dataList);

        return root;
    }
}
