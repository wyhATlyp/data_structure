package com.wyh.ds.tree;

import java.util.function.Consumer;

/**
 * 二叉树
 */
public class BinaryTree<T> {

    private Node<T> root;
    
    public BinaryTree(T root) {
    	this.root = new Node<T>(root);
    }

    public void addLeft(Node<T> node, T obj) {
    	if(node.left != null)
			throw new RuntimeException("左子树已存在");
    	node.left = new Node<T>(obj);
    }
    
    public void addRight(Node<T> node, T obj) {
    	if(node.right != null)
    		throw new RuntimeException("右子树已存在");
    	node.right = new Node<T>(obj);
    }
    
    /**
     * 后序遍历
     */
    public void backForeach(Consumer<T> consumer) {
    	Node<T> current = root; 
    	if(current.left != null) {
    		current = current.left;
    		backForeach(consumer);
    	}
    	if(current.right != null) {
    		current = current.right;
    		backForeach(consumer);
    	}
    	consumer.accept(this.root.obj);
    }

    public static class Node<T> {

        private T obj;

        private Node<T> left;

        private Node<T> right;

        public Node (T obj) {
        	this.obj = obj;
        }

		public T getObj() {
			return obj;
		}

		public void setObj(T obj) {
			this.obj = obj;
		}

		public Node<T> getLeft() {
			return left;
		}

		public void setLeft(Node<T> left) {
			this.left = left;
		}

		public Node<T> getRight() {
			return right;
		}

		public void setRight(Node<T> right) {
			this.right = right;
		}
        
    }

}
