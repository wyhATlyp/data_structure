package com.wyh.ds.tree;

import com.wyh.ds.User;

/**
 * 二叉排序树:左 < 父 <= 右
 */
public class BinarraySortTree {
	
	private Node root;
	
	//添加元素
	public void add(User e) {
		add(root, e);
	}
	
	private void add(Node current, User user) {
		if(root == null) {
			root = new Node(user);
			return;
		}
		
		if(user.getId() < current.item.getId()) {
			if(current.left == null) {
				Node node = new Node(user);
				current.left = node;
			} else {
				add(current.left, user);
			}
		} else {
			if(current.right == null) {
				Node node = new Node(user);
				current.right = node;
			} else {
				add(current.right, user);
			}
		}
	}
	
	//遍历元素
	public void foreach() {
		foreach(root);
	}
	
	/**
	 * 前序遍历
	 * @param current
	 */
	private void foreach(Node current) {
		System.out.println(current.item);
		if(current.left != null) {
			System.out.print(current.item.getId() + "left:");
			foreach(current.left);
		}
		if(current.right != null) {
			System.out.print(current.item.getId() + "right:");
			foreach(current.right);
		}
	}
	
	//通过id查找元素
	private int count;
	
	public User getById(int id) {
		if(root == null)
			return null;
		return getById(root, id);
	}
	
	private User getById(Node current, int id) {
		count ++;
		
		if(current == null) {
			System.out.printf("没有找到元素,遍历了%d次", count);
			return null;
		}
		
		if(current.item.getId() == id) {
			System.out.printf("遍历了%d次", count);
			return current.item;
		}
		
		if(id < current.item.getId()) {
			//向左查找
			return getById(current.left, id);
		} else {
			//向右查找
			return getById(current.right, id);
		}
	}
	
	private static class Node {
		
		User item;
		
		Node left;
		
		Node right;
		
		public Node(User item) {
			this.item = item;
		}
		
	}

}
