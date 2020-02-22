package com.mrglint.structure.queue;

/**
 * @author luhuancheng
 * @since 2020-02-18 08:45
 */
public interface Queue<E> {
    void enqueue(E e);

    E dequeue();

    E getFront();

    int getSize();

    boolean isEmpty();
}
