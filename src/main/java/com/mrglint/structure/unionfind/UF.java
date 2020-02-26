package com.mrglint.structure.unionfind;

/**
 * @author luhuancheng
 * @since 2020-02-23 11:27
 */
public interface UF {

    int getSize();

    boolean isConnected(int p, int q);

    void unionElements(int p, int q);
}
