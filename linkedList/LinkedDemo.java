package com.linkedList;

import com.linkedList.Node;

public class LinkedDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		node1.append(node2).append(node3);
//		System.out.println(node1.getData());
//		System.out.println(node1.next().getData());
//		System.out.println(node1.next().next().next().getData());
		node1.show();
//		node1.next().removeNext();
//		node1.show();
		Node node4 = new Node(4);
		node1.next().next().after(node4);
		node1.show();
		
	}

}
