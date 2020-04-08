package com.wyh.ds.logic.linear;

/**
 * <p>线性表</p>
 * @author WYH
 * @param <E>
 */
public interface LinearList<E> {
	
	LinearList<E> init();
	
	int length();
	
	E get(int i);
	
	int locate(E e);
	
	void insert(int i, E e);
	
	void delete(int i);

}
