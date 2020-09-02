package com.wyh.ds.tree;

import java.util.Optional;

import com.wyh.ds.User;

/**
 * 二三树:
 * 	平衡：所有叶子结点层数相同
 * 	核心思想：分裂 + 重组
 *  思路：
 *  	1.构建二三四树：
 *  		区分结点类型 -> 比大小 -> 判断是否需放在子树上
 *  	2.分裂-重组
 *  		区分父结点类型 -> 区分当前结点与父结点关系
 */
public class TwoThreeTree {
	
	private Node root;//根结点
	
	//添加结点
	public void add(User user) {
		add(null, root, user);
	}
	
	public void add(Node parent, Node current, User user) {
		//根结点为空时
		if(root == null) {
			root = new Node(user);
			return;
		}
		
		//构建234树
		if(current.u1 == null) {//0结点
			current.u1 = user;
		} else if(current.u2 == null) {//2结点
			if(user.getId() < current.u1.getId()) {
				if(current.left != null) {
					add(current, current.left, user);
				} else {
					current.u2 = current.u1;
					current.u1 = user;
				}
			} else {
				if(current.right != null) {
					add(current, current.right, user);
				} else {
					current.u2 = user;
				}
			}
		} else if(current.u3 == null){//3结点
			if(user.getId() < current.u1.getId()) {//放左
				if(current.left != null) {
					add(current, current.left, user);
				} else {
					current.u3 = current.u2;
					current.u2 = current.u1;
					current.u1 = user;
				}
			} else if(user.getId() < current.u2.getId()) {//放中
				if(current.lCenter != null) {
					add(current, current.lCenter, user);
				} else {
					current.u3 = current.u2;
					current.u2 = user;
				}
			} else {//放右
				if(current.right != null) {
					add(current, current.right, user);
				} else {
					current.u3 = user;
				}
			}
		}
		
		//平衡为23树
		if(current.u3 != null) {
			split(parent, current);
		}
		
	}
	
	/**
	 * 分裂-重组
	 * 	分裂：分裂出两个左右子树
	 * 	重组：
	 * 		判断父结点类型：0结点、2结点、3结点
	 * 		判断当前结点类型：左子树、中子树、右子树
	 */
	public void split(Node parent, Node node) {
		//分裂
		Node left = new Node(node.u1);
		left.left = node.left;
		left.right = node.lCenter;
		
		Node right = new Node(node.u3);
		right.right = node.right;
		right.left = node.rCenter;
		
		//重组
		if(parent == null) {//父结点零结点-根结点
			node.left = left;
			node.lCenter = null;
			node.rCenter = null;
			node.right = right;
			node.u1 = node.u2;
			node.u2 = null;
			node.u3 = null;
		} else if(parent.u2 == null) {//父结点二结点
			if(node.u2.getId() < parent.u1.getId()) {//左子树
				parent.u2 = parent.u1;
				parent.u1 = node.u2;
				parent.left = left;
				parent.lCenter = right;
			} else {//右子树
				parent.u2 = node.u2;
				parent.lCenter = left;
				parent.right = right;
			}
		} else if(parent.u3 == null) {//父结点为三结点
			if(node.u2.getId() < parent.u1.getId()) {//左
				parent.u3 = parent.u2;
				parent.u2 = parent.u1;
				parent.u1 = node.u2;
				parent.left = left;
				parent.rCenter = parent.lCenter;
				parent.lCenter = right;
			} else if(node.u2.getId() < parent.u2.getId()) {//中
				parent.u3 = parent.u2;
				parent.u2 = node.u2;
				parent.lCenter = left;
				parent.rCenter = right;
			} else {//右
				parent.rCenter = left;
				parent.right = right;
				parent.u3 = node.u2;
			}
		}
	}
	
	public void foreach() {
		foreach(root, "");
	}
	
	public void foreach(Node current, String tab) {
		tab = tab + "\t";
		System.out.println(current);
		if(current.left != null) {
			System.out.print(tab + "left:");
			foreach(current.left, tab);
		}
		
		if(current.lCenter != null) {
			System.out.print(tab + "lCenter:");
			foreach(current.lCenter, tab);
		}
		
		if(current.rCenter != null) {
			System.out.print(tab + "rCenter:");
			foreach(current.rCenter, tab);
		}
		
		if(current.right != null) {
			System.out.print(tab + "right:");
			foreach(current.right, tab);
		}
	}
	
	/**
	 * 二结点结构：left u1 right
	 * 三结点结构：left u1 lCenter u2 right
	 * 
	 * 临时的四结点,需分裂：left u1 lCenter u2 rCenter u3 right
	 */
	private static class Node {
		
		private Node left;
		
		private Node lCenter;
		
		private Node rCenter;
		
		private Node right;
		
		private User u1;
		
		private User u2;
		
		private User u3;
		
		public Node(User user)  {
			this.u1 = user;
		}
		
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder("");
			Optional.ofNullable(u1).ifPresent((u) -> sb.append(u));
			Optional.ofNullable(u2).ifPresent((u) -> sb.append(u));
			Optional.ofNullable(u3).ifPresent((u) -> sb.append(u));
			return sb.toString();
		}
		
	}

}
