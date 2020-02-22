package com.mrglint.structure.queue;

/**
 * @author luhuancheng
 * @since 2020-02-19 21:37
 */
public class LinkedListQueue<E> implements Queue<E> {

    private static class Node<E> {
        E e;
        Node<E> next;

        Node(E e) {
            this.e = e;
        }
    }

    private Node<E> head, tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void enqueue(E e) {
        if (tail == null) {
            tail = new Node<>(e);
            head = tail;
        } else {
            tail.next = new Node<>(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("queue is empty");
        }
        Node<E> retNode = head;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return retNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalStateException("queue is empty");
        }

        return head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: head ");
        Node<E> cur = head;
        while (cur != null) {
            res.append(cur.e);
            res.append(" -> ");
            cur = cur.next;
        }
        res.append(" null ");
        res.append("tail");
        return res.toString();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedListQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
        System.out.println(queue);
    }
}
