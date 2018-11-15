package com.podval;

import java.lang.reflect.Array;
import java.util.Iterator;

public class MyLinkedList<E> implements ILinkedList<E> {
    private Node<E> headNode = null;
    private int length = 0;
    private Class<E> myclass;

    public MyLinkedList(Class<E> myclass) {
        this.myclass = myclass;
    }

    public MyLinkedList(Class<E> myclass, Node<E> headNode) {
        this.headNode = headNode;
        this.myclass = myclass;
    }

    @Override
    public MyListIterator iterator(){
        return new MyListIterator(headNode);
    }

    public void add(E element){
        if(headNode == null){
            headNode = new Node<E>(element);
        }else{
            MyListIterator iter = iterator();
            Node<E> node = headNode;

            while(iter.hasNext()){
                node = iter.next();
            }

            Node<E> inserted = new Node<E>(element);
            node.setNextNode(inserted);
        }
        this.length++;
    }

    public void add(int index, E element){
        int i = 0;
        Node<E> currentNode = headNode;
        MyListIterator iter = iterator();

        if(headNode == null){
            throw new IndexOutOfBoundsException();
        }

        while(i != index){
            if(iter.hasNext()){
                currentNode = iter.next();
            }else{
                throw new IndexOutOfBoundsException();
            }
            i++;
        }

        Node<E> inserted = new Node<E>(element);
        if(currentNode.getNextNode() != null){
            inserted.setNextNode(currentNode.getNextNode());
        }

        currentNode.setNextNode(inserted);

        this.length++;
    }

    public void clear(){
        headNode = null;
        this.length = 0;
    }

    public int indexOf(E element){
        if(headNode == null){
            throw new IndexOutOfBoundsException();
        }

        int index = 0;
        Node<E> currentNode = headNode;
        MyListIterator iter = iterator();

        while(currentNode.getElement() != element){
            if(iter.hasNext()){
                currentNode = iter.next();
                index++;
            }else{
                return -1;
            }
        }

        return index;
    }

    private MyListIterator getNode(int index) {
        int i = 0;
        MyListIterator iter = iterator();
        Node<E> node = headNode;

        while(i != index){
            if(iter.hasNext()){
                node = iter.next();
                i++;
            }else{
                throw new IndexOutOfBoundsException();
            }
        }

        return iter;
    }

    public E get(int index){
        if(headNode == null || index < 0 || index > this.length - 1){
            throw new IndexOutOfBoundsException();
        }

        return (E)getNode(index).getCurrent().getElement();
    }

    public E remove(int index){
        if(headNode == null || index < 0 || index > this.length - 1){
            throw new IndexOutOfBoundsException();
        }

        MyListIterator iter = getNode(index);
        E removingElm = (E)iter.getCurrent().getElement();
        iter.remove();

        this.length--;

        return removingElm;
    }

    public E set(int index, E element){
        if(headNode == null || index < 0 || index > this.length){
            throw new IndexOutOfBoundsException();
        }

        E ret;
        if(index > 0 && index < this.length) {
            MyListIterator iter = getNode(index);
            iter.getCurrent().setElement(element);
            ret = (E)iter.getCurrent().getElement();
        }else if(index == this.length){
            add(element);
            ret = get(index);
        }else{
            throw new IndexOutOfBoundsException();
        }

        return ret;
    }

    public int size(){
        return this.length;
    }

    public E[] toArray(){
        E[] array = (E[])new Object[length];
    }

    public E[] newArray (Class<E[]> type, int size){

    }

    @Override
    public String toString(){}

}
