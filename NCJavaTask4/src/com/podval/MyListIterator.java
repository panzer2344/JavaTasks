package com.podval;

import java.util.Iterator;

public class MyListIterator implements Iterator<Node> {
    private Node currentNode;
    private Node headNode;

    public MyListIterator(Node headNode) {
        this.headNode = headNode;
        this.currentNode = this.headNode;
    }

    @Override
    public Node next() {
        if(hasNext()){
            currentNode = currentNode.getNextNode();
            return currentNode;
        }
        else{
            return null;
        }
    }

    @Override
    public boolean hasNext() {
        return currentNode.getNextNode() != null;
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

    public Node getCurrent(){
        return currentNode;
    }
}
