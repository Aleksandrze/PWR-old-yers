package BFS_DFS;

public class Main {

	public static void main(String[] args) {

		Graph graph = new Graph(6);

		graph.addEdge(0, 1);
		graph.addEdge(0, 2);

		graph.addEdge(1, 4);

		graph.addEdge(2, 3);
		graph.addEdge(2, 5);

		graph.addEdge(3, 0);

		graph.addEdge(4, 3);

		System.out.println("Graf : " + graph);

		System.out.println("\nDFS Nieskerowane ");
// droga z 1 do 5
		DFSPaths dfs1 = new DFSPaths(graph, 0);
		for (int it : dfs1.getPathTo(5)) {
			System.out.print(it + " ");
		}
		System.out.println("\n----------");

// droga z 5 do 1
		DFSPaths dfs2 = new DFSPaths(graph, 3);
		for (int it : dfs2.getPathTo(0)) {
			System.out.print(it + " ");
		}
//============================BFS==================================
		System.out.println("\n\nBFS");
// droga z 1 do 5
		BFSPaths bfs1 = new BFSPaths(graph, 0);
		for (int it : bfs1.getPathTo(5)) {
			System.out.print(it + " ");
		}
		System.out.println("\n----------");

// droga z 5 do 1
		BFSPaths bfs2 = new BFSPaths(graph, 3);
		for (int it : bfs2.getPathTo(0)) {
			System.out.print(it + " ");
		}
	}
	
}