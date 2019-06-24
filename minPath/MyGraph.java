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
	 * ʹ�����ȶ���ʵ�ֵϽ�˹�����㷨
	 * @param startVex
	 * @param endVex
	 */
	public void dijkstra(int startVex, int endVex) {
		boolean[] visited = new boolean[size]; // �洢Ԫ���Ƿ��Ѿ�������
		int[] dist = new int[size]; // �洢�������������ʼ�������̾���
		// ʹ����ʼ������ڽӾ������ݳ�ʼ������
		for (int i = 0; i < size; i++) {
			dist[i] = this.adjMatrix[startVex][i];
		}
		int[] parent = new int[size]; // �洢�ö������һ������
		parent[startVex] = -1; // ��ʼ������ϼ����㲻���ڣ�Ϊ-1
		// ��ʼ�����ȶ��У����ñȽϵĹ���
		PriorityQueue<Vertex> minHeap = new PriorityQueue<Vertex>(size, new Comparator<Vertex>() {
			// С������
			@Override
			public int compare(Vertex o1, Vertex o2) {
				return o1.getWeight()-o2.getWeight();
			}
		});
		// ����ʼ�����ʼ�����������ȶ�����
		Vertex v = vertexList.get(startVex);
		v.setWeight(0); // ��ʼ����Ȩ��Ϊ0
		v.setIndex(startVex);
		minHeap.add(v);
		Vertex point = null; // �൱��ָ��
		// �����ȶ�����ֵ��ʱ�򣬿�ʼѭ���������·��
		while (!minHeap.isEmpty()) {
			point = minHeap.poll(); // ȡ������Ԫ��,���ȶ���ÿ��ȡ��Ȩֵ��С�Ķ���
			startVex = point.getIndex(); // ��ǰ������±�
			// ������������ڲ��һ�û�б����ʹ�
			if (point != null && !visited[startVex]) {
				visited[startVex] = true; // �����ѷ���
				// ��ȡ�����ڸö������ڽӵĵ�
				for (int i = 0; i < size; i++) {
					// ����0������Integer.MAX_VALUE�������ѷ��ʹ���
					if (this.adjMatrix[startVex][i] != 0 && this.adjMatrix[startVex][i] != Integer.MAX_VALUE && !visited[i] ) {
						// ��ʼ��Ҫ�������ȶ��еĶ���
						Vertex e = this.vertexList.get(i);
						e.setIndex(i);
						// �ö����ȨֵӦ������һ���������ʼ�����Ȩֵ���ϸö��������һ�����Ȩֵ
						e.setWeight(dist[startVex] + this.adjMatrix[startVex][i]);
						// ������������У��Ѿ�����һ����ǰ���������ʼ�����С��Ȩֵ����Ӧ�ø�����
						if (dist[i] > e.getWeight()) {
							dist[i] = e.getWeight(); // ����������Ȩֵ
							parent[i] = startVex; // Ȩֵ��������Ӧ����һ������Ҳ��Ҫ����
						}
						minHeap.add(e); // ������������ȶ���
					}
				}
			}
		}
		// ѭ��������·���Ͷ�Ӧ��Ȩֵ
		int target = endVex;
		while (parent[target] > -1) {
			System.out.print(vertexList.get(target).getName()+"<-");
			target = parent[target];
		}
		System.out.println(vertexList.get(target).getName());
		System.out.println("total cost: " + dist[endVex]);
	}
} 
