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

	// ǰ�����
	public void frontShow() {
		System.out.print(value +" ");
		if (leftNode != null) {
			leftNode.frontShow();
		}
		if (rightNode != null) {
			rightNode.frontShow();
		}
	}

	// �������
	public void midShow() {
		if (leftNode != null) {
			leftNode.midShow();
		}
		System.out.print(value +" ");
		if (rightNode != null) {
			rightNode.midShow();
		}
	}
	
	// �������
	public void afterShow() {
		if (leftNode != null) {
			leftNode.afterShow();
		}
		if (rightNode != null) {
			rightNode.afterShow();
		}
		System.out.print(value +" ");
	}

	// �ڵ��ǰ�����
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
	
	// ɾ���ӽڵ�
	public void delete(int i) {
		/**
		 * �Ȳ������ӽڵ㣬��������ڣ������������ӽڵ�
		 * ������ǲ�����������ݹ���������ӽڵ�
		 */
		TreeNode parent = this;
		// �鿴��ڵ�
		if (parent.leftNode != null && parent.leftNode.value == i) {
			parent.leftNode = null;
			return;
		}
		// �鿴�ҽڵ�
		if (parent.rightNode != null && parent.rightNode.value == i) {
			parent.rightNode = null;
			return;
		}
		
		parent = leftNode;
		// �ݹ���Ҳ�ɾ����ڵ�
		if (parent != null) {
			parent.delete(i);
		}
		
		// �ݹ���Ҳ�ɾ���ҽڵ�
		parent = rightNode;
		if (parent != null) {
			parent.delete(i);
		}
	}
}
