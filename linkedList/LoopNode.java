package com.linkedList;

public class LoopNode {
	int data;
	LoopNode next = this;
	
	public LoopNode(int data) {
		this.data = data;
	}
	
	// 删除下一个节点
	public void removeNext() {
		/**
		 *  由于单链表不能知道上一个节点的信息，所以只能从上一个节点来删除下一个节点
		 *  思路：
		 *  获取当前的节点的下一节点，判断是否为空，空则退出循环
		 *  如果不为空，将当前节点的next指向下下节点的next
		 */
		LoopNode nextNode = this.next.next;
		this.next = nextNode;
		
	}
	
	public void after(LoopNode node) {
		// 新插入节点的下一个节点为上一节点的next
		node.next = this.next;
		// 上一节点的下一节点指向新插入的节点
		this.next = node;
	}
	
	// 获取下一个节点
	public LoopNode next() {
		if (this.next == null) {
			throw new RuntimeException("没有下个节点了");
		} else {
			return this.next;
		}
		
	}
	
	// 获取当前节点的值
	public int getData() {
		return this.data;
	}
}

