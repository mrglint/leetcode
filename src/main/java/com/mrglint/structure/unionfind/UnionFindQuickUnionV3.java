package com.mrglint.structure.unionfind;

/**
 * Quick Union 1.3
 * 基于size的优化，即节点树。更好的优化是基于树的高度来优化
 *
 * @author luhuancheng
 * @since 2020-02-23 11:31
 */
public class UnionFindQuickUnionV3 implements UF {

    private int[] parent;
    private int[] size;

    public UnionFindQuickUnionV3(int capacity) {
        parent = new int[capacity];
        size = new int[capacity];
        // 初始状态下，所有节点不相连
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    /**
     * O(h)
     * @param p
     * @param q
     * @return
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * O(h)
     * @param p
     * @param q
     */
    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }
        // 此处 size 维护存在问题。
        if (size[pRoot] < size[qRoot]) {
            parent[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        } else {
            parent[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }
    }

    private int find(int p) {
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }
}
