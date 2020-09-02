package com.wyh.ds.test;

import com.wyh.ds.User;
import com.wyh.ds.tree.TwoThreeTree;

/**
 *	二三树测试场景：
 *		1.根结点达到三个数据时
 *		2.父结点为二结点、左子树达到三个数据时
 *		3.父结点为三结点、左子树达到三个数据时
 *		4.父结点为二结点、右子树达到三个数据时
 *		5.父结点为三结点、右子树达到三个数据时
 */
public class TwoTreeTreeTest {
	
	public static void main(String[] args) {
		
		TwoThreeTree tree = new TwoThreeTree();
		tree.add(new User(50, "张三", 20));
		tree.add(new User(100, "李四", 20));
		tree.add(new User(10, "王五", 20));//根结点分裂【10，50，100】 -> 50(10, 100)
		
		tree.add(new User(30, "王五", 20));
		tree.add(new User(20, "王五", 20));//父结点为二结点，分裂结点是左子树
		tree.add(new User(5, "王五", 20));
		tree.add(new User(8, "王五", 20));//父结点为三结点，分裂结点是左子树
		
		tree.add(new User(16, "王五", 20));
		tree.add(new User(18, "王五", 20));//父结点为二结点，分裂结点是右子树
		tree.add(new User(17, "王五", 20));
		tree.add(new User(19, "王五", 20));//父结点为三结点，分裂结点是右子树
		
		tree.add(new User(200, "王五", 20));
		tree.add(new User(300, "王五", 20));
		tree.add(new User(180, "王五", 20));
		tree.add(new User(150, "王五", 20));//父结点为三结点，分裂结点在中间
		
		//随便测测
		tree.add(new User(60, "王五", 20));
		tree.add(new User(120, "王五", 20));
		tree.add(new User(80, "王五", 20));
		tree.add(new User(70, "王五", 20));
		
		tree.foreach();
	}

}
