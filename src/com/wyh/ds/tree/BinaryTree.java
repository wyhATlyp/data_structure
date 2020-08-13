package com.wyh.ds.tree;

import java.util.function.Consumer;

/**
 * 二叉树
 */
public class BinaryTree<T> {

    private Node<T> root;
    
    public BinaryTree(Node<T> root) {
    	this.root = root;
    }

    public void addLeft(Node<T> node, Node<T> obj) {
    	if(node.left != null)
			throw new RuntimeException("左子树已存在");
    	node.left = obj;
    }
    
    public void addRight(Node<T> node, Node<T> obj) {
    	if(node.right != null)
    		throw new RuntimeException("右子树已存在");
    	node.right = obj;
    }

	/**
	 * 前序根据ID查找
	 */

	/**
	 * 前序遍历：父 -> 子
	 */
	public void frontForeach(Consumer<T> consumer, Node<T> current) {
		if(current == null)
			return;
		consumer.accept(current.obj);
		if(current.left != null)
			frontForeach(consumer, current.left);
		if(current.right != null)
			frontForeach(consumer, current.right);
	}

	/**
	 * 中序遍历：左 -> 父 -> 右
	 */
	public void infixForeach(Consumer<T> consumer, Node<T> current) {
		if(current == null)
			return;
		if(current.left != null)
			infixForeach(consumer, current.left);
		consumer.accept(current.obj);
		if(current.right != null)
			infixForeach(consumer, current.right);
	}

	/**
	 * 后序遍历：子 -> 父
	 */
	public void backForeach(Consumer<T> consumer, Node<T> current) {
		if(current == null)
			return;
		if(current.left != null) {
			backForeach(consumer, current.left);
		}
		if(current.right != null) {
			backForeach(consumer, current.right);
		}
		consumer.accept(current.obj);
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
