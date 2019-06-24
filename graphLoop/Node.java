package com.graph;

public class Node {
	private String data;
	private boolean visited;
	private Edge firstEdge;
	
	public Node(String data) {
		this.data = data;
	}
	public Node(String data, Edge edge) {
		this.data = data;
		this.firstEdge = edge;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public String getData() {
		return data;
	}
	
	public void setFirstEdge(Edge firstEdge) {
		this.firstEdge = firstEdge;
	}
	
	public Edge getFirstEdge() {
		return firstEdge;
	}
	
	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public boolean isVisited() {
		return visited;
	}
	@Override
	public String toString() {
		return "Node [data=" + data + ", visited=" + visited + ", firstEdge=" + firstEdge + "]";
	}

	
}
