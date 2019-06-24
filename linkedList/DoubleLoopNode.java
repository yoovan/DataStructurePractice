package com.linkedList;

public class DoubleLoopNode {
	DoubleLoopNode pre = this; 
	DoubleLoopNode next = this;
	int data;
	
	public DoubleLoopNode(int data) {
		this.data = data;
	}
	
	public void after(DoubleLoopNode node) {
		node.pre = this; // ׷�ӽڵ��preָ��ǰ�ڵ�
		node.next = this.next; // ׷�ӽڵ��nextָ����һ���ڵ�
		// ����һ���ڵ��preָ��׷�ӵĽڵ�
		this.next.pre = node;
		this.next = node; // ��ǰ�ڵ����һ�ڵ�ָ��׷�ӽڵ�
	}
	
	public DoubleLoopNode next() {
		return this.next;
	}
	
	public DoubleLoopNode pre() {
		return this.pre;
	}
	
	public int getData() {
		return this.data;
	}
}
