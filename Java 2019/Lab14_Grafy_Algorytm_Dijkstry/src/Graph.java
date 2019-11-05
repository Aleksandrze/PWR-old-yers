import java.util.ArrayList;
import java.util.List;

public class Graph {

	private final int v;
	private int e;
	private List<Edge>[] list;

	@SuppressWarnings("unchecked")
	public Graph(int v) {
		this.v = v;
		this.e = 0;
		this.list = (List<Edge>[]) new List[v];
		for (int i = 0; i < v; i++) {
			list[i] = new ArrayList<Edge>();
		}
	}

	public int getNumberOfEdges() {
		return e;
	}

	public int getNumberOfVertices() {
		return v;
	}

	public void addEdge(Edge edge) {
		list[edge.from()].add(edge);
		e++;
	}

	public Iterable<Edge> list(int v) {
		return list[v];
	}
}
