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
		this.initMatrix(); // ��ʼ���ڽӾ���
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
	 * ʹ��Integer.MAX_VALUE��ʼ���ڽӾ���,�����ʼ��Ϊ0
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
	 * ���붥��
	 * @param v
	 */
	public void insertVertex(Vertex v) {
		vertexList.add(v);
	}
	
	/**
	 * ��ӱ�
	 * @param i ��ʼ������±�
	 * @param j Ŀ�궥����±�
	 * @param weight Ȩ��
	 */
	public void insertEdge(int i, int j, int weight) {
		if (i > this.size || j > this.size) {
			System.out.println("ָ���±�Խ��...");
			return;
		}
		adjMatrix[i][j]=weight;
		edgeNum++;
	}
	
	/**
	 * ��ʼ��ͼ���������
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
		// ����ͼֻ�洢�˱ߵ�һ�룬��Ҫ����б�Խ���Ϊ���ĶԳƸ���
		this.completeMatrix(); 
	}
	
	/**
	 * ����ͼ��ֻ���һ�Σ���Ҫ�������ԶԽ��߶ԳƸ���
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
	 * ʹ�õ���ʵ�ֵϽ�˹�����㷨�����·��
	 * @param startVex ��ʼ����
	 * @param endVex �յ�
	 */
	public void dijkstra(int startVex, int endVex) {
		int[] dist = new int[size]; // �����������ʼ����ľ���
		int[] parent = new int[size]; // �洢�������һ�����㣬��������һ������Ϊ-1
		int min, k = 0; // min: ÿ��ѭ������С���� k:��Ӧ��С������±�
		// ʹ����ʼ�����е��ڽӾ������ݳ�ʼ������
		for (int i = 0; i < size; i++) {
			dist[i] = this.adjMatrix[startVex][i];
		}
		dist[startVex] = 0; // ��ʼ����ľ�����0
		visited[startVex] = true; // �����ѷ���
		parent[startVex] = -1;
		// ÿ������ֱ�ȥ�������ڽӵĶ���
		for (int i = 1;i < size; i ++) {
			// ���ñȽϵ���Сֵ
			min = Integer.MAX_VALUE;
			// �����뵱ǰ�������ڽӣ�Ȩֵ��С���һ�δ�����ʹ��Ķ���
			for (int j = 0; j < size; j++) {
				if (!visited[j] && dist[j] < min) {
					k = j;
					min = dist[j];
				}
			}
			// �ҵ�������Ժ������ѷ���
			visited[k] = true;
			for (int j = 0; j < size; j++) {
				// δ���ʹ� && ���Ǹö��� && ���Ƿ��ڽӵ� && ����һ��Ȩֵ���Ѵ��ڵ�ȨֵС
				if (!visited[j] && this.adjMatrix[k][j] != 0 && this.adjMatrix[k][j] != Integer.MAX_VALUE && (min + this.adjMatrix[k][j]) < dist[j]) {
					dist[j] = min + this.adjMatrix[k][j]; // Ȩֵ�滻
					parent[j] = k; // �����ö������һ������
				}
			}
		}
		// ѭ�����·����Ȩ��
		int target = endVex;
		while (target != 0) {
			System.out.print(vertexList.get(target).getName() + "<-");
			target = parent[target];
		}
		System.out.println(vertexList.get(startVex).getName() + " path length: " + dist[endVex]);
	}
}
