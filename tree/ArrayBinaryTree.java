package com.tree;

public class ArrayBinaryTree {
	int[] data;
	
	public ArrayBinaryTree(int[] data) {
		this.data = data;
	}
	
	public void frontShow() {
		frontShow(0);
	}
	
	// ǰ�����
	public void frontShow(int index) {
		if (data == null || data.length == 0) {
			return;
		}
		System.out.println(data[index]);
		// �������ӽڵ�
		if ((2*index+1) < data.length) {
			frontShow(2*index+1);
		}
		
		// �������ӽڵ�
		if ((2*index+2) < data.length) {
			frontShow(2*index+2);
		}
	}
}
