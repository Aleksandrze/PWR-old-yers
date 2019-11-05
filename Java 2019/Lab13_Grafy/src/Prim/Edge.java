package Prim;

public class Edge implements Comparable<Edge> {
	//wierzcholek
		private final int v;
		private final int w;
		private final long weight;

		public Edge(int v, int w, int weight) {
			this.v = v;
			this.w = w;
			this.weight = weight;
		}

		public int getEitherVertex() {
			return v;
		}

		public int getOtherVertex(int vertex) {
			if (vertex == v) {
				return w;
			} else if (vertex == w) {
				return v;
			}
			throw new IllegalArgumentException("Wrong vertex!");
		}

		public long getWeight() {
			return weight;
		}

		@Override
		public String toString() {
			return String.format("%d---%d [%d] ", v, w, weight);
		}

		@Override
		public int compareTo(Edge arg) {
			if (getWeight() < arg.getWeight()) {
				return -1;
			} else if (getWeight() > arg.getWeight()) {
				return 1;
			}
			return 0;
		}
	
}
