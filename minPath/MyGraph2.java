package com.minPath;

import java.util.ArrayList;
import java.util.Arrays;
import com.graph.Vertex;

public class MyGraph2 {
	
	private ArrayList<Vertex> vertexList;
	private int[][] adjMatrix;
	private boolean[] visited;
	private int size;
	private int edgeNum;

	public MyGraph2(int size) {
		this.vertexList = new ArrayList<Vertex>();
		adjMatrix = new int[size][size];
		this.size = size;
		this.initMatrix(); // 初始化邻接矩阵
	}
	
	public ArrayList<Vertex> getVertexList() {
		return vertexList;
	}
	
	public int getSize() {
		return size;
	}
	
	public int getEdgeNum() {
		return edgeNum;
	}
	
	public int[][] getAdjMatrix() {
		return adjMatrix;
	}
	
	/**
	 * 使用Integer.MAX_VALUE初始化邻接矩阵,自身初始化为0
	 */
	private void initMatrix() {
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				if (i == j) {
					adjMatrix[i][j] = 0;
				} else {
					adjMatrix[i][j] = Integer.MAX_VALUE;
				}
			}
		}
	}
	
	/**
	 * 插入顶点
	 * @param v
	 */
	public void insertVertex(Vertex v) {
		vertexList.add(v);
	}
	
	/**
	 * 添加边
	 * @param i 起始顶点的下标
	 * @param j 目标顶点的下标
	 * @param weight 权重
	 */
	public void insertEdge(int i, int j, int weight) {
		if (i > this.size || j > this.size) {
			System.out.println("指定下标越界...");
			return;
		}
		adjMatrix[i][j]=weight;
		edgeNum++;
	}
	
	/**
	 * 初始化图和相关数据
	 */
	public void initGraph() {
		Vertex v0 = new Vertex("v0");
		Vertex v1 = new Vertex("v1");
		Vertex v2 = new Vertex("v2");
		Vertex v3 = new Vertex("v3");
		Vertex v4 = new Vertex("v4");
		Vertex v5 = new Vertex("v5");
		Vertex v6 = new Vertex("v6");
		Vertex v7 = new Vertex("v7");
		Vertex v8 = new Vertex("v8");
		this.insertVertex(v0);
		this.insertVertex(v1);
		this.insertVertex(v2);
		this.insertVertex(v3);
		this.insertVertex(v4);
		this.insertVertex(v5);
		this.insertVertex(v6);
		this.insertVertex(v7);
		this.insertVertex(v8);
		this.insertEdge(0, 1, 10);
		this.insertEdge(0, 5, 11);
		this.insertEdge(1, 2, 18);
		this.insertEdge(1, 6, 16);
		this.insertEdge(1, 8, 12);
		this.insertEdge(2, 3, 22);
		this.insertEdge(2, 8, 8);
		this.insertEdge(3, 4, 20);
		this.insertEdge(3, 6, 24);
		this.insertEdge(3, 7, 16);
		this.insertEdge(3, 8, 21);
		this.insertEdge(4, 5, 26);
		this.insertEdge(4, 7, 7);
		this.insertEdge(5, 6, 17);
		this.insertEdge(6, 7, 19);
		/*
		 * this.insertEdge(0, 1, 1); this.insertEdge(0, 2, 5); this.insertEdge(1, 2, 3);
		 * this.insertEdge(1, 3, 7); this.insertEdge(1, 4, 5); this.insertEdge(2, 4, 1);
		 * this.insertEdge(2, 5, 7); this.insertEdge(3, 4, 2); this.insertEdge(3, 6, 3);
		 * this.insertEdge(4, 5, 3); this.insertEdge(4, 6, 6); this.insertEdge(4, 7, 9);
		 * this.insertEdge(5, 7, 5); this.insertEdge(6, 7, 2); this.insertEdge(6, 8, 7);
		 * this.insertEdge(7, 8, 4);
		 */
		// 无向图只存储了边的一半，需要以左斜对角线为中心对称复制
		this.completeMatrix(); 
	}
	
	/**
	 * 无向图边只添加一次，需要将数组以对角线对称复制
	 */
	private void completeMatrix() {
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				this.adjMatrix[j][i] = this.adjMatrix[i][j];
			}
		}
	}
	
	public void showGraph() {
		System.out.println(vertexList.toString());
	}
	
	public void showMatrix() {
		for (int[] item : adjMatrix) {
			System.out.println(Arrays.toString(item));
		}
	}
	
	/**
	 * 使用迭代实现迪杰斯特拉算法求最短路径
	 * @param startVex 起始顶点
	 * @param endVex 终点
	 */
	public void dijkstra(int startVex, int endVex) {
		int[] dist = new int[size]; // 各顶点距离起始顶点的距离
		int[] parent = new int[size]; // 存储顶点的上一级顶点，不存在上一级顶点为-1
		int min, k = 0; // min: 每次循环的最小距离 k:对应最小距离的下标
		// 使用起始顶点行的邻接矩阵数据初始化数组
		for (int i = 0; i < size; i++) {
			dist[i] = this.adjMatrix[startVex][i];
		}
		dist[startVex] = 0; // 起始顶点的距离是0
		visited[startVex] = true; // 设置已访问
		parent[startVex] = -1;
		// 每个顶点分别去查找相邻接的顶点
		for (int i = 1;i < size; i ++) {
			// 设置比较的最小值
			min = Integer.MAX_VALUE;
			// 查找与当前顶点相邻接，权值最小并且还未被访问过的顶点
			for (int j = 0; j < size; j++) {
				if (!visited[j] && dist[j] < min) {
					k = j;
					min = dist[j];
				}
			}
			// 找到这个点以后设置已访问
			visited[k] = true;
			for (int j = 0; j < size; j++) {
				// 未访问过 && 不是该顶点 && 不是非邻接点 && 存在一个权值比已存在的权值小
				if (!visited[j] && this.adjMatrix[k][j] != 0 && this.adjMatrix[k][j] != Integer.MAX_VALUE && (min + this.adjMatrix[k][j]) < dist[j]) {
					dist[j] = min + this.adjMatrix[k][j]; // 权值替换
					parent[j] = k; // 更换该顶点的上一级顶点
				}
			}
		}
		// 循环输出路径和权重
		int target = endVex;
		while (target != 0) {
			System.out.print(vertexList.get(target).getName() + "<-");
			target = parent[target];
		}
		System.out.println(vertexList.get(startVex).getName() + " path length: " + dist[endVex]);
	}
}
