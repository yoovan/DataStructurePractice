package com.tree;

import com.tree.ArrayBinaryTree;

public class TestArrayBinaryTree {

	public static void main(String[] args) {
		int[] data = new int[] {1,2,3,4,5,6,7};
		ArrayBinaryTree binTree = new ArrayBinaryTree(data);
		binTree.frontShow();
	}

}
