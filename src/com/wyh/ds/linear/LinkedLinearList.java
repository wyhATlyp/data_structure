package com.wyh.ds.linear;

/**
 * 带头单向链表
 * @author mac008
 *
 * @param <E>
 */
public class LinkedLinearList<E> implements LinearList<E> {

    private Node<E> head;

    private int size;

    public LinkedLinearList() {
        init();
    }

    @Override
    public LinearList<E> init() {
        return this;
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public E get(int i) {
    	return node(i).item;
    }
    
    private void check(int index) {
    	if(index > size)
    		throw new IndexOutOfBoundsException("数组越界:size = " + size + ", index = " + index);
    }

    private Node<E> node(int index) {
    	check(index);
        Node<E> node = head;
        for(int j = 0; j < index; j ++)
            node = node.next;
        return node;
    }

    @Override
    public int locate(E e) {
        for(int i = 0; i < size; i ++) {
            if(get(i) == e)
                return i;
        }
        return -1;
    }

    @Override
    public void insert(int i, E e) {
        Node<E> oldNode = node(i - 1);
        if(oldNode == null) {
        	head = new Node<E>(e);
        	size ++;
        	return;
        }
        Node<E> nextNode = oldNode.next;
        Node<E> newNode = new Node<E>(e);
        if(nextNode != null) {
            newNode.next = nextNode;
            nextNode.prev = newNode;
        }
        newNode.prev = oldNode;
        oldNode.next = newNode;
        size ++;
    }
  
    @Override
    public void delete(int i) {
        Node<E> oldNode = node(i);
        Node<E> prev = oldNode.prev;
        Node<E> next = oldNode.next;
        if(prev != null)
            prev.next = next;
        if(next != null)
            next.prev = prev;
        size --;
    }
    
    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	Node<E> node = head;
    	while(node != null) {
    		sb.append("->").append(node.item);
    		node = node.next;
    	}
    	return sb.toString();
    }

    private static class Node<E> {

        private E item;

        private Node<E> next;

        private Node<E> prev;

        public Node(E item) {
            this.item = item;
        }

    }

}
