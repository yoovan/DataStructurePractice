package com.linkedList;

public class Node {
	int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
	}
	
	public Node append(Node node) {
		// 设置当前节点
		Node currentNode = this;
		// 循环遍历直到最后一个节点
		while (true) {
			// 取出下一个节点
			Node nextNode = currentNode.next;
			// 如果节点是空，则表明到达最后一个节点了，跳出循环
			if (nextNode == null) {
				break;
			}
			// 执行到这儿说明下一个节点不为空，则继续向下查找
			currentNode = nextNode;
		}
		// 跳出循环后，currentNode就是最后一个节点，将currentNode的next指向要添加的节点
		currentNode.next = node;
		// 返回当前的节点
		return this;
	}
	
	// 删除下一个节点
	public void removeNext() {
		/**
		 *  由于单链表不能知道上一个节点的信息，所以只能从上一个节点来删除下一个节点
		 *  思路：
		 *  获取当前的节点的下一节点，判断是否为空，空则退出循环
		 *  如果不为空，将当前节点的next指向下下节点的next
		 */
		Node nextNode = this.next.next;
		this.next = nextNode;
		
	}
	
	public void after(Node node) {
		// 新插入节点的下一个节点为上一节点的next
		node.next = this.next;
		// 上一节点的下一节点指向新插入的节点
		this.next = node;
	}
	
	
	public void show() {
		Node currentNode = this;
		while (true) {
			System.out.print(currentNode.data +" ");
			if (currentNode.next == null) {
				break;
			}
			currentNode = currentNode.next;
		}
		System.out.println();
	}
	
	// 获取下一个节点
	public Node next() {
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

