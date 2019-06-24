package com.tree;

public class TreeNode {
	int value;
	TreeNode leftNode;
	TreeNode rightNode;
	
	public TreeNode(int value) {
		this.value = value;
	}
	
	public void setLeftNode(TreeNode leftNode) {
		this.leftNode = leftNode;
	}
	
	public void setRightNode(TreeNode rightNode) {
		this.rightNode = rightNode;
	}

	// 前序遍历
	public void frontShow() {
		System.out.print(value +" ");
		if (leftNode != null) {
			leftNode.frontShow();
		}
		if (rightNode != null) {
			rightNode.frontShow();
		}
	}

	// 中序遍历
	public void midShow() {
		if (leftNode != null) {
			leftNode.midShow();
		}
		System.out.print(value +" ");
		if (rightNode != null) {
			rightNode.midShow();
		}
	}
	
	// 后序遍历
	public void afterShow() {
		if (leftNode != null) {
			leftNode.afterShow();
		}
		if (rightNode != null) {
			rightNode.afterShow();
		}
		System.out.print(value +" ");
	}

	// 节点的前序查找
	public TreeNode frontSearch(int i) {
		TreeNode target = null;
		if (i == this.value) {
			return this;
		} else {
			if (leftNode != null) {
				target = leftNode.frontSearch(i);
			}
			if (target != null) {
				return target;
			}
			if (rightNode != null) {
				target = rightNode.frontSearch(i);
			}
		}
		return target;
	}
	
	// 删除子节点
	public void delete(int i) {
		/**
		 * 先查找左子节点，如果不存在，继续查找右子节点
		 * 如果还是不存在则继续递归查找左右子节点
		 */
		TreeNode parent = this;
		// 查看左节点
		if (parent.leftNode != null && parent.leftNode.value == i) {
			parent.leftNode = null;
			return;
		}
		// 查看右节点
		if (parent.rightNode != null && parent.rightNode.value == i) {
			parent.rightNode = null;
			return;
		}
		
		parent = leftNode;
		// 递归查找并删除左节点
		if (parent != null) {
			parent.delete(i);
		}
		
		// 递归查找并删除右节点
		parent = rightNode;
		if (parent != null) {
			parent.delete(i);
		}
	}
}
