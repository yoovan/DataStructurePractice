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
	 * 初始化邻接表
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
	 * 基于邻接表的深度优先搜索
	 * @param startVex 搜索起始顶点
	 */
	public void dfs(int startVex) {
		// 初始化栈
		MyStack stack = new MyStack();
		// 将起始顶点压入栈中
		stack.push(startVex);
		// 用于循环遍历的引用（指针）
		Edge point = null;
		// 出栈顶点的下标
		int index = -1;
		while(!stack.isEmpty()) {
			// 弹出栈顶的顶点
			index = stack.pop();
			// 如果该顶点被访问过了就不再操作
			if (!adjList.get(index).isVisited()) {
				// 打印顶点信息
				System.out.print(adjList.get(index).getData() +" ");
				// 设置已被访问
				adjList.get(index).setVisited(true);
				// 获取当前顶点的第一条邻接边
				point = adjList.get(index).getFirstEdge();
			}
			// 当顶点有邻接顶点时
			while (point != null) {
				// 判断该邻接顶点是否已经被访问过了
				if (!adjList.get(point.getIndex()).isVisited()) {
					// 将未被访问过的邻接顶点压入栈中
					stack.push(point.getIndex());
				}
				// 指向与栈顶顶点相邻接的下一个顶点
				point = point.getNext();
			}
		}
	}
	
	/**
	 * 使用递归实现基于邻接表的深度优先搜索
	 * @param startVex
	 */
	private void recursiveDFS(int startVex) {
		Edge point = null;
		// 打印顶点信息
		System.out.print(adjList.get(startVex).getData() +" ");
		// 设置已被访问
		adjList.get(startVex).setVisited(true);
		// 获取当前顶点的第一条邻接边
		point = adjList.get(startVex).getFirstEdge();
		while (point != null) {
			// 判断该邻接顶点是否已经被访问过了
			if (!adjList.get(point.getIndex()).isVisited()) {
				// 继续向下查找
				recursiveDFS(point.getIndex());
			}
			// 指向与栈顶顶点相邻接的下一个顶点
			point = point.getNext();
		}
	}
	
	/**
	 * 基于邻接表的深度优先搜索-递归
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
