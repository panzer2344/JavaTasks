package com.podval;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.LinkedList;

public class MyLinkedList<E> implements ILinkedList<E> {
    private Node<E> headNode = null;
    private int length = 0;

    /*public MyLinkedList(Class<E> myclass) {
        this.myclass = myclass;
    }

    public MyLinkedList(Class<E> myclass, Node<E> headNode) {
        this.headNode = headNode;
        this.myclass = myclass;
    }*/

    public MyLinkedList(Node<E> headNode) {
        this.headNode = headNode;
    }

    @Override
    public Iterator iterator(){
        return new Iterator<E>() {
            private Node<E> currentNode = MyLinkedList.this.headNode;

            @Override
            public E next() {
                E value = currentNode.getElement();
                if(hasNext()){
                    currentNode = currentNode.getNextNode();
                }
                else{
                    return null;
                }

                return value;
            }

            @Override
            public boolean hasNext() {
                return currentNode != null; // strange but fact) It works fine in forech
            }

            @Override
            public void remove() {
                if(currentNode != null){
                    Node tmp = headNode;
                    while (tmp.getNextNode() != currentNode) {
                        tmp = tmp.getNextNode();
                    }

                    if (hasNext()) {
                        tmp.setNextNode(currentNode.getNextNode());
                    } else {
                        tmp.setNextNode(null);
                    }
                }
            }
        };
    }

    public void add(E element){
        if(headNode == null){
            headNode = new Node<E>(element);
        }else{
            Node<E> node = headNode;

            while(node.getNextNode() != null){
                node = node.getNextNode();
            }

            Node<E> inserted = new Node<E>(element);
            node.setNextNode(inserted);
        }
        this.length++;
    }

    public void add(int index, E element){
        int i = 0;
        Node<E> currentNode = headNode;


        if(headNode == null){
            throw new IndexOutOfBoundsException();
        }

        while(i < index){
            if(currentNode.getNextNode() != null){
                currentNode = currentNode.getNextNode();
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

        while(currentNode.getElement() != element){
            if(currentNode.getNextNode() != null){
                currentNode = currentNode.getNextNode();
                index++;
            }else{
                return -1;
            }
        }

        return index;
    }

    private Node<E> getNode(int index) {
        int i = 0;
        Node<E> node = headNode;

        while(i != index){
            if(node.getNextNode() != null){
                node = node.getNextNode();
                i++;
            }else{
                throw new IndexOutOfBoundsException();
            }
        }

        return node;
    }

    public E get(int index){
        if(headNode == null || index < 0 || index > this.length - 1){
            throw new IndexOutOfBoundsException();
        }

        return (E)getNode(index).getElement();
    }

    public E remove(int index){
        if(headNode == null || index < 0 || index > this.length - 1){
            throw new IndexOutOfBoundsException();
        }

        E removingElm = null;

        if(index == 0){
            removingElm = headNode.getElement();
            headNode = headNode.getNextNode();
        }else {
            Node<E> nodePrev = getNode(index - 1);
            removingElm = (E)nodePrev.getNextNode().getElement();

            nodePrev.setNextNode(nodePrev.getNextNode().getNextNode());
        }

        this.length--;

        return removingElm;
    }

    public E set(int index, E element){
        if(headNode == null || index < 0 || index > this.length){
            throw new IndexOutOfBoundsException();
        }

        E ret;
        if(index > 0 && index < this.length) {
            Node<E> node = getNode(index);
            node.setElement(element);
            ret = (E)node.getElement();
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
        if(headNode == null) {
            return null;
        }

        E[] array = (E[])Array.newInstance(headNode.getElement().getClass(), length);
        Node<E> currentNode = headNode;

        for(int i = 0; i < length; i++){
            array[i] = (E) currentNode.getElement();
            if(currentNode.getNextNode() != null){
                currentNode = currentNode.getNextNode();
            }
        }

        return array;
    }

    @Override
    public String toString(){
        String str = "";
        Node<E> currentNode = headNode;

        str = "List = { ";

        while(currentNode.getNextNode() != null){
            str += currentNode.getElement();
            if(currentNode.getNextNode() != null){
                str += ", ";
            }
            currentNode = currentNode.getNextNode();
        }

        str += currentNode.getElement() + " }";

        return str;
    }

}
