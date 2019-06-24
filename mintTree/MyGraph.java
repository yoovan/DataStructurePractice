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
	 * ʹ��65535��ʼ���ڽӾ���,�����ʼ��Ϊ0
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
			System.out.println("ָ���±�Խ��...");
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
	 * ����ķ�㷨����С������
	 */
	public void prim() {
		// �洢������±꣬����±��ӦlowCost��Ȩֵ
		int[] adjvex = new int[this.size];
		/* �洢Ȩֵ����ʼ��ʱ������ʼ������0���������������
		 * ��ֵΪ0ʱ��������±��Ӧ�Ķ����Ѿ����������Ķ�����
		 */
		int[] lowCost = new int[this.size];
		// �����ܺ�
		int sum = 0;
		adjvex[0] = 0; // ��ʼ�����±�Ϊ0
		lowCost[0] = 0; // ��ʼ�����ȨֵΪ0
		// ��ʼ������
		for (int i = 0; i < this.size; i++) {
			lowCost[i] = this.adjMatrix[0][i];
			adjvex[i] = 0;
		}
		// ��С���������ɹ���
		for (int i = 1; i < this.size; i++) {
			// ��������Ϊ���ֵ
			int min = Integer.MAX_VALUE;
			// j���ڶ���ѭ����k��ȡ��Сֵ���±�
			int j = 1, k = 0;
			while (j < this.size) {
				// Ѱ�Ҹö������ڽӵ�Ȩֵ��С�ı�,����¼
				if (lowCost[j] != 0 && lowCost[j] < min) {
					min = lowCost[j];
					k = j;
				}
				j++;
			}
			sum += min;
			// ��ӡѡ������������±꣬��һ����
			System.out.println("(" + adjvex[k] + "," + k + ")");
			lowCost[k] = 0; // ��ʾ���������
			// Ϊ��һ��ѭ��׼������
			for (j = 1; j < this.size; j++) {
				// ���ҵ��Ķ���Ϊ��ʼ���㣬�������²���
				if (lowCost[j] != 0 && adjMatrix[k][j] < lowCost[j]) {
					lowCost[j] = adjMatrix[k][j];
					adjvex[j] = k;
				}
			}
		}
		System.out.println("total cost: " + sum);
	}
	
	/**
	 * ʹ��Kruskal�㷨����С������
	 */
	public void kruskal() {
		// ���ڽӾ���ת���ɱ߼�����
		Edge[] edges = this.transMatrixToEdge();
		// �洢����Ԫ�ص���һ������
		int[] parent = new int[size];
		int sum = 0;
		for (int i = 0; i < edges.length; i++) {
			// ʹ�ò��鼯�����Ƿ���ڻ�
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
	 * �ڽӾ���ת���ɱ߼�����
	 */
	private Edge[] transMatrixToEdge() {
		Edge[] edges = new Edge[this.edgeNum];
		int k = 0;
		// ��������б�Խ���Ϊ�ֽ磬ֻ��������һ���Ԫ��
		for (int i = 0; i < this.size-1; i++) {
			for (int j = i + 1; j < this.size; j++) {
				if (this.adjMatrix[i][j] != 0 && this.adjMatrix[i][j] != Integer.MAX_VALUE) {
					Edge edge = new Edge(i, j, adjMatrix[i][j]);
					edges[k] = edge;
					k++;
				}
			}
		}
		// ����Ȩ������
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
	 * ���Ҷ����±�Ϊi�ĸ�����
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
	 * ���鼯�����Ƿ���ڻ�
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
