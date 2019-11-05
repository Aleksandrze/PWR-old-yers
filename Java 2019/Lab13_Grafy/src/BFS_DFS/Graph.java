package BFS_DFS;

import java.util.ArrayList;
import java.util.List;

public class Graph {

	// liczba krawedzi
	public int e;
	// liczba wierzcholkow
	public int v;
	// tablica list sasiedztwa danego wierzcholka
	public List<Integer>[] adjacencyList;

	@SuppressWarnings("unchecked")
	public Graph(int v) {
		this.v = v;
		this.e = 0;
		adjacencyList = (List<Integer>[]) new List[v];
		for (int i = 0; i < v; i++) {
			adjacencyList[i] = new ArrayList<Integer>();
		}
	}

	public void addEdge(int v, int w) {
		adjacencyList[v].add(w);
		adjacencyList[w].add(v);
		e++;
	}

	public int getNumberOfEdges() {
		return e;
	}

	public int getNumberOfVertices() {
		return v;
	}

	public Iterable<Integer> getAdjacencyList(int v) {
		return adjacencyList[v];
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		String newLine = System.getProperty("line.separator");
		s.append("wierzcholki: ").append(v).append("; krawedzie: ").append(e).append(newLine);
		for (int i = 0; i < v; i++) {
			s.append(i).append(": ");
			for (int w : adjacencyList[i]) {
				s.append(w).append(" ");
			}
			s.append(newLine);
		}
		return s.toString();
	}

}
