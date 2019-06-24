package com.tree;

import com.tree.BinaryTree;
import com.tree.TreeNode;

public class TestBinaryTree {

	public static void main(String[] args) {
		// ����������
		BinaryTree binTree = new BinaryTree();
		// �������ڵ�
		TreeNode root = new TreeNode(1);
		binTree.setRoot(root);
		// �������ڵ�������ӽڵ�
		TreeNode rootLeft = new TreeNode(2);
		TreeNode rootRight = new TreeNode(3);
		root.setLeftNode(rootLeft);
		root.setRightNode(rootRight);
		TreeNode node1 = new TreeNode(4);
		TreeNode node2 = new TreeNode(5);
		rootLeft.setLeftNode(node1);
		rootLeft.setRightNode(node2);
		TreeNode node3 = new TreeNode(6);
		TreeNode node4 = new TreeNode(7);
		rootRight.setLeftNode(node3);
		rootRight.setRightNode(node4);
		// ǰ�����
		System.out.print("ǰ�������");
		binTree.frontShow();
		System.out.println();
		System.out.print("���������");
		binTree.midShow();
		System.out.println();
		System.out.print("���������");
		binTree.afterShow();
		System.out.println();
		System.out.println("==============================");
		TreeNode result = binTree.frontSearch(7);
		System.out.println(result == node4);
		System.out.println("==============================");
		binTree.delete(3);
		binTree.afterShow();
	}

}
