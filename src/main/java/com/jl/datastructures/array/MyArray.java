package com.jl.datastructures.array;

/**
 * 自定义数组
 * @author jl
 *
 */
public class MyArray {

	private int data[];
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
	public MyArray(int capacity) {
		data = new int[capacity];
		size = 0;//虽然容量是capacity,但是元素个数此时是0
	}
	
	public MyArray() {
		this(default_capacity);
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
	public void addLast(int e) {
		/*if(size == data.length) {
			throw new IllegalArgumentException("添加数组失败，数组已经满了");
		}
		data[size] = e;//此处是size不是size-1
		size++;
		 等价于下面的写法
		*/
		add(size, e);
	}
	
	public void addFirst(int e) {
		add(0,e);
	}
	
	/**
	 * 向数组指定位置添加元素
	 * @param index
	 * @param e
	 */
	public void add(int index,int e) {
		if(size == data.length) {
			throw new IllegalArgumentException("添加数组失败，数组已经满了");
		}
		if(index < 0 || index > size) {//index > size:数组中有些位置没有元素，元素不是紧密排列的
			throw new IllegalArgumentException("添加数组失败，index >= 0 and index <= size");
		}
		for(int i = size-1; i >= index; i--) {
			data[i+1] = data[i];
		}
		data[index]=e;
		//不要忘记size++
		size++;
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
	public int getElement(int index) {
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
	public void set(int index,int e) {
		if(index < 0 || index >= size) {
			throw new IllegalArgumentException("添加获取失败，index >= 0 and index <= size");
		}
		data[index]=e;
	}
	
	public boolean contains(int e) {
		for(int i = 0; i < size; i++) {
			if(e == data[i]) {
				return true;
			}
		}
		return false;
	}
	
	public int find(int e) {
		for(int i = 0; i < size; i++) {
			if(e == data[i]) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * 移除指定元素
	 * @param e
	 */
	public void removeElement(int e) {
		int index = find(e);
		if(index != -1) {
			remove(index);
		}
	}
	
	/**
	 * 删除指定位置的元素，返回该元素
	 */
	public int remove(int index) {
		if(index < 0 || index >= size) {
			throw new IllegalArgumentException("添加获取失败，index >= 0 and index <= size");
		}
		
		int ret = data[index];
		//遍历一次就搞定
		for(int i = index+1; i < size; i++) {
			data[i-1] = data[i];
		}
		size--;
		return ret;
	}
	
	public int removeFirst(int index) {
		return remove(0);
	}
	
	public int removeLast(int index) {
		return remove(size-1);
	}
}
