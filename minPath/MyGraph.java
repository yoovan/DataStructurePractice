package com.minPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

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
		/*
		 * this.insertEdge(0, 1, 1); this.insertEdge(0, 2, 5); this.insertEdge(1, 2, 3);
		 * this.insertEdge(1, 3, 7); this.insertEdge(1, 4, 5); this.insertEdge(2, 4, 1);
		 * this.insertEdge(2, 5, 7); this.insertEdge(3, 4, 2); this.insertEdge(3, 6, 3);
		 * this.insertEdge(4, 5, 3); this.insertEdge(4, 6, 6); this.insertEdge(4, 7, 9);
		 * this.insertEdge(5, 7, 5); this.insertEdge(6, 7, 2); this.insertEdge(6, 8, 7);
		 * this.insertEdge(7, 8, 4);
		 */
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
	 * 使用优先队列实现迪杰斯特拉算法
	 * @param startVex
	 * @param endVex
	 */
	public void dijkstra(int startVex, int endVex) {
		boolean[] visited = new boolean[size]; // 存储元素是否已经被访问
		int[] dist = new int[size]; // 存储各个顶点距离起始顶点的最短距离
		// 使用起始顶点的邻接矩阵数据初始化数据
		for (int i = 0; i < size; i++) {
			dist[i] = this.adjMatrix[startVex][i];
		}
		int[] parent = new int[size]; // 存储该顶点的上一级顶点
		parent[startVex] = -1; // 起始顶点的上级顶点不存在，为-1
		// 初始化优先队列，设置比较的规则
		PriorityQueue<Vertex> minHeap = new PriorityQueue<Vertex>(size, new Comparator<Vertex>() {
			// 小堆排序
			@Override
			public int compare(Vertex o1, Vertex o2) {
				return o1.getWeight()-o2.getWeight();
			}
		});
		// 将起始顶点初始化并加入优先队列中
		Vertex v = vertexList.get(startVex);
		v.setWeight(0); // 起始顶点权重为0
		v.setIndex(startVex);
		minHeap.add(v);
		Vertex point = null; // 相当于指针
		// 当优先队列有值的时候，开始循环查找最短路径
		while (!minHeap.isEmpty()) {
			point = minHeap.poll(); // 取出队首元素,优先队列每次取出权值最小的顶点
			startVex = point.getIndex(); // 当前顶点的下标
			// 如果这个顶点存在并且还没有被访问过
			if (point != null && !visited[startVex]) {
				visited[startVex] = true; // 设置已访问
				// 获取所有于该顶点相邻接的点
				for (int i = 0; i < size; i++) {
					// 不是0，不是Integer.MAX_VALUE，不是已访问过的
					if (this.adjMatrix[startVex][i] != 0 && this.adjMatrix[startVex][i] != Integer.MAX_VALUE && !visited[i] ) {
						// 初始化要加入优先队列的顶点
						Vertex e = this.vertexList.get(i);
						e.setIndex(i);
						// 该顶点的权值应该是上一顶点距离起始顶点的权值加上该顶点距离上一顶点的权值
						e.setWeight(dist[startVex] + this.adjMatrix[startVex][i]);
						// 如果距离数组中，已经存在一个当前顶点距离起始顶点更小的权值，则不应该更换它
						if (dist[i] > e.getWeight()) {
							dist[i] = e.getWeight(); // 更换更近的权值
							parent[i] = startVex; // 权值更换，对应的上一级顶点也需要更换
						}
						minHeap.add(e); // 将顶点加入优先队列
					}
				}
			}
		}
		// 循环输出最短路径和对应的权值
		int target = endVex;
		while (parent[target] > -1) {
			System.out.print(vertexList.get(target).getName()+"<-");
			target = parent[target];
		}
		System.out.println(vertexList.get(target).getName());
		System.out.println("total cost: " + dist[endVex]);
	}
} 
