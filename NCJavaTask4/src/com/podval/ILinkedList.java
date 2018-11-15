package com.podval;

public interface ILinkedList<E> extends Iterable<Node> {

    void add(E element);
    void add(int index, E element);

    void clear();

    int indexOf(E element);

    E get(int index);
    E remove(int index);
    E set(int index, E element);

    int size();

    E[] toArray();

    @Override
    String toString();
}
