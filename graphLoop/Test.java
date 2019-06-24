package com.graph;

public class Test {

	public static void main(String[] args) {
//		MyGraph graph = new MyGraph(6);
//		graph.initGraph();
////		graph.showMatrix();
////		System.out.print("深度优先遍历：");
////		graph.dfs(0);
////		System.out.println("广度优先遍历：");
////		graph.bfs(0);
//		graph.matrixRecursiveDFS();
		
		MyGraph2 graph = new MyGraph2();
		graph.initGraph();
//		System.out.println(graph.toString());
		/**
		 * MyGraph2 
		 * [adjList=[
		 * Node [data=A, visited=false, firstEdge=Edge 
		 * [index=2, next=Edge 
		 * [index=1, next=null]]], 
		 * Node [data=B, visited=false, firstEdge=Edge 
		 * [index=3, next=Edge 
		 * [index=2, next=Edge 
		 * [index=0, next=null]]]], 
		 * Node [data=C, visited=false, firstEdge=Edge 
		 * [index=4, next=Edge 
		 * [index=3, next=Edge 
		 * [index=1, next=Edge 
		 * [index=0, next=null]]]]], 
		 * Node [data=D, visited=false, firstEdge=Edge 
		 * [index=5, next=Edge 
		 * [index=4, next=Edge 
		 * [index=2, next=Edge 
		 * [index=1, next=null]]]]], 
		 * Node [data=E, visited=false, firstEdge=Edge 
		 * [index=3, next=Edge 
		 * [index=2, next=null]]], 
		 * Node [data=F, visited=false, firstEdge=Edge 
		 * [index=5, next=Edge 
		 * [index=1, next=null]]]]]

		 */
//		graph.dfs(2);
		graph.listRecursiveDFS();
	}

}
