package com.linkedList;

import com.linkedList.DoubleLoopNode;

public class DoubleListDemo {

	public static void main(String[] args) {
		DoubleLoopNode n1 = new DoubleLoopNode(1);
		DoubleLoopNode n2 = new DoubleLoopNode(2);
		DoubleLoopNode n3 = new DoubleLoopNode(3);
		n1.after(n2);
		n2.after(n3);
		System.out.println(n1.pre().getData());
		System.out.println(n1.getData());
		System.out.println(n3.next().getData());
	}

}
