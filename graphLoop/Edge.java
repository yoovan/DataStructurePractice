package com.graph;

public class Edge {
	private int index;
	private Edge next;
	
	public Edge() {}
	
	public Edge(int index) {
		this.index = index;
	}
	
	public Edge(int index, Edge next) {
		this.index = index;
		this.next = next;
	}
	
	public void setNext(Edge next) {
		this.next = next;
	}
	
	public Edge getNext() {
		return next;
	}
	
	public int getIndex() {
		return index;
	}

	@Override
	public String toString() {
		return "Edge [index=" + index + ", next=" + next + "]";
	}
	
	
	
}
