package Prim;

import java.util.ArrayList;
import java.util.List;

public class Graph {

	private final int vallue;
	private int eedge;
	private List<Edge>[] adjacencyLists;

	@SuppressWarnings("unchecked")
	public Graph(int v) {
		this.vallue = v;
		this.eedge = 0;
		this.adjacencyLists = (List<Edge>[]) new List[v];
		for (int i = 0; i < v; i++) {
			adjacencyLists[i] = new ArrayList<Edge>();
		}
	}

	public int getNumberOfEdges() {
		return eedge;
	}

	public int getNumberOfVertices() {
		return vallue;
	}

	public void addEdge(Edge edge) {
		int v = edge.getEitherVertex();
		int w = edge.getOtherVertex(v);
		adjacencyLists[v].add(edge);
		adjacencyLists[w].add(edge);
		eedge++;
	}

	public Iterable<Edge> getAdjacencyList(int v) {
		return adjacencyLists[v];
	}
}
