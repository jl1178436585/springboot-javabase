package com.jl.annotation.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import com.jl.annotation.MyAnnotation1;
import com.jl.annotation.MyName;

public class ReflectDemo {

//	@MyAnnotation1(age = 10, depart = { "测试部门" }, score = { 1000 }, value = "value的值",name=MyName.XIAOYAO)
	@SuppressWarnings(value = { "unchecked" })
	@Deprecated//只有这个注解的Retention是runTime
	@Override
	public String toString() {
		System.out.println("say.....");
		return "name";
	}

	
	public static void main(String[] args) throws Exception {
		Class<?> c = Class.forName("com.jl.annotation.reflect.ReflectDemo");
		Method method = c.getMethod("toString");
		//获取方法上所有的注解
		Annotation[] annotations = method.getAnnotations();
		//只输出@java.lang.Deprecated()
		for (Annotation annotation : annotations) {
			System.out.println(annotation);
		}
		
		boolean annotationPresent = method.isAnnotationPresent(MyAnnotation1.class);
		if(annotationPresent) {//判断是否是指定的注解
			MyAnnotation1 annotation = method.getAnnotation(MyAnnotation1.class);
			MyName name = annotation.name();
			int[] score = annotation.score();
			int age = annotation.age();
			System.out.println(name + "," + age + "," +score[0]);
		}
	}
}
