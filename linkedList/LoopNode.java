package com.linkedList;

public class LoopNode {
	int data;
	LoopNode next = this;
	
	public LoopNode(int data) {
		this.data = data;
	}
	
	// ɾ����һ���ڵ�
	public void removeNext() {
		/**
		 *  ���ڵ�������֪����һ���ڵ����Ϣ������ֻ�ܴ���һ���ڵ���ɾ����һ���ڵ�
		 *  ˼·��
		 *  ��ȡ��ǰ�Ľڵ����һ�ڵ㣬�ж��Ƿ�Ϊ�գ������˳�ѭ��
		 *  �����Ϊ�գ�����ǰ�ڵ��nextָ�����½ڵ��next
		 */
		LoopNode nextNode = this.next.next;
		this.next = nextNode;
		
	}
	
	public void after(LoopNode node) {
		// �²���ڵ����һ���ڵ�Ϊ��һ�ڵ��next
		node.next = this.next;
		// ��һ�ڵ����һ�ڵ�ָ���²���Ľڵ�
		this.next = node;
	}
	
	// ��ȡ��һ���ڵ�
	public LoopNode next() {
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

