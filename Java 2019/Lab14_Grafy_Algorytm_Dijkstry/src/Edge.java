
public class Edge {

	private final int from;
	private final int to;
	private final long weight;

//krawędź
	public Edge(int from, int to, long weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

	public int from() {
		return from;
	}

	public int to() {
		return to;
	}

	public long getWeight() {
		return weight;
	}

	public String toString() {
		return String.format("%d->%d (%d) ", from, to, weight);
	}
}
