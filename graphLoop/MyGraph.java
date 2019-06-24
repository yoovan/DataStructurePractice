package com.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class MyGraph {

	private ArrayList<Vertex> vertexList;
	private int[][] adjMatrix;
	private boolean[] visited;
	private int size;
	
	public MyGraph(int size) {
		vertexList = new ArrayList<>();
		adjMatrix = new int[size][size];
		visited = new boolean[size];
		this.size = size;
	}
	
	public void initGraph() {
		Vertex v1 = new Vertex("A");
		Vertex v2 = new Vertex("B");
		Vertex v3 = new Vertex("C");
		Vertex v4 = new Vertex("D");
		Vertex v5 = new Vertex("E");
		Vertex v6 = new Vertex("F");
		this.insertVertex(v1);
		this.insertVertex(v2);
		this.insertVertex(v3);
		this.insertVertex(v4);
		this.insertVertex(v5);
		this.insertVertex(v6);
		this.insertEdge(0, 1);
		this.insertEdge(0, 2);
		this.insertEdge(1, 0);
		this.insertEdge(1, 2);
		this.insertEdge(1, 3);
		this.insertEdge(2, 0);
		this.insertEdge(2, 1);
		this.insertEdge(2, 3);
		this.insertEdge(2, 4);
		this.insertEdge(3, 1);
		this.insertEdge(3, 2);
		this.insertEdge(3, 4);
		this.insertEdge(3, 5);
		this.insertEdge(4, 2);
		this.insertEdge(4, 3);
		this.insertEdge(5, 3);
	}
	
	public void insertVertex(Vertex v) {
		vertexList.add(vertexList.size(), v);
	}
	
	/**
	 * 创建邻接矩阵
	 * @param v1 顶点1的下标
	 * @param v2 顶点2的下标
	 */
	public void insertEdge(int v1, int v2) {
		if (v1 > vertexList.size() | v2 > vertexList.size()) {
			System.out.println("数组下标越界。。。");
			return;
		}
		adjMatrix[v1][v2] = 1;
	}
	
	public void showMatrix() {
		System.out.println("邻接矩阵：");
		System.out.println("  A  B  C  D  E  F");
		char col = 'A';
		for (int[] item : adjMatrix) {
			System.out.println(col + Arrays.toString(item));
			col++;
			
		}
	}
	
	public void showVertexList() {
		System.out.println("图的顶点：");
		System.out.println(vertexList.toString());
	}

	public ArrayList<Vertex> getVertexList() {
		return vertexList;
	}

	public int[][] getAdjMatrix() {
		return adjMatrix;
	}

	public boolean[] getVisited() {
		return visited;
	}

	public int getSize() {
		return size;
	}
	
	/**
	 * 深度优先搜索
	 * @param startVex 起始顶点
	 */
	public void dfs(int startVex) {
		/**
		 * 思路：将起始点先压入栈中，每次循环判断栈中的元素是否为空
		 * 如果栈中元素空了，说明图中所有的点都已经被访问过了，循环结束
		 * 如果栈中还有元素，则取出栈顶的元素
		 * 判断该顶点是否已经被访问过了
		 * 如果没被访问，则将其设置为已访问，并输出
		 * 然后根据邻接矩阵查找与它相邻接的顶点，并判断顶点是否被访问过
		 * 如果相邻接的顶点未被访问过，则将其压入栈中
		 */
		// 初始化栈
		MyStack stack = new MyStack(); 
		// 首先将起始顶点压入栈中
		stack.push(startVex); 
		// 出栈顶点的下标
		int index = -1;
		while(!stack.isEmpty()) {
			// 取出栈顶元素
			index = stack.pop(); 
			// 判断该顶点是否已经被访问过了
			if (!visited[index]) {
				// 设置已访问
				visited[index] = true;
				System.out.print(vertexList.get(index).getName() + " ");
				// 在邻接矩阵中查找相邻接并未被访问的顶点
				for (int j = 0; j < this.getSize(); j++) {
					if (adjMatrix[index][j] == 1 && !visited[j]) {
						// 压入栈中
						stack.push(j);
					}
				}
			}
		}
		System.out.println();
	}
	
	/**
	 * 广度优先搜索
	 * @param startVex 搜索的起始顶点
	 */
	public void bfs(int startVex) {
		/**
		 * 思路：先将搜索的起始顶点入队列，然后循环判断队列是否为空，当空时退出循环
		 * 队列不为空时：将队首顶点出队列，判断这个顶点是否已经访问过
		 * 如果队首顶点未被访问，则设置已被访问，并打印输出
		 * 在邻接矩阵在查找与当前顶点相邻接的顶点，并判断该定点是否未被访问过
		 * 如果找到这个顶点，则将其入队列
		 */
		MyQuene quene = new MyQuene(); // 初始化一个队列
		quene.push(startVex); // 将起始顶点入队列
		int index = -1;
		while (!quene.isEmpty()) {
			index = quene.pop(); // 将队首顶点出队列
			if (!visited[index]) {
				visited[index] = true; // 访问这个顶点
				System.out.print(vertexList.get(index).getName() + " ");
				// 查找与顶点相邻接并且未被访问的顶点
				for (int i = 0; i < this.getSize(); i++) {
					if (adjMatrix[index][i] == 1 && !visited[i]) {
						quene.push(i); // 入队列
					}
				}
			}
		}
		System.out.println();
	}
	
	/**
	 * 使用递归实现深度优先遍历
	 * @param startVex
	 */
	private void recursiveDFS(int startVex) {
		visited[startVex] = true; // 访问当前顶点
		System.out.print(vertexList.get(startVex).getName() + " ");
		// 查找与之相邻接的其他顶点
		for (int j = 0; j < this.getSize(); j++) {
			if (adjMatrix[startVex][j] == 1 && !visited[j]) {
				recursiveDFS(j); // 递归查找
			}
		}
	}
	
	/**
	 * 邻接矩阵的递归深度优先搜索
	 */
	public void matrixRecursiveDFS() {
		// 遍历顶点列表 
		for (int i = 0; i < this.getSize(); i++) {
			// 如果未被访问过则进行递归查找
			if (!visited[i]) {
				this.recursiveDFS(i);
			}
		}
	}
}
