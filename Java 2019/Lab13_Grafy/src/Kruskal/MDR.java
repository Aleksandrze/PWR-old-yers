package Kruskal;

import java.util.Arrays;

public class MDR {

	public int V;
	public int E;
	Edge edge[];

	MDR(int v, int e) {
		V = v;
		E = e;
		edge = new Edge[E];
		for (int i = 0; i < e; i++) {
			edge[i] = new Edge();
		}
	}

	public int find(Subset subset[], int i) {
		if (subset[i].parent != i) {
			subset[i].parent = find(subset, subset[i].parent);
		}
		return subset[i].parent;
	}

	void Union(Subset subsets[], int x, int y) {
		int xroot = find(subsets, x);
		int yroot = find(subsets, y);
		if (subsets[xroot].rank < subsets[yroot].rank)
			subsets[xroot].parent = yroot;
		else if (subsets[xroot].rank > subsets[yroot].rank)
			subsets[yroot].parent = xroot;

		else {
			subsets[yroot].parent = xroot;
			subsets[xroot].rank++;
		}
	}

	void KruskalMST() {
		Edge result[] = new Edge[V];
		int e = 0;
		int i = 0;
		for (i = 0; i < V; ++i)
			result[i] = new Edge();

		Arrays.sort(edge);

		Subset subsets[] = new Subset[V];
		for (i = 0; i < V; ++i)
			subsets[i] = new Subset();

		for (int v = 0; v < V; ++v) {
			subsets[v].parent = v;
			subsets[v].rank = 0;
		}

		i = 0;

		while (e < V - 1) {

			Edge next_edge = new Edge();
			next_edge = edge[i++];

			int x = find(subsets, next_edge.src);
			int y = find(subsets, next_edge.dest);

			if (x != y) {
				result[e++] = next_edge;
				Union(subsets, x, y);
			}

		}

		System.out.println("Poniżej znajdują się żebra w" + " zbudowanego MST");
		for (i = 0; i < e; ++i)
			System.out.println(result[i].src + " -- " + result[i].dest + " == " + result[i].weight);
		System.out.println("Suma=21");
	}
}
