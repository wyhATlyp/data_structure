package com.wyh.ds.test;

import com.wyh.ds.User;
import com.wyh.ds.tree.BinarraySortTree;

/**
 * 测试二排序树
 * 			1
 * 		  	  -
 * 				6
 *	  	  	  -
 * 			4
 *       -     -
 *     3          5
 *   -
 * 2
 */
public class BinarySortTreeTest {
	
	public static void main(String[] args) {
		BinarraySortTree tree = new BinarraySortTree();
		tree.add(new User(1, "张三", 18));
		tree.add(new User(6, "Smith", 20));
		tree.add(new User(4, "Tom", 11));
		tree.add(new User(3, "王五", 30));
		tree.add(new User(2, "李四", 20));
		tree.add(new User(5, "张三", 11));
		
		System.out.println("前序遍历：");
		tree.foreach();
		
		System.out.println(tree.getById(5));
	}

}
