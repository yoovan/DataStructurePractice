package com.tree;

public class ArrayBinaryTree {
	int[] data;
	
	public ArrayBinaryTree(int[] data) {
		this.data = data;
	}
	
	public void frontShow() {
		frontShow(0);
	}
	
	// 前序遍历
	public void frontShow(int index) {
		if (data == null || data.length == 0) {
			return;
		}
		System.out.println(data[index]);
		// 遍历左子节点
		if ((2*index+1) < data.length) {
			frontShow(2*index+1);
		}
		
		// 遍历右子节点
		if ((2*index+2) < data.length) {
			frontShow(2*index+2);
		}
	}
}
