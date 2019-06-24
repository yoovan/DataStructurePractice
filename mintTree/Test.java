package com.mintTree;

public class Test {

	public static void main(String[] args) {
		MyGraph graph = new MyGraph(9);
		graph.initGraph();
//		graph.prim();
		graph.kruskal();
//		graph.transMatrixToEdge();
//		graph.showMatrix();
	}

}
