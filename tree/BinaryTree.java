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
			System.out.println("这是空树");
		}
	}

	public void midShow() {
		if (root != null) {
			root.midShow();
		} else {
			System.out.println("这是空树");
		}
	}
	
	public void afterShow(){
		if (root != null) {
			root.afterShow();
		} else {
			System.out.println("这是空树");
		}
	}

	public TreeNode frontSearch(int i) {
		return root.frontSearch(i);
	}
	
	public void delete(int i) {
		// 如要删除的是根节点
		if (root.value == i) {
			root = null;
		} else {
			root.delete(i);
		}
	}
}
