package com.wyh.ds.store;

import java.util.Arrays;

import com.wyh.ds.logic.linear.LinearList;

/**
 * <p>顺序表</p>
 * @author WYH
 * @param <E>
 */
public class SequenceLinearList<E> implements LinearList<E> {
	
	private E[] array;
	
	public SequenceLinearList() {
		init();
	}

	@SuppressWarnings("unchecked")
	@Override
	public LinearList<E> init() {
		array = (E[]) new Object[0];
		return this;
	}

	@Override
	public int length() {
		return array.length;
	}

	@Override
	public E get(int i) {
		return array[i];
	}

	@Override
	public int locate(E e) {
		for(int i = 0; i < array.length; i ++) {
			if(e == array[i])
				return i;
		}
		return -1;
	}
	
	public void add(E e) {
		insert(array.length -1, e);
	}

	@Override
	public void insert(int i, E e) {
		array = Arrays.copyOf(array, array.length + 1);
		for(int j = i + 1; j < array.length; j ++) {
			array[j] = array[j - 1];
		}
		array[i] = e; 
	}

	@Override
	public void delete(int i) {
		array[i] = null;
		for(int j = i + 1; j < array.length; j ++) {
			array[j - 1] = array[j];
		}
		array = Arrays.copyOf(array, array.length - 1);
	}
	
	@Override
	public String toString() {
		String result = "[";
		for(int i = 0; i < array.length; i ++) {
			result += (array[i]);
			if(i != array.length - 1)
				result += ",";
		}
		result += "]";
		return result;
	}

}
