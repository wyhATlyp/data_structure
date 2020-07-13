package com.wyh.ds.test.util;

import com.wyh.ds.hashtable.HashObject;

public class HashObjectTest {
	
	private int data;
	
	public static void main(String[] args) {
		HashObject<HashObjectTest> hashObject = new HashObject<>(20);
		for(int i = 0; i < 100; i ++) {
			HashObjectTest test = new HashObjectTest();
			test.data = i;
			hashObject.add(test);
		}
		hashObject.foreach();
	}

	@Override
	public String toString() {
		return "" + data;
	}
	
}
