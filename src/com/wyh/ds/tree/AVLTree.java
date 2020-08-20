package com.wyh.ds.tree;

import com.wyh.ds.User;

/**
 * AVL平衡二叉树
 */
public class AVLTree {
	
	private Node root;
	
	//树的高度
	public int height() {
		return height(root);
	}
	
	public int leftHeight() {
		return height(root.left);
	}
	
	public int rightHeight() {
		return height(root.right);
	}
	
	public int height(Node current) {
		if(current == null)
			return 0;
		return Math.max(height(current.left) + 1, height(current.right) + 1);
	}
	
	//添加元素
	public void add(User e) {
		add(root, e);
	}
	
	private void add(Node node, User user) {
		Node newNode = new Node(user);
		
		if(node == null) {
			root = newNode;
			return;
		}
		
		if(user.getId() <= node.item.getId()) {
			if(node.left == null) {
				node.left = newNode;
			} else {
				add(node.left, user);
			}
		} else {
			if(node.right == null) {
				node.right = newNode;
			} else {
				add(node.right, user);
			}
		}
		
		//AVL旋转
		if(height(node.right) - height(node.left) > 1) {//右子树比左子树高一级左旋
			System.out.println("=======================左旋=============================");
			System.out.println("添加元素：" + user);
			System.out.println("当前结点：" + node.item);
			System.out.println("左子树高度：" + height(node.left));
			System.out.println("右子树高度：" + height(node.right));
			System.out.println("右子树大于左子树，左旋！");
			if(height(node.right.left) > height(node.right.right)) {//右子树的左子树高度高于右子树的右子树时，先已右子树为轴右转变为右右结构
				System.out.println("先右旋，结果：");
				rotateRight(node.right);
				foreach();
			}
			rotateLeft(node);
			System.out.println("=======================左旋=============================");
		}
		
		if(height(node.left) - height(node.right) > 1) {//左子树比右子树高一级右旋
			System.out.println("=======================右旋=============================");
			System.out.println("添加元素：" + user);
			System.out.println("当前结点：" + node.item);
			System.out.println("左子树高度：" + height(node.left));
			System.out.println("右子树高度：" + height(node.right));
			System.out.println("左子树高于右子树，右旋！");
			
			if(height(node.left.right) > height(node.left.left)) {//左子树的右子树高于左子树的左子树时先以左子树为轴左转变成左左结构
				System.out.println("先左旋，结果：");
				rotateLeft(node.left);
				foreach();
			}
			rotateRight(node);
			
			System.out.println("=======================右旋=============================");
		}
		
	}
	
	//左旋
	public void rotateLeft(Node node) {
		//0.缓存当前结点的值，后续使用
		Node temp = new Node(node.item);
		if(node.left != null)
			temp.left = node.left;
		if(node.right.left != null)
			temp.right = node.right.left;
		
		//1.修改结点数据
		node.item = node.right.item;
		
		//2.修改结点右子树：右右子树作为右子树
		node.right = node.right.right;
		
		//3.修改结点左子树：缓存值作为左子树
		node.left = temp;
	}
	
	//右旋
	public void rotateRight(Node node) {
		Node temp = new Node(node.item);
		temp.right = node.right;
		temp.left = node.left.right;
		
		node.item = node.left.item;
		node.left = node.left.left;
		node.right = temp;
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
