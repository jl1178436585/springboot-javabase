package com.jl.annotation;

/**
 * 注解 @Repeatable的使用
 * 
 * @author jl
 *
 */

public @interface Persons {

	Person[] value();
	
}
