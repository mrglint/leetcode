package com.mrglint.structure.segmenttree;

/**
 * @author luhuancheng
 * @since 2020-02-22 18:40
 */
public interface Merger<E> {

    E merge(E a, E b);
}
