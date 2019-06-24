package com.graph;

import java.util.ArrayList;

public class MyGraph2 {
	ArrayList<Node> adjList;
	
	public MyGraph2() {
		adjList = new ArrayList<Node>();
	}
	
	public ArrayList<Node> getAdjList() {
		return adjList;
	}
	
	public int getSize() {
		return adjList.size();
	}
	
	/**
	 * ��ʼ���ڽӱ�
	 */
	public void initGraph() {
		 // A
		 Edge e0 = new Edge(1);
		 Edge e1 = new Edge(2, e0);
		 
		 // B
		 Edge e2 = new Edge(0);
		 Edge e3 = new Edge(2, e2);
		 Edge e4 = new Edge(3, e3);
		 
		 // C
		 Edge e6 = new Edge(1, e2);
		 Edge e7 = new Edge(3, e6);
		 Edge e8 = new Edge(4, e7);
		 
		 // D
		 Edge e9 = new Edge(1);
		 Edge e10 = new Edge(2, e9);
		 Edge e11 = new Edge(4, e10);
		 Edge e12 = new Edge(5, e11);
		 
		 // E
		 Edge e13 = new Edge(2);
		 Edge e14 = new Edge(3, e13);
		 
		 // F
		 Edge e15 = new Edge(5, e9);
		 Node n0 = new Node("A", e1);
		 Node n1 = new Node("B", e4);
		 Node n2 = new Node("C", e8);
		 Node n3 = new Node("D", e12);
		 Node n4 = new Node("E", e14);
		 Node n5 = new Node("F", e15);
		 adjList.add(n0);
		 adjList.add(n1);
		 adjList.add(n2);
		 adjList.add(n3);
		 adjList.add(n4);
		 adjList.add(n5);
	}
	
	/**
	 * �����ڽӱ�������������
	 * @param startVex ������ʼ����
	 */
	public void dfs(int startVex) {
		// ��ʼ��ջ
		MyStack stack = new MyStack();
		// ����ʼ����ѹ��ջ��
		stack.push(startVex);
		// ����ѭ�����������ã�ָ�룩
		Edge point = null;
		// ��ջ������±�
		int index = -1;
		while(!stack.isEmpty()) {
			// ����ջ���Ķ���
			index = stack.pop();
			// ����ö��㱻���ʹ��˾Ͳ��ٲ���
			if (!adjList.get(index).isVisited()) {
				// ��ӡ������Ϣ
				System.out.print(adjList.get(index).getData() +" ");
				// �����ѱ�����
				adjList.get(index).setVisited(true);
				// ��ȡ��ǰ����ĵ�һ���ڽӱ�
				point = adjList.get(index).getFirstEdge();
			}
			// ���������ڽӶ���ʱ
			while (point != null) {
				// �жϸ��ڽӶ����Ƿ��Ѿ������ʹ���
				if (!adjList.get(point.getIndex()).isVisited()) {
					// ��δ�����ʹ����ڽӶ���ѹ��ջ��
					stack.push(point.getIndex());
				}
				// ָ����ջ���������ڽӵ���һ������
				point = point.getNext();
			}
		}
	}
	
	/**
	 * ʹ�õݹ�ʵ�ֻ����ڽӱ�������������
	 * @param startVex
	 */
	private void recursiveDFS(int startVex) {
		Edge point = null;
		// ��ӡ������Ϣ
		System.out.print(adjList.get(startVex).getData() +" ");
		// �����ѱ�����
		adjList.get(startVex).setVisited(true);
		// ��ȡ��ǰ����ĵ�һ���ڽӱ�
		point = adjList.get(startVex).getFirstEdge();
		while (point != null) {
			// �жϸ��ڽӶ����Ƿ��Ѿ������ʹ���
			if (!adjList.get(point.getIndex()).isVisited()) {
				// �������²���
				recursiveDFS(point.getIndex());
			}
			// ָ����ջ���������ڽӵ���һ������
			point = point.getNext();
		}
	}
	
	/**
	 * �����ڽӱ�������������-�ݹ�
	 */
	public void listRecursiveDFS() {
		for (int i = 0; i < this.getSize(); i++) {
			if (!adjList.get(i).isVisited()) {
				recursiveDFS(i);
			}
		}
	}

	@Override
	public String toString() {
		return "MyGraph2 [adjList=" + adjList + "]";
	}
	
	
}
