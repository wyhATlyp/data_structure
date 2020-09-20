package com.wyh.ds.algorithm;

/**
 * 二分查找：针对已排好序的顺序表 eg：[1, 2, 4, 5, 6, 7, 8]
 */
public class BinSearch {
	
	private static final int[] ARRAY = {1, 2, 4, 5, 6, 7, 8};
	
	public static void main(String[] args) {
		System.out.println(find(6));
	}
	
	public static int find(int value) {
		if(value < ARRAY[0] || value > ARRAY[ARRAY.length - 1])
			return -1;
		
		int center = ARRAY.length >> 1;
		do {
			if(ARRAY[center] == value)
				return center;
			if(value > ARRAY[center]) {
				center = center + (center >> 1);
			} else {
				center = center - (center >> 1);
			}
		} while(ARRAY[center] != value);
		
		return -1;
	}

}
