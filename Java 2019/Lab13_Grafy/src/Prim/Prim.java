package Prim;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Prim {

	private boolean[] marked;
	// minimalna spoiwa drzewo
	private Queue<Edge> msd;
	// wszystkim z priorytetami po krawiedzi
	private Queue<Edge> priorityQueue;
	private long weight;

	public Prim(Graph graph) {
		marked = new boolean[graph.getNumberOfVertices()];
		msd = new LinkedList<Edge>();
		priorityQueue = new PriorityQueue<Edge>(graph.getNumberOfVertices());
		visit(graph, 0);
		while (!priorityQueue.isEmpty()) {
			Edge e = priorityQueue.poll();
			int v = e.getEitherVertex();
			int w = e.getOtherVertex(v);
			if (marked[v] && marked[w]) {
				continue;
			}
			msd.offer(e);
			weight += e.getWeight();

			if (!marked[v]) {
				visit(graph, v);
			}
			if (!marked[w]) {
				visit(graph, w);
			}
		}
	}

	public Iterable<Edge> edges() {
		return msd;
	}

	public long getWeight() {
		return weight;
	}

	private void visit(Graph graph, int v) {
		marked[v] = true;
		for (Edge edge : graph.getAdjacencyList(v)) {
			if (!marked[edge.getOtherVertex(v)]) {
				priorityQueue.offer(edge);
			}
		}
	}

}
