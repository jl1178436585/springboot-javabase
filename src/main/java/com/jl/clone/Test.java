/*
 * @(#)Test.java  
 */
package com.jl.clone;
/**
 *<p>Title:</p>
 * @author: jl
 * @date: 2018/06/29
 * @version: v1.0
 */
public class Test {

	public static void main(String[] args) throws Exception {
		CloneObj obj = new CloneObj("a",12);
		Person p = new Person("男");
		obj.setP(p);
		CloneObj clone = (CloneObj) obj.clone();
		System.out.println(obj == clone);
		System.out.println(obj.getName());
		obj.setName("bb");
		System.out.println(clone.getName());
		
		System.out.println(obj.getP().getSex());
		obj.getP().setSex("女");
		System.out.println(clone.getP().getSex());
		
		System.out.println("----------------");
		
		CloneObj obj1 = new CloneObj("b",21);
		CloneObj obj2 = new CloneObj("c",22);
		CloneObj obj3 = new CloneObj("d",23);
		CloneObj[] src = {obj1,obj2,obj3};
		CloneObj[] dest = new CloneObj[src.length];
		System.arraycopy(src, 0, dest, 0, src.length);
		for (int i = 0; i < dest.length; i++) {
			System.out.println(dest[i] == src[i]);
		}

	}
	
}
