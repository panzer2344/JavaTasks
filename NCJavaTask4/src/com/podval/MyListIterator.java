package com.podval;

import java.util.Iterator;
import com.podval.Node;

//public class MyListIterator<E> implements Iterator<E> {
//    private Node<E> currentNode;
//    private Node<E> headNode;
//
//    public MyListIterator() {
//        this.headNode = headNode;
//        this.currentNode = this.headNode;
//    }
//
//    @Override
//    public E next() {
//        if(hasNext()){
//            currentNode = currentNode.getNextNode();
//            return currentNode.getElement();
//        }
//        else{
//            return null;
//        }
//    }
//
//    @Override
//    public boolean hasNext() {
//        return currentNode.getNextNode() != null;
//    }
//
//    @Override
//    public void remove() {
//        if(currentNode != null){
//            Node tmp = headNode;
//            while (tmp.getNextNode() != currentNode) {
//                tmp = tmp.getNextNode();
//            }
//
//            if (hasNext()) {
//                tmp.setNextNode(currentNode.getNextNode());
//            } else {
//                tmp.setNextNode(null);
//            }
//        }
//    }
//
//    public Node getCurrent(){
//        return currentNode;
//    }
//}
