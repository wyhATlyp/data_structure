package com.wyh.ds.test;

import com.wyh.ds.User;
import com.wyh.ds.tree.AVLTree;

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
public class AVLTreeTest {
	
	public static void main(String[] args) {
		RR();
		LL();
		LR();
	}
	
	/**
	 * 右右：发生左旋
	 * 		4
	 * 	(3		6)
	 * 		(5		7)
	 * 					8
	 * 
	 * result:
	 * 			6
	 * 		(4		7)
	 * 	(3		5)		8
	 */
	public static void RR() {
		AVLTree tree = new AVLTree();
		tree.add(new User(4, "张三", 18));
		tree.add(new User(3, "Smith", 20));
		tree.add(new User(6, "Tom", 11));
		tree.add(new User(5, "张三", 18));
		tree.add(new User(7, "Smith", 20));
		tree.add(new User(8, "Smith", 20));
		
		System.out.println("前序遍历：");
		tree.foreach();
		
		System.out.println("AVL结果：");
		System.out.println("树的高度：" + tree.height());
		System.out.println("左子树高度：" + tree.leftHeight());
		System.out.println("右子树高度：" + tree.rightHeight());
	}
	
	public static void LL() {
		AVLTree tree = new AVLTree();
		tree.add(new User(10, "张三", 18));
		tree.add(new User(8, "Smith", 20));
		tree.add(new User(12, "Tom", 11));
		tree.add(new User(7, "张三", 18));
		tree.add(new User(9, "Smith", 20));
		tree.add(new User(6, "Smith", 20));
		
		System.out.println("前序遍历：");
		tree.foreach();
		
		System.out.println("AVL结果：");
		System.out.println("树的高度：" + tree.height());
		System.out.println("左子树高度：" + tree.leftHeight());
		System.out.println("右子树高度：" + tree.rightHeight());
	}
	
	/**
	 * 左右：先左旋再右旋
	 * 			10
	 * 		(7		11)
	 * 	(6		8)
	 * 				9
	 * 
	 * 如果10结点只右旋的话结果依然不平衡：
	 * 			7
	 * 		(6		10)
	 * 			(8		11)
	 * 				9
	 * 
	 * result:
	 * 			8
	 * 		(7		10)
	 * 	6		(9		11)
	 */
	public static void LR() {
		AVLTree tree = new AVLTree();
		tree.add(new User(10, "张三", 18));
		tree.add(new User(7, "Smith", 20));
		tree.add(new User(11, "Tom", 11));
		tree.add(new User(6, "张三", 18));
		tree.add(new User(8, "Smith", 20));
		tree.add(new User(9, "Smith", 20));
		
		System.out.println("前序遍历：");
		tree.foreach();
		
		System.out.println("AVL结果：");
		System.out.println("树的高度：" + tree.height());
		System.out.println("左子树高度：" + tree.leftHeight());
		System.out.println("右子树高度：" + tree.rightHeight());
	}

}
