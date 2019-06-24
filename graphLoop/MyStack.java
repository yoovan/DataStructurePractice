package com.graph;

import java.util.ArrayList;

public class MyStack {

	private ArrayList<Integer> stack;
	
	public MyStack() {
		stack = new ArrayList<>();
	}
	
	public ArrayList<Integer> getStack() {
		return stack;
	}
	
	public void setStack(ArrayList<Integer> stack) {
		this.stack = stack;
	}
	
	public void push(int value) {
		stack.add(stack.size(), value);
	}
	
	public int pop() {
		if (stack.size() <= 0) {
			System.out.println("没有元素了，出栈失败.....");
			return -1;
		}
		int index = stack.get(stack.size()-1);
		stack.remove(stack.size()-1);
		return index;
	}
	
	public boolean isEmpty() {
		if (stack.size() > 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public String toString() {
		return "MyStack [stack=" + stack + "]";
	}
	
	
}
