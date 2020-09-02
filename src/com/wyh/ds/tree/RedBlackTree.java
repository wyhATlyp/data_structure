package com.wyh.ds.tree;

import com.wyh.ds.User;

/**
 * 红黑树规定：
 * 	根结点为黑色
 * 	红色结点的子结点必须为黑色
 *  新增结点默认为红色
 * 	黑色结点自平衡（任意结点，到叶子结点(NIL)都包含相同都黑色结点数）
 * 
 * 核心思想：
 * 	每个分支上黑色节点数相同，红色结点不相邻(意味着红色结点不会严重失衡)
 * 
 * 实现方式：旋转+变色
 * 
 * 实现原理：新增结点默认为红色，父结点为红色时-不满足红色结点不相邻，需转换
 *  叔叔结点不存在时（不存在叔叔结点为黑色的情况）：将父结点变为黑色，祖父结点的两边黑色结点数失衡，所以需要旋转。
 *  	旋转：原结点颜色不变，新增的结点颜色不变，缓存的结点是new出来的(默认为红色)。旋转后不需要在变色了
 * 	叔叔结点为红色时：可以通过同时将父结点、叔叔结点修改为黑色。这样祖父结点两边就不会失衡了。最后将祖父结点改为红色。
 */
public class RedBlackTree {
	
	private static final String RED = "RED";
	private static final String BLACK = "BLACK";
	
	private Node root;
	
	public void add(User user) {
		add(root, user);
	}
	
	private void add(Node node, User user) {
		//正常放入
		Node newNode = new Node(user);
		
		//新结点作为根结点
		if(node == null) {
			root = newNode;
			root.color = BLACK;
			return;
		}
		
		//正常放入到树中，默认颜色为红色，然后递归修复
		if(user.getId() <= node.user.getId()) {
			if(node.left == null) {
				newNode.parent = node;
				node.left = newNode;
				fix(newNode);
			} else {
				add(node.left, user);
				fix(node.left);
			}
		} else {
			if(node.right == null) {
				newNode.parent = node;
				node.right = newNode;
				fix(newNode);
			} else {
				add(node.right, user);
				fix(node.right);
			}
		}
	}
	
	/**
	 * 传入一个结点，修复此结点使之达到红黑树要求
	 */
	private void fix(Node node) {
		if(node.parent != null && RED.equals(node.color) && RED.equals(node.parent.color)) {//当前结点和父结点都为红色时
			if(node.user.getId() < node.parent.user.getId()) {//结点为左结点
				if(node.parent.user.getId() < node.parent.parent.user.getId()) {//父结点为左孩子	---LL结构
					if(node.parent.parent.right != null && RED.equals(node.parent.parent.right.color)) {//叔叔存在并且为红色
						node.parent.color = BLACK;
						node.parent.parent.color = RED;
						node.parent.parent.right.color = BLACK;
					} else {
						rotateRight(node.parent.parent);
					}
				} else {//父结点为右孩子	---LR结构
					if(node.parent.parent.left != null && RED.equals(node.parent.parent.left.color)) {//叔叔存在并且为红色
						node.parent.color = BLACK;
						node.parent.parent.color = RED;
						node.parent.parent.left.color = BLACK;
					} else {
						rotateRight(node.parent);
						rotateLeft(node.parent.parent);
					}
				}
			} else {//结点为右结点
				if(node.parent.user.getId() < node.parent.parent.user.getId()) {//父结点为左孩子	---RL结构
					if(node.parent.parent.right != null && RED.equals(node.parent.parent.right.color)) {//叔叔存在并且为红色
						node.parent.color = BLACK;
						node.parent.parent.color = RED;
						node.parent.parent.right.color = BLACK;
					} else {
						rotateLeft(node.parent);
						rotateRight(node.parent.parent);
					}
				} else {//父结点为右孩子	--RR结构
					if(node.parent.parent.left != null && RED.equals(node.parent.parent.left.color)) {//叔叔存在并且为红色
						node.parent.color = BLACK;
						node.parent.parent.color = RED;
						node.parent.parent.left.color = BLACK;
					} else {
						rotateLeft(node.parent.parent);
					}
				}
			}
		}
		root.color = BLACK;
	}
	
	public void foreach() {
		foreach(root, "");
	}
	
	private void foreach(Node current, String tab) {
		tab = tab + "\t";
		System.out.println(current);
		if(current.left != null) {
			System.out.print(tab + "left:");
			foreach(current.left, tab);
		}
		
		if(current.right != null) {
			System.out.print(tab + "right:");
			foreach(current.right, tab);
		}
	}
	
	//左旋
	private void rotateLeft(Node node) {
		//0.缓存当前结点的值，后续使用
		Node temp = new Node(node.user);
		temp.left = node.left;
		temp.right = node.right.left;
		
		//1.修改结点数据
		node.user = node.right.user;
		
		//2.修改结点右子树：右右子树作为右子树
		node.right = node.right.right;
		
		//3.修改结点左子树：缓存值作为左子树
		node.left = temp;
		
		//4.修改父结点
		if(node.left != null)
			node.left.parent = node;
		if(node.right != null)
			node.right.parent = node;
	}
	
	//右旋
	private void rotateRight(Node node) {
		Node temp = new Node(node.user);
		temp.right = node.right;
		temp.left = node.left.right;
		
		node.user = node.left.user;
		node.left = node.left.left;
		node.right = temp;
		
		if(node.left != null)
			node.left.parent = node;
		if(node.right != null)
			node.right.parent = node;
	}
	
	class Node {
		
		private String color = RED;//新增结点默认为红色
		
		private Node parent;
		
		private Node left;
		
		private Node right;
		
		private User user;
		
		public Node(User user) {
			this.user = user;
		}
		
		@Override
		public String toString() {
			return user.toString() + color;
		}
		
	}

}
