package com.jl.datastructures.array;

import org.junit.experimental.theories.FromDataPoints;

/**
 * 自定义动态数组:泛型
 * @author jl
 * 
 */
public class Array<E> {

	private E data[];
	/**
	 * 数组有效内容的长度:
	 */
	private int size;
	/**
	 * 数组默认容量
	 */
	private static final int default_capacity = 10;
	
	/**
	 * 传入数组的容量构造数组：内存中开辟一个指定容量是capacity的数组
	 * @param capacity
	 */
	public Array(int capacity) {
		//java不支持new一个泛型类型的数组，因此需要特殊处理一下,先new 一个Object类型的数组，然后强转成E类型
//		data = new E[capacity];
		data = (E[])new Object[capacity];
		size = 0;//虽然容量是capacity,但是元素个数此时是0
	}
	
	public Array() {
		this(default_capacity);
	}

	public Array(E[] arr) {
		data = (E[])new Object[arr.length];
		for (int i = 0; i < arr.length; i++) {
			data[i] = arr[i];
		}
		size = arr.length;
	}

	/**
	 * 返回数组的元素个数
	 * @return
	 */
	public int getSize() {
		return this.size;
	}
	
	/**
	 * 返回数组的容量
	 * @return
	 */
	public int getCapacity(){
		return this.data.length;
	}
	
	/**
	 * 数组是否为空：元素个数是否为0
	 * @return
	 */
	public boolean isEmpty() {
		return this.size==0;
	}
	
	/**
	 * 向数组末尾添加元素
	 * @param e
	 */
	public void addLast(E e) {
		/*if(size == data.length) {
			throw new IllegalArgumentException("添加数组失败，数组已经满了");
		}
		data[size] = e;//此处是size不是size-1
		size++;
		 等价于下面的写法
		*/
		add(size, e);
	}
	
	public void addFirst(E e) {
		add(0,e);
	}
	
	/**
	 * 向数组指定位置添加元素
	 * @param index
	 * @param e
	 */
	public void add(int index,E e) {
		
		if(index < 0 || index > size) {//index > size:数组中有些位置没有元素，元素不是紧密排列的
			throw new IllegalArgumentException("添加数组失败，index >= 0 and index <= size");
		}
		
		if(size == data.length) {
//			throw new IllegalArgumentException("添加数组失败，数组已经满了");
			//自动扩容为原来数组的2倍
			resize(data.length * 2);
		}
		
		for(int i = size-1; i >= index; i--) {
			data[i+1] = data[i];
		}
		data[index]=e;
		//不要忘记size++
		size++;
	}
	
	/**
	 * 数组扩容
	 * @param i
	 */
	private void resize(int newSize) {
		E[] newArr = (E[])new Object[newSize];
		for(int i = 0; i < size; i++) {
			newArr[i] = data[i];
		}
		data = newArr;
		
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("数组容量capacity=%d, size=%d,内容【",data.length,size));
		for(int i = 0; i < size; i++) {
			sb.append(data[i]);
			if(i != size -1) {
				sb.append(",");
			}
		}
		sb.append("】");
		return sb.toString();
	}
	
	/**
	 * 获取指定位置的元素
	 * @param index
	 * @return
	 */
	public E get(int index) {
		if(index < 0 || index >= size) {
			throw new IllegalArgumentException("添加获取失败，index >= 0 and index <= size");
		}
		return data[index];
	}
	
	/**
	 * 更新指定位置的元素
	 * @param index
	 * @param e
	 */
	public void set(int index,E e) {
		if(index < 0 || index >= size) {
			throw new IllegalArgumentException("添加获取失败，index >= 0 and index <= size");
		}
		data[index]=e;
	}
	
	public boolean contains(E e) {
		for(int i = 0; i < size; i++) {
			if(e.equals(data[i])) {
				return true;
			}
		}
		return false;
	}
	
	public int find(E e) {
		for(int i = 0; i < size; i++) {
			if(e.equals(data[i])) {
				return i;
			}
		}
		return -1;
	}
	
	public E getFirst() {
		return get(0);
	}
	
	public E getLast() {
		//不要使用data[size-1],
		return get(size-1);//可以校验size-1的合法性
	}
	
	/**
	 * 移除指定元素
	 * @param e
	 */
	public void removeElement(E e) {
		int index = find(e);
		if(index != -1) {
			remove(index);
		}
	}
	
	/**
	 * 删除指定位置的元素，返回该元素
	 */
	public E remove(int index) {
		if(index < 0 || index >= size) {
			throw new IllegalArgumentException("添加获取失败，index >= 0 and index <= size");
		}
		
		E ret = data[index];
		//遍历一次就搞定
		for(int i = index+1; i < size; i++) {
			data[i-1] = data[i];
		}
		size--;
		//因为移除元素的过程是元素覆盖的过程，导致最后一个位置还有引用，只是外面访问不到了，不利于垃圾回收
		data[size]= null;
		/*if(size == data.length / 2) {//如果删除完发现数组只有一半的位置有元素，重置大小
			resize(data.length / 2);
		}*/
		
		if(size == data.length / 4 && data.length / 2 != 0) {//这个效率更高，才用懒惰Lazy的方式
			resize(data.length / 2);
		}
		
		
		return ret;
	}
	
	public E removeFirst() {
		return remove(0);
	}
	
	public E removeLast() {
		return remove(size-1);
	}
	
	public void swap(int i, int j) {
		if(i <0 || i >= size || j < 0 || j >= size) {
			throw new IllegalArgumentException("索引不合法！");
		}
		E temp = data[i];
		data[i] = data[j];
		data[j] = temp;
		
	}
}
