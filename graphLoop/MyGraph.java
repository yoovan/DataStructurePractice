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
	 * �����ڽӾ���
	 * @param v1 ����1���±�
	 * @param v2 ����2���±�
	 */
	public void insertEdge(int v1, int v2) {
		if (v1 > vertexList.size() | v2 > vertexList.size()) {
			System.out.println("�����±�Խ�硣����");
			return;
		}
		adjMatrix[v1][v2] = 1;
	}
	
	public void showMatrix() {
		System.out.println("�ڽӾ���");
		System.out.println("  A  B  C  D  E  F");
		char col = 'A';
		for (int[] item : adjMatrix) {
			System.out.println(col + Arrays.toString(item));
			col++;
			
		}
	}
	
	public void showVertexList() {
		System.out.println("ͼ�Ķ��㣺");
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
	 * �����������
	 * @param startVex ��ʼ����
	 */
	public void dfs(int startVex) {
		/**
		 * ˼·������ʼ����ѹ��ջ�У�ÿ��ѭ���ж�ջ�е�Ԫ���Ƿ�Ϊ��
		 * ���ջ��Ԫ�ؿ��ˣ�˵��ͼ�����еĵ㶼�Ѿ������ʹ��ˣ�ѭ������
		 * ���ջ�л���Ԫ�أ���ȡ��ջ����Ԫ��
		 * �жϸö����Ƿ��Ѿ������ʹ���
		 * ���û�����ʣ���������Ϊ�ѷ��ʣ������
		 * Ȼ������ڽӾ�������������ڽӵĶ��㣬���ж϶����Ƿ񱻷��ʹ�
		 * ������ڽӵĶ���δ�����ʹ�������ѹ��ջ��
		 */
		// ��ʼ��ջ
		MyStack stack = new MyStack(); 
		// ���Ƚ���ʼ����ѹ��ջ��
		stack.push(startVex); 
		// ��ջ������±�
		int index = -1;
		while(!stack.isEmpty()) {
			// ȡ��ջ��Ԫ��
			index = stack.pop(); 
			// �жϸö����Ƿ��Ѿ������ʹ���
			if (!visited[index]) {
				// �����ѷ���
				visited[index] = true;
				System.out.print(vertexList.get(index).getName() + " ");
				// ���ڽӾ����в������ڽӲ�δ�����ʵĶ���
				for (int j = 0; j < this.getSize(); j++) {
					if (adjMatrix[index][j] == 1 && !visited[j]) {
						// ѹ��ջ��
						stack.push(j);
					}
				}
			}
		}
		System.out.println();
	}
	
	/**
	 * �����������
	 * @param startVex ��������ʼ����
	 */
	public void bfs(int startVex) {
		/**
		 * ˼·���Ƚ���������ʼ��������У�Ȼ��ѭ���ж϶����Ƿ�Ϊ�գ�����ʱ�˳�ѭ��
		 * ���в�Ϊ��ʱ�������׶�������У��ж���������Ƿ��Ѿ����ʹ�
		 * ������׶���δ�����ʣ��������ѱ����ʣ�����ӡ���
		 * ���ڽӾ����ڲ����뵱ǰ�������ڽӵĶ��㣬���жϸö����Ƿ�δ�����ʹ�
		 * ����ҵ�������㣬���������
		 */
		MyQuene quene = new MyQuene(); // ��ʼ��һ������
		quene.push(startVex); // ����ʼ���������
		int index = -1;
		while (!quene.isEmpty()) {
			index = quene.pop(); // �����׶��������
			if (!visited[index]) {
				visited[index] = true; // �����������
				System.out.print(vertexList.get(index).getName() + " ");
				// �����붥�����ڽӲ���δ�����ʵĶ���
				for (int i = 0; i < this.getSize(); i++) {
					if (adjMatrix[index][i] == 1 && !visited[i]) {
						quene.push(i); // �����
					}
				}
			}
		}
		System.out.println();
	}
	
	/**
	 * ʹ�õݹ�ʵ��������ȱ���
	 * @param startVex
	 */
	private void recursiveDFS(int startVex) {
		visited[startVex] = true; // ���ʵ�ǰ����
		System.out.print(vertexList.get(startVex).getName() + " ");
		// ������֮���ڽӵ���������
		for (int j = 0; j < this.getSize(); j++) {
			if (adjMatrix[startVex][j] == 1 && !visited[j]) {
				recursiveDFS(j); // �ݹ����
			}
		}
	}
	
	/**
	 * �ڽӾ���ĵݹ������������
	 */
	public void matrixRecursiveDFS() {
		// ���������б� 
		for (int i = 0; i < this.getSize(); i++) {
			// ���δ�����ʹ�����еݹ����
			if (!visited[i]) {
				this.recursiveDFS(i);
			}
		}
	}
}
