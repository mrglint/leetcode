package com.mrglint.structure.segmenttree;

/**
 * https://leetcode-cn.com/problems/range-sum-query-immutable/
 * https://leetcode-cn.com/problems/range-sum-query-mutable/
 * @author luhuancheng
 * @since 2020-02-22 17:25
 */
public class SegmentTree<E> {

    private E[] data;
    private E[] tree;
    private Merger<E> merger;

    public SegmentTree(E[] array, Merger<E> merger) {
        this.merger = merger;
        this.data = (E[]) new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            data[i] = array[i];
        }

        // 存储线段树节点
        this.tree = (E[]) new Object[4 * data.length];
        buildSegmentTree(0, 0, data.length - 1);
    }

    private int getSize() {
        return data.length;
    }

    public E get(int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("out of bounded");
        }
        return data[index];
    }

    public void set(int index, E e) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("out of bounded");
        }
        data[index] = e;
        set(0, 0, data.length - 1, index, e);
    }

    private void set(int treeIndex, int l, int r, int index, E e) {
        if (l == r) {
            tree[treeIndex] = e;
            return;
        }

        int mid = l + (r - l) / 2;
        int leftIndex = leftChild(treeIndex);
        int rightIndex = rightChild(treeIndex);
        if (index >= mid + 1) {
            set(rightIndex, mid + 1, r, index, e);
        } else {
            set(leftIndex, l, mid, index, e);
        }

        tree[treeIndex] = merger.merge(tree[leftIndex], tree[rightIndex]);
    }

    public E query(int queryL, int queryR) {
        if (queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length || queryL > queryR) {
            throw new IllegalArgumentException("out of bounded");
        }

        return query(0, 0, data.length - 1, queryL, queryR);
    }

    private E query(int treeIndex, int l, int r, int queryL, int queryR) {
        if (l == queryL && r == queryR) {
            return tree[treeIndex];
        }

        // 左子节点索引
        int leftIndex = leftChild(treeIndex);
        // 右子节点索引
        int rightIndex = rightChild(treeIndex);

        int mid = l + (r - l) / 2;
        if (queryL >= mid + 1) {
            // 结果在右子树中
            return query(rightIndex, mid + 1, r, queryL, queryR);
        } else if (queryR <= mid) {
            // 结果在左子树中
            return query(leftIndex, l, mid, queryL, queryR);
        }

        // 左右子树各有一部分结果
        E leftResult = query(leftIndex, l, mid, queryL, mid);
        E rightResult = query(rightIndex, mid + 1, r, mid + 1, queryR);
        return merger.merge(leftResult, rightResult);
    }

    private void buildSegmentTree(int treeIndex, int l, int r) {
        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }

        int leftIndex = leftChild(treeIndex);
        int rightIndex = rightChild(treeIndex);

        int mid = l + (r - l) / 2;
        buildSegmentTree(leftIndex, l, mid);
        buildSegmentTree(rightIndex, mid + 1, r);

        tree[treeIndex] = merger.merge(tree[leftIndex], tree[rightIndex]);
    }

    private int rightChild(int treeIndex) {
        return 2 * treeIndex + 2;
    }

    private int leftChild(int treeIndex) {
        return 2 * treeIndex + 1;
    }
}
