
public class Main {
	public static void main(String[] args) {

		Graph graph = new Graph(7);

		graph.addEdge(new Edge(0, 1, 4));
		graph.addEdge(new Edge(0, 2, 3));
		graph.addEdge(new Edge(0, 3, 7));
		graph.addEdge(new Edge(0, 5, 9));

		graph.addEdge(new Edge(1, 3, 2));
		graph.addEdge(new Edge(1, 5, 4));

		graph.addEdge(new Edge(2, 3, 3));
		graph.addEdge(new Edge(2, 4, 5));
		graph.addEdge(new Edge(2, 6, 8));

		// graph.addEdge(new Edge(3, 4, 2));
		// graph.addEdge(new Edge(3, 5, 2));

		graph.addEdge(new Edge(4, 6, 2));
		graph.addEdge(new Edge(4, 5, 4));

		graph.addEdge(new Edge(5, 6, 4));

		int start = 0;
		// int end = 6;
		Dijkstry dd = new Dijkstry(graph, start);

		for (int end = 0; end < graph.getNumberOfVertices(); end++) {
			if (dd.hasPathTo(end)) {
				System.out.printf("%d do %d (suma: %d) || ", start, end, dd.getDistanceTo(end));
				if (dd.hasPathTo(end)) {
					for (Edge edge : dd.getPathTo(end)) {
						System.out.print(edge);

					}
				}
				System.out.println();
			}
		}
	}
}
