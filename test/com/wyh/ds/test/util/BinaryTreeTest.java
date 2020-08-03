package com.wyh.ds.test.util;

import com.wyh.ds.tree.BinaryTree;
import com.wyh.ds.tree.BinaryTree.Node;

/**
 * 测试二叉树
 * 			1
 * 		  -	  -
 * 		2		3
 *	  - 	  -	  -
 * 	4		5		6
 * 	
 *
 */
public class BinaryTreeTest {
	
	public static void main(String[] args) {
		Num root = new Num(1);
		
		BinaryTree<Num> tree = new BinaryTree<Num>(root);
		Node<Num> node2 = new Node<Num>(new Num(2));
		Node<Num> node3 = new Node<Num>(new Num(3));
		Node<Num> node4 = new Node<Num>(new Num(4));
		Node<Num> node5 = new Node<Num>(new Num(5));
	}
	
	static class Num{
		private int i;
		public Num(int i) {
			this.i = i;
		}
		public int getI() {
			return i;
		}

		public void setI(int i) {
			this.i = i;
		}
	}

}
