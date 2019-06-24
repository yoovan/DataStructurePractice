package com.mintTree;

public class Edge {
	private int begin;
	private int end;
	private int weight;
	public Edge(int begin, int end, int weight) {
		this.begin = begin;
		this.end = end;
		this.weight = weight;
	}
	
	public int getBegin() {
		return begin;
	}
	
	public int getEnd() {
		return end;
	}
	
	public int getWeight() {
		return weight;
	}
	
	@Override
	public String toString() {
		return "Edge [begin=" + begin + ", end=" + end + ", weight=" + weight + "]";
	}
	
	
}
