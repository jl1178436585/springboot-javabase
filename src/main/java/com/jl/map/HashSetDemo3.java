/*
 * @(#)HashSetDemo.java  
 */
package com.jl.map;

import java.util.HashSet;
import java.util.Set;

/**
 *<p>
 *	重写了equals，不重写hashCode
 *</p>
 * @author: jl
 * @date: 2018/07/01
 * @version: v1.0
 */
public class HashSetDemo3 {


	/**
	 * 因为两个对象id都是0001,业务上我们就认为这两个对象是一样的，所以添加到Set之后，因为只存一个
	 * 
	 * 但是由于我们重写了equals没有重写hashCode,导致set在调用add(E e)方法添加元素时，先比较两个对象的hashCode，这时
	 * 由于没有重写，返回的是对象的地址，所以是两个不同的地址，于是HashSet(内部是HashMap)就认为这是两个不同的对象，
	 * 就导致这两个对象都存入到set中了。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Person p1 = new Person("0001");
		Person p2 = new Person("0001");
		
		System.out.println("----------------");
		Set<Person> set = new HashSet<>();
		set.add(p1);
		set.add(p2);
		System.out.println(set.size());
	}

	/**
	 * 键
	 * 
	 */
	static class Person {
		private String id;

		public Person(String key) {
			this.id = key;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Person) {
				Person key = (Person) obj;
				return id.equals(key.id);
			}
			return false;
		}
	}

}
