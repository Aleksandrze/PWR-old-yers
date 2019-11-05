import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Dijkstry {

	private Edge[] edgeTo;
	private Long[] distanceTo;
	// priorytet po dlogosci krawiedzi
	private Queue<DistanceToEdge> priorityQueue;

	public Dijkstry(Graph graph, int source) {
		edgeTo = new Edge[graph.getNumberOfVertices()];
		distanceTo = new Long[graph.getNumberOfVertices()];
		priorityQueue = new PriorityQueue<DistanceToEdge>(graph.getNumberOfVertices());

		for (int v = 0; v < graph.getNumberOfVertices(); v++) {
			distanceTo[v] = Long.MAX_VALUE;
		}
		distanceTo[source] = 0L;
		priorityQueue.offer(new DistanceToEdge(source, 0L));
		while (!priorityQueue.isEmpty()) {
			priorG(graph, priorityQueue.poll().getEdge());
		}
	}

	private void priorG(Graph graph, int v) {
		for (Edge edge : graph.list(v)) {
			int w = edge.to();

			if (distanceTo[w] > distanceTo[v] + edge.getWeight()) {
				distanceTo[w] = distanceTo[v] + edge.getWeight();
				edgeTo[w] = edge;
				DistanceToEdge dte = new DistanceToEdge(w, distanceTo[w]);
				priorityQueue.remove(dte);
				priorityQueue.offer(dte);
			}
		}
	}

	public long getDistanceTo(int v) {
		return distanceTo[v];
	}

	public boolean hasPathTo(int v) {
		return distanceTo[v] < Long.MAX_VALUE;
	}

	public Iterable<Edge> getPathTo(int v) {
		Deque<Edge> path = new ArrayDeque<Edge>();
		if (!hasPathTo(v)) {
			return path;
		}
		for (Edge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
			path.push(e);
		}
		return path;
	}


//=====================================================================================================

	class DistanceToEdge implements Comparable<DistanceToEdge> {
		// krawedz
		private final int edge;
		// odleglosc do tej krawedzi
		private long distance;

		public DistanceToEdge(int edge, long distance) {
			this.edge = edge;
			this.distance = distance;
		}

		public long getDistance() {
			return distance;
		}

		public void setDistance(long distance) {
			this.distance = distance;
		}

		public int getEdge() {
			return edge;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + (int) (distance ^ (distance >>> 32));
			result = prime * result + edge;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			DistanceToEdge other = (DistanceToEdge) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (distance != other.distance)
				return false;
			if (edge != other.edge)
				return false;
			return true;
		}

		@Override
		public int compareTo(DistanceToEdge param) {
			int cmp = new Long(distance).compareTo(param.getDistance());

			if (cmp == 0) {
				return new Integer(edge).compareTo(param.getEdge());
			}
			return 0;
		}

		private Dijkstry getOuterType() {
			return Dijkstry.this;
		}
	}
}