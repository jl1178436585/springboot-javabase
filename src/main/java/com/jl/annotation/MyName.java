package com.jl.annotation;

/**
 * 自定义枚举MyName
 * 
 * @author jl
 *
 */
public enum MyName {

	GUOJING("郭靖","guojing"),XIAOYAO("李逍遥","lixiaoyao"), XUNHUAN("李寻欢","lixunhuan");
	
	public String name;
	
	public String code;
	
	private MyName(String name,String code) {
		this.name = name;
		this.code = code;
	}
	
	public MyName getName(String code) {
		for(MyName name : MyName.values()) {
			if(name.code.equals(code)) {
				return name;
			}
		}
		
		return null;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
}
