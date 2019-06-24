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
	 * ��Ӳ���
	 * @param value
	 */
	public void push(int value) {
		quene.add(quene.size(), value);
	}
	
	/**
	 * �����в���
	 * @return
	 */
	public int pop() {
		if (quene.size() < 1) {
			System.out.println("û��Ԫ���ˣ�������ʧ��......");
			return -1;
		}
		int index = quene.get(0);
		quene.remove(0);
		return index;
	}
	
	/**
	 * �ж϶����Ƿ�Ϊ��
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
