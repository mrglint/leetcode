package com.mrglint.structure.unionfind;

/**
 * Quick Find 1.0
 *
 * @author luhuancheng
 * @since 2020-02-23 11:31
 */
public class UnionFindQuickFindV1 implements UF {

    private int[] id;

    public UnionFindQuickFindV1(int capacity) {
        id = new int[capacity];
        // 初始状态下，所有节点不相连
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if (pId == qId) {
            return;
        }

        // O(n)
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId) {
                id[i] = qId;
            }
        }
    }

    private int find(int i) {
        return id[i];
    }
}
