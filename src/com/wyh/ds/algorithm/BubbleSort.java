package com.wyh.ds.algorithm;

/**
 * 冒泡排序：核心思想-比较交换
 * 	两次遍历，由内而外
 * 	内层：遍历，共需遍历length-1次，
 *  外层：每次遍历都可以将一个最大的元素放在最后，共需length-1次
 *  
 *  时间复杂度：O(n * n)
 *  
 *  优化点：
 *  	1.如果某次遍历时没有发生交换说明已经排好序，立刻停止
 *  	2.已经比较过第不需要再次比较-代码中未实现
 * 
 */
public class BubbleSort {
	
	private static final int[] INPUT_ARRAY = {10,1,35,61,89,36,55,40};//从小到大排序
	
	public static void main(String[] args) {
		for(int i = 0; i < INPUT_ARRAY.length - 1; i ++) {//每次遍历都可以将一个最大的元素放在数组的最后
			boolean sorted = true;//是否已排好序-用来优化
			for(int j = 0; j < INPUT_ARRAY.length - 1 - i; j ++) {//两两比较交换，已排好序的不需要再次比较(INPUT_ARRAY.length - 1 -j)
				if(INPUT_ARRAY[j] > INPUT_ARRAY[j + 1]) {
					//交换
					int temp = INPUT_ARRAY[j];
					INPUT_ARRAY[j] = INPUT_ARRAY[j + 1];
					INPUT_ARRAY[j + 1] = temp;
					sorted = false;
				}
				System.out.print("第" + j + "次比较交换：");
				print();
			}
			
			if(sorted) {
				System.out.print("第" + i + "次将最大第元素放在最后结果(已排好序，提前结束)：");
				print();
				break;
			}
			
			System.out.print("第" + i + "次将最大第元素放在最后结果：");
			print();
		}
		print();
	}
	
	public static void print() {
		for(int i = 0; i < INPUT_ARRAY.length; i ++) {
			System.out.print(INPUT_ARRAY[i] + " ");
		}
		System.out.println();
	}

}
