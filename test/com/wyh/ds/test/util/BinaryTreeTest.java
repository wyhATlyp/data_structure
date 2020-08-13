package com.wyh.ds.test.util;

import com.wyh.ds.User;
import com.wyh.ds.tree.BinaryTree;
import com.wyh.ds.tree.BinaryTree.Node;

/**
 * 测试二叉树
 * 			1
 * 		  -	  -
 * 		2		3
 *	  - 	  -	  -
 * 	4		5		6
 */
public class BinaryTreeTest {
	
	public static void main(String[] args) {
		User user1 = new User(1, "张三", 18);
		User user2 = new User(2, "李四", 20);
		User user3 = new User(3, "王五", 30);
		User user4 = new User(4, "Tom", 11);
		User user5 = new User(5, "张三", 11);
		User user6 = new User(6, "Smith", 20);


		Node root = new Node(user1);
		
		BinaryTree<User> tree = new BinaryTree<User>(root);

		Node<User> node2 = new Node<User>(user2);
		Node<User> node3 = new Node<User>(user3);
		Node<User> node4 = new Node<User>(user4);
		Node<User> node5 = new Node<User>(user5);
		Node<User> node6 = new Node<User>(user6);

		tree.addLeft(root, node2);
		tree.addRight(root, node3);

		tree.addLeft(node2, node4);
		tree.addLeft(node3, node5);
		tree.addRight(node3, node6);

		System.out.println("前序遍历：");
		tree.frontForeach((user) -> {
			System.out.println(user);
		}, root);

		System.out.println("中序遍历：");
		tree.infixForeach((user) ->  {
			System.out.println(user);
		}, root);

		System.out.println("后序遍历：");
		tree.backForeach((user) -> {
			System.out.println(user);
		}, root);
	}

}
