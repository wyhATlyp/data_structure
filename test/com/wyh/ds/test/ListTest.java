package com.wyh.ds.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListTest {
	
	public static final int LENGTH = 10000000;
	
	public static void main(String[] args) {
		
		new Thread(() -> {
			List<Integer> linked = new LinkedList<Integer>();
			
			long t1 = System.currentTimeMillis();
			for(int i = 0; i < LENGTH; i ++)
				linked.add(i);
			long t2 = System.currentTimeMillis();
			System.out.println("linked add " + LENGTH + "：" + (t2 - t1));
			
			linked.remove(0);
			long t3 = System.currentTimeMillis();
			System.out.println("linked remove first：" + (t3 - t2));
			
			linked.remove(linked.size() - 1);
			long t4 = System.currentTimeMillis();
			System.out.println("linked remove last：" + (t4 - t3));
			
			linked.get(linked.size() - 1);
			long t5 = System.currentTimeMillis();
			System.out.println("linked get last：" + (t5 - t4));
			
			linked.get(linked.size() >> 1);
			long t6 = System.currentTimeMillis();
			System.out.println("linked get center：" + (t6 - t5));
		}).start();
		
		new Thread(() -> {
			List<Integer> array = new ArrayList<Integer>();
			
			long t1 = System.currentTimeMillis();
			for(int i = 0; i < LENGTH; i ++)
				array.add(i);
			long t2 = System.currentTimeMillis();
			System.out.println("array add " + LENGTH + "：" + (t2 - t1));
			
			array.remove(0);
			long t3 = System.currentTimeMillis();
			System.out.println("array remove first：" + (t3 - t2));
			
			array.remove(array.size() - 1);
			long t4 = System.currentTimeMillis();
			System.out.println("array remove last：" + (t4 - t3));
			
			array.get(array.size() - 1);
			long t5 = System.currentTimeMillis();
			System.out.println("array get last " + (t5 - t4));
			
			array.get(array.size() >> 1);
			long t6 = System.currentTimeMillis();
			System.out.println("array get center " + (t6 - t5));
		}).start();
		
	}

}
