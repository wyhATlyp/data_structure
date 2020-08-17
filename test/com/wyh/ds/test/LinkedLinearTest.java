package com.wyh.ds.test;

import com.wyh.ds.linear.LinearList;
import com.wyh.ds.linear.LinkedLinearList;

public class LinkedLinearTest {

    public static void main(String[] args) {
        LinearList<Integer> list = new LinkedLinearList<Integer>();

        System.out.println("构造方法中初始化：" + list);
        
        list.insert(0, 10);
        list.insert(1, 30);
        list.insert(2, 10);
        list.insert(3, 20);

        System.out.println("插入元素：" + list);

        System.out.println("获取索引为2的元素值：" + list.get(2));

        System.out.println("获取元素值为10的索引：" + list.locate(10));

        list.delete(1);
        System.out.println("删除索引为1的元素：" + list);
    }

}
