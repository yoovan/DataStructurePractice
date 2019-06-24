package com.mintTree;

import java.util.ArrayList;
import java.util.Arrays;

public class MyGraph {
	private ArrayList<Vertex> vertexList;
	private int[][] adjMatrix;
	private int size;
	private int edgeNum;
	
	public MyGraph(int size) {
		this.size = size;
		vertexList = new ArrayList<Vertex>();
		adjMatrix = new int[size][size];
		this.initMatrix();
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
	 * 使用65535初始化邻接矩阵,自身初始化为0
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
	
	public void insertVertex(Vertex v) {
		vertexList.add(v);
	}
	
	public void insertEdge(int i, int j, int weight) {
		if (i > this.size || j > this.size) {
			System.out.println("指定下标越界...");
			return;
		}
		adjMatrix[i][j]=weight;
		edgeNum++;
	}
	
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
	 * 普里姆算法求最小生成树
	 */
	public void prim() {
		// 存储顶点的下标，这个下标对应lowCost的权值
		int[] adjvex = new int[this.size];
		/* 存储权值，初始化时除了起始顶点是0，其他都是无穷大
		 * 当值为0时，代表该下标对应的顶点已经是生成树的顶点了
		 */
		int[] lowCost = new int[this.size];
		// 计算总耗
		int sum = 0;
		adjvex[0] = 0; // 起始顶点下标为0
		lowCost[0] = 0; // 起始顶点的权值为0
		// 初始化数组
		for (int i = 0; i < this.size; i++) {
			lowCost[i] = this.adjMatrix[0][i];
			adjvex[i] = 0;
		}
		// 最小生成树构成过程
		for (int i = 1; i < this.size; i++) {
			// 以无穷作为最大值
			int min = Integer.MAX_VALUE;
			// j用于顶点循环，k存取最小值的下标
			int j = 1, k = 0;
			while (j < this.size) {
				// 寻找该顶点相邻接的权值最小的边,并记录
				if (lowCost[j] != 0 && lowCost[j] < min) {
					min = lowCost[j];
					k = j;
				}
				j++;
			}
			sum += min;
			// 打印选择的两个顶点下标，即一条边
			System.out.println("(" + adjvex[k] + "," + k + ")");
			lowCost[k] = 0; // 表示顶点已完成
			// 为下一次循环准备数据
			for (j = 1; j < this.size; j++) {
				// 以找到的顶点为起始顶点，继续向下查找
				if (lowCost[j] != 0 && adjMatrix[k][j] < lowCost[j]) {
					lowCost[j] = adjMatrix[k][j];
					adjvex[j] = k;
				}
			}
		}
		System.out.println("total cost: " + sum);
	}
	
	/**
	 * 使用Kruskal算法求最小生成树
	 */
	public void kruskal() {
		// 将邻接矩阵转换成边集数组
		Edge[] edges = this.transMatrixToEdge();
		// 存储访问元素的上一个顶点
		int[] parent = new int[size];
		int sum = 0;
		for (int i = 0; i < edges.length; i++) {
			// 使用并查集查找是否存在环
			boolean result = hasCycle(parent, edges[i].getBegin(), edges[i].getEnd());
			if (result) {
				System.out.println("Cycle detected =>" + "(" + edges[i].getBegin() + ","+ edges[i].getEnd() + ") ");
			} else {
				sum += edges[i].getWeight();
				System.out.println("(" + edges[i].getBegin() + ","+ edges[i].getEnd() + ") " + edges[i].getWeight());
			}
		}
		System.out.println("total cost: " + sum);
	}
	
	/**
	 * 邻接矩阵转换成边集数组
	 */
	private Edge[] transMatrixToEdge() {
		Edge[] edges = new Edge[this.edgeNum];
		int k = 0;
		// 以数组左斜对角线为分界，只遍历其中一半的元素
		for (int i = 0; i < this.size-1; i++) {
			for (int j = i + 1; j < this.size; j++) {
				if (this.adjMatrix[i][j] != 0 && this.adjMatrix[i][j] != Integer.MAX_VALUE) {
					Edge edge = new Edge(i, j, adjMatrix[i][j]);
					edges[k] = edge;
					k++;
				}
			}
		}
		// 根据权重排序
		for (int i = 0; i < edges.length - 1; i++) {
			for (int j = i + 1; j < edges.length; j++) {
				if (edges[i].getWeight() > edges[j].getWeight()) {
					Edge temp = edges[i];
					edges[i] = edges[j];
					edges[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(edges));
		return edges;
	}
	
	/**
	 * 查找顶点下标为i的根顶点
	 * @param parent
	 * @param i
	 * @return
	 */
	private int findRoot(int[] parent, int i) {
		while(parent[i] > 0) {
			i = parent[i];
		}
		return i;
	}
	
	/**
	 * 并查集查找是否存在环
	 * @param parent
	 * @param n
	 * @param m
	 * @return
	 */
	private boolean hasCycle(int[] parent, int n, int m) {
		n = findRoot(parent, n);
		m = findRoot(parent, m);
		if (n == m) {
			return true;
		} else {
			parent[n] = m;
			return false;
		}
	}
}
