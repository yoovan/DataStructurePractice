package com.graph;

import java.util.ArrayList;

public class MyQuene {
	
	private ArrayList<Integer> quene;
	
	public MyQuene() {
		this.quene = new ArrayList<>();
	}
	
	public ArrayList<Integer> getQuene() {
		return quene;
	}
	
	/**
	 * 入队操作
	 * @param value
	 */
	public void push(int value) {
		quene.add(quene.size(), value);
	}
	
	/**
	 * 出队列操作
	 * @return
	 */
	public int pop() {
		if (quene.size() < 1) {
			System.out.println("没有元素了，出队列失败......");
			return -1;
		}
		int index = quene.get(0);
		quene.remove(0);
		return index;
	}
	
	/**
	 * 判断队列是否为空
	 * @return
	 */
	public boolean isEmpty() {
		if (quene.size() > 0) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "MyQuene [quene=" + quene + "]";
	}

}
