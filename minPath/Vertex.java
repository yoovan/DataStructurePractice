package com.minPath;

public class Vertex {
	
	private String name;
	
	private int weight; // ��ǰ���㵽��ʼ�����Ȩֵ
	
	private int index; // ��ǰ������±�

	public Vertex(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public void setIndex(int index) {
		this.index = index;
	}
	
	public int getIndex() {
		return index;
	}

	@Override
	public String toString() {
		return "Vertex [name=" + name + ", weight=" + weight + ", index=" + index + "]";
	}

	
}
