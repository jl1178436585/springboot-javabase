package com.jl.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 注解定义
 * 
 * pubic @interface 注解名称{
 * 		数据类型   变量名称();
 * 		
 * 		数据类型   变量名称 ()  default "这是默认值";//设置默认值
 * 
 * }
 * 
 * @author jl
 *
 */
@Retention(value = RetentionPolicy.RUNTIME) 
public @interface MyAnnotation1 {
	
	public String value();
	
	public MyName name() default  MyName.GUOJING;
	
	public int age();
	
	public String[] depart();
	
	public int[] score();
}
