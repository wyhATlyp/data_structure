package com.wyh.ds.test;

import com.wyh.ds.User;
import com.wyh.ds.tree.RedBlackTree;

/**
 * 红黑树测试
 */
public class RedBlackTreeTest {
	
	public static void main(String[] args) {
		RedBlackTree tree = new RedBlackTree();
		tree.add(new User(500, "张三", 20));//根结点默认为黑色
		tree.add(new User(300, "张三", 20));//新增结点默认为红色
		/**
		 * 父结点为红色、叔叔不存在、LL结构-右旋
		 * 
		 * 黑(500)
		 * 	L红(300)
		 * 	L红(200)
		 * 
		 * ->右旋后
		 * 
		 * 黑(300) -原根结点本来就是黑色
		 * 	L红(200)
		 * 	R红(500) -新增的结点默认为红色
		 */
		tree.add(new User(200, "张三", 20));
		
		/**
		 * 父结点为红色、叔叔存在并且为红色、LL结构
		 * 
		 * 黑(300)
		 * 	L红(200)
		 * 	 L红(100)
		 * 	R红(500)
		 * 
		 * ->变色后
		 * 
		 * 红(300)
		 *  L黑(200)
		 *   L红(100)
		 *  R黑(500)
		 *  
		 * ->根结点变为黑色
		 * 
		 * 黑(300)
		 * 	L黑(200)
		 * 	 L红(100)
		 *  R黑(500)
		 */
		tree.add(new User(100, "张三", 20));
		tree.add(new User(50, "张三", 20));
		tree.add(new User(40, "张三", 20));
		tree.add(new User(80, "张三", 20));
		tree.add(new User(30, "张三", 20));
		
		tree.foreach();
	}

}
