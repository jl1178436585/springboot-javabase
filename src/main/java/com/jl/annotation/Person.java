package com.jl.annotation;

import java.lang.annotation.Repeatable;

@Repeatable(Persons.class)
public @interface Person {
	
	String role() default "";
}
