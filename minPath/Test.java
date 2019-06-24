package com.minPath;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		MyGraph2 graph = new MyGraph2(9);
//		graph.initGraph();
////		graph.showMatrix();
//		graph.dijkstra(0,3);
		MyGraph graph = new MyGraph(9);
		graph.initGraph();
		graph.dijkstra(0, 7);
	}

}
