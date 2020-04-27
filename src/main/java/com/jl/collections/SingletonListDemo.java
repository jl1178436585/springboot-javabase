package com.jl.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SingletonListDemo {
	
	     public static void main(String args[]) {
	      String init[] = { "One", "Two", "Three", "One", "Two", "Three" };
	      List<String> list = new ArrayList<String>(Arrays.asList(init));
	      System.out.println("List value before: "+list);
	      
	      list = Collections.singletonList("test");
	      
	      //因为返回的list是不可变的，所以下面的add()会报错
	      System.out.println(list.getClass());//java.util.Collections$SingletonList
//	      list.add("s");
	      
	      
	      System.out.println("List value after: "+list);
	   }
}
