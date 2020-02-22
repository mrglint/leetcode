package com.mrglint.structure.linklist;

/**
 * @author luhuancheng
 * @since 2020-02-18 22:23
 */
public class LinkedList<E> {

    private static class Node<E> {
        E e;
        Node<E> next;

        Node(E e, Node<E> next) {
            this.e = e;
            this.next = next;
        }

        Node(E e) {
            this.e = e;
        }
    }

    private Node<E> dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node<>(null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalStateException("must be 0 <= index <= size");
        }

        Node<E> prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node<>(e, prev.next);
        size++;
    }

    public void addLast(E e) {
        add(size, e);
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("must be 0 < index < size");
        }

        Node<E> cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("must be 0 < index < size");
        }
        Node<E> cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    public boolean contains(E e) {
        Node<E> cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("must be 0 < index < size");
        }
        Node<E> prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node<E> retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;
        return retNode.e;
    }

    /**
     * 删除链表中所有节点值与e相等的节点
     * @param e
     */
    public void removeElement(E e) {
        Node<E> prev = dummyHead;
        while (prev != null) {
            if (prev.next != null && prev.next.e.equals(e)) {
                Node<E> delNode = prev.next;
                prev.next = prev.next.next;
                delNode.next = null;
                size--;
            }
            prev = prev.next;
        }
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("LinkedList: ");
        Node<E> cur = dummyHead.next;
        while (cur != null) {
            res.append(cur.e);
            res.append(" -> ");
            cur = cur.next;
        }
        res.append(" null ");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            list.addFirst(i);
            System.out.println(list);
        }
        list.remove(2);
        System.out.println(list);
        list.removeFirst();
        System.out.println(list);
        list.removeLast();
        System.out.println(list);
        list.add(2, 100);
        list.addFirst(100);
        System.out.println(list);
        list.removeElement(100);

        System.out.println(list);
        System.out.println(list.getSize());
    }
}
