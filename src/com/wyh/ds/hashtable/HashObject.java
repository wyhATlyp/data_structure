package com.wyh.ds.hashtable;

/**
 * 哈希表存储对象：数组 + 链表
 */
public class HashObject<T> {
	
	private int length;
	
	public static final int DEFAULT_LENGTH = 10;
	
	@SuppressWarnings("unchecked")
	public HashObject(int length) {
		this.length = length;
		array = new Node[this.length];
	}
	
	public HashObject() {
		this(DEFAULT_LENGTH);
	}
	
	private Node<T>[] array;

    public void add(T object) {
        int hash = object.hashCode();
        int index = hash % length;
        Node<T> newNode = new Node<T>(object);
        if(array[index] == null) {
        	array[index] = newNode;
        } else {
        	//获取最后一个节点
        	Node<T> current = array[index];
        	Node<T> last = current;
        	while(current.next != null) {
        		last = current.next;
        		current = current.next;
        	}
        	last.next = newNode;
        }
    }
    
    public void foreach() {
    	for(int i = 0; i < array.length; i ++) {
    		System.out.printf("链%d:%s\n", i, array[i].toString());
    	}
    }

	final static class Node<T> {

        private Node<T> next;

        private T object;
        
        public Node(T t) {
        	this.object = t;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public T getObject() {
            return object;
        }

        public void setObject(T object) {
            this.object = object;
        }

		@Override
		public String toString() {
			return object.toString() + "->" + next;
		}
        
    }

}
