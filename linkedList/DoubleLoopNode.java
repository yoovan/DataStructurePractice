package com.linkedList;

public class DoubleLoopNode {
	DoubleLoopNode pre = this; 
	DoubleLoopNode next = this;
	int data;
	
	public DoubleLoopNode(int data) {
		this.data = data;
	}
	
	public void after(DoubleLoopNode node) {
		node.pre = this; // 追加节点的pre指向当前节点
		node.next = this.next; // 追加节点的next指向下一个节点
		// 将第一个节点的pre指向追加的节点
		this.next.pre = node;
		this.next = node; // 当前节点的下一节点指向追加节点
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
