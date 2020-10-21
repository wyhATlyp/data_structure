package com.wyh.ds.algorithm;

import java.util.BitSet;

/**
 * 布隆过滤器：检索一个元素在一个集合中是否存在，判断存在时可能有一定的误差
 */
public class BloomFilter {
	
	public static void main(String[] args) {
		Bollom bollom = new Bollom();
		bollom.add("Hello World");
		bollom.add("Hello world");
		bollom.add("Hello orld");
		bollom.add("Hello 123");
		System.out.println("位图：" + bollom.bitMap);
		
		String test1 = "Hello";
		String test2 = "Hello World";
		if(bollom.match(test1)) {
			System.out.println(test1 + "可能在集合中");
		} else {
			System.out.println(test1 + "一定不再集合中");
		}
		
		if(bollom.match(test2)) {
			System.out.println(test2 + "可能在集合中");
		} else {
			System.out.println(test2 + "一定不在集合中");
		}
	}
	
	private static class Bollom {
		
		private static final int M = 8 << 10;//位图大小1024字节，1K
		
		private BitSet bitMap = new BitSet(M);
		
		public void add(String value) {
			int hash1 = hash1(value);
			int hash2 = hash2(value);
			int hash3 = hash3(value);
			
			bitMap.set(hash1 % M, true);
			bitMap.set(hash2 % M, true);
			bitMap.set(hash3 % M, true);
		}
		
		public boolean match(String value) {
			int hash1 = hash1(value);
			int hash2 = hash2(value);
			int hash3 = hash3(value);
			
			return bitMap.get(hash1 % M) && bitMap.get(hash2 % M) && bitMap.get(hash3 % M);
		}
		
		private int hash1(String value) {
			return value.hashCode() < 0 ? value.hashCode() * (-1) + 1 : value.hashCode() + 1;
		}
		
		private int hash2(String value) {
			return value.hashCode() < 0 ? value.hashCode() * (-1) + 2 : value.hashCode() + 2;
		}
		
		private int hash3(String value) {
			return value.hashCode() < 0 ? value.hashCode() * (-1) + 3 : value.hashCode() + 3;
		}
		
	}

}
