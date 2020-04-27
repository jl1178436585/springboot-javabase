package com.jl.datastructures.stack;

/**
 * 使用栈来校验括号是否匹配
 * @author jl
 *
 */
public class ParenthesesValidWithStack {

	private Stack<Character> stack;
	
	public ParenthesesValidWithStack() {
		this.stack = new ArrayStack<Character>();
	}
	
	public boolean isValid(String s) {
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c == '(' || c == '[' || c == '{') {
				stack.push(c);
			}else {
				if(c == ')' || c == ']' || c == '}' ) {
					Character top = stack.pop();
					if(c == ')' && top != '(') {
						return false;
					}else if(c == ']' && top != '[') {
						return false;
					}else if(c == '}' && top != '{') {
						return false;
					}
				}else {//其他字符
					continue;
				}
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println(new ParenthesesValidWithStack().isValid("sd()"));
		System.out.println(new ParenthesesValidWithStack().isValid("sd()f()"));
		System.out.println(new ParenthesesValidWithStack().isValid("sd(f()"));
		System.out.println(new ParenthesesValidWithStack().isValid("s(df)[sdf]"));
		System.out.println(new ParenthesesValidWithStack().isValid("s(df)[sdf]{"));
		System.out.println(new ParenthesesValidWithStack().isValid("s(df)[sdf]{}"));
		System.out.println(new ParenthesesValidWithStack().isValid("s(df){[sdf]}"));
		System.out.println(new ParenthesesValidWithStack().isValid("s(df){[sdf]"));
	}
}
