package com.wyh.ds.tree;

import com.wyh.ds.User;

/**
 * B + 树:
 * 	1.所有数据都在同一层，且在叶子结点上
 */
public class BAddTree {
	
	private Node[] root;
	
	//一个结点最多可以存放的数据数量（通俗的讲就是结点的宽度）
	private static final int MAX_DEGREE = 3;
	
	public void add(User user) {
		add(root, user);
	}
	
	public void add(Node[] node, User user) {
		if(root.length < MAX_DEGREE) {
//			node[node.length].user = user;
		} else {
//			balance();
		}
	}
	
	private static class Node {
//		private Node[] childs;
//		private User user;//叶子结点有
//		public Node(User user) {
//			this.user = user;
//		}
	}

}
