package com.tree;

public class BinaryTree {
	TreeNode root;
	
	public void setRoot(TreeNode root) {
		this.root = root;
	}

	public void frontShow() {
		if (root != null) {
			root.frontShow();
		} else {
			System.out.println("���ǿ���");
		}
	}

	public void midShow() {
		if (root != null) {
			root.midShow();
		} else {
			System.out.println("���ǿ���");
		}
	}
	
	public void afterShow(){
		if (root != null) {
			root.afterShow();
		} else {
			System.out.println("���ǿ���");
		}
	}

	public TreeNode frontSearch(int i) {
		return root.frontSearch(i);
	}
	
	public void delete(int i) {
		// ��Ҫɾ�����Ǹ��ڵ�
		if (root.value == i) {
			root = null;
		} else {
			root.delete(i);
		}
	}
}
