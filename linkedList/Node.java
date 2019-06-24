package com.linkedList;

public class Node {
	int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
	}
	
	public Node append(Node node) {
		// ���õ�ǰ�ڵ�
		Node currentNode = this;
		// ѭ������ֱ�����һ���ڵ�
		while (true) {
			// ȡ����һ���ڵ�
			Node nextNode = currentNode.next;
			// ����ڵ��ǿգ�������������һ���ڵ��ˣ�����ѭ��
			if (nextNode == null) {
				break;
			}
			// ִ�е����˵����һ���ڵ㲻Ϊ�գ���������²���
			currentNode = nextNode;
		}
		// ����ѭ����currentNode�������һ���ڵ㣬��currentNode��nextָ��Ҫ��ӵĽڵ�
		currentNode.next = node;
		// ���ص�ǰ�Ľڵ�
		return this;
	}
	
	// ɾ����һ���ڵ�
	public void removeNext() {
		/**
		 *  ���ڵ�������֪����һ���ڵ����Ϣ������ֻ�ܴ���һ���ڵ���ɾ����һ���ڵ�
		 *  ˼·��
		 *  ��ȡ��ǰ�Ľڵ����һ�ڵ㣬�ж��Ƿ�Ϊ�գ������˳�ѭ��
		 *  �����Ϊ�գ�����ǰ�ڵ��nextָ�����½ڵ��next
		 */
		Node nextNode = this.next.next;
		this.next = nextNode;
		
	}
	
	public void after(Node node) {
		// �²���ڵ����һ���ڵ�Ϊ��һ�ڵ��next
		node.next = this.next;
		// ��һ�ڵ����һ�ڵ�ָ���²���Ľڵ�
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
	
	// ��ȡ��һ���ڵ�
	public Node next() {
		if (this.next == null) {
			throw new RuntimeException("û���¸��ڵ���");
		} else {
			return this.next;
		}
		
	}
	
	// ��ȡ��ǰ�ڵ��ֵ
	public int getData() {
		return this.data;
	}
}

