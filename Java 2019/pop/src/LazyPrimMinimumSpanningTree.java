/**
 * Implementacja leniwej wersji algorytmu Prima do znajdowania minimalnego drzewa 
 * rozpinajacego w spojnym nieskierowanym grafie.
 * 
 * created by mephisto
 * www.algorytm.org
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Krawedz grafu nieskierowanego. Zawiera informacje, ktore wierzcholki laczy
 * krawedz oraz zawiera jej wage(np. dlugosc, czas itd).
 * 
 * @author mephisto
 */
class Edge implements Comparable<Edge> {
	// jeden wierzcholek
	private final int v;
	// drugi wierzcholek
	private final int w;
	// waga
	private final long weight;

	public Edge(int v, int w, int weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}

	/**
	 * 
	 * @return jeden z wierzcholkow
	 */
	public int getEitherVertex() {
		return v;
	}

	/**
	 * 
	 * @param vertex
	 *            jeden z wierzcholkow krawedzi
	 * @return wierzcholek, ktory wspoltworzy krawedz z wierzcholkiem
	 *         {@code vertex}
	 */
	public int getOtherVertex(int vertex) {
		if (vertex == v) {
			return w;
		} else if (vertex == w) {
			return v;
		}
		throw new IllegalArgumentException("Wrong vertex!");
	}

	/**
	 * 
	 * @return wage krawedzi
	 */
	public long getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return String.format("%d->%d (%d) ", v, w, weight);
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

/**
 * Graf nieskierowany reprezentowany za pomoca list sasiedztwa danych
 * wierzcholkow.
 * 
 * @author mephisto
 */
class Graph {
	// liczba wierzcholkow
	private final int v;
	// liczba krawedzi
	private int e;
	// listy sasiedztwa
	private List<Edge>[] adjacencyLists;

	@SuppressWarnings("unchecked")
	public Graph(int v) {
		this.v = v;
		this.e = 0;
		this.adjacencyLists = (List<Edge>[]) new List[v];
		for (int i = 0; i < v; i++) {
			adjacencyLists[i] = new ArrayList<Edge>();
		}
	}

	/**
	 * 
	 * @return liczbe krawedzi w grafie
	 */
	public int getNumberOfEdges() {
		return e;
	}

	/**
	 * 
	 * @return liczbe wierzcholkow w grafie
	 */
	public int getNumberOfVertices() {
		return v;
	}

	/**
	 * Dodaje krawedz do odpowiednich list sasiedztwa(obu koncow krawedzi).
	 * 
	 * @param edge
	 *            krawedz, ktora ma zostac dodana do grafu
	 */
	public void addEdge(Edge edge) {
		int v = edge.getEitherVertex();
		int w = edge.getOtherVertex(v);
		adjacencyLists[v].add(edge);
		adjacencyLists[w].add(edge);
		e++;
	}

	/**
	 * Zwraca liste sasiedztwa danego wierzcholka.
	 * 
	 * @param v
	 *            indeks wierzcholka
	 * @return zwraca iterowalna kolekcje krawedzi
	 */
	public Iterable<Edge> getAdjacencyList(int v) {
		return adjacencyLists[v];
	}
}

public class LazyPrimMinimumSpanningTree {
	// zawiera flagi, czy dany wierzcholek zostal odwiedzony
	private boolean[] marked;
	// krawedzie minmalnego drzewa rozpinajacego
	private Queue<Edge> minimumSpanningTree;
	// krawedzie przekroju i krawedzie niewybieralne
	private Queue<Edge> priorityQueue;
	// sumaryczna waga drzewa
	private long weight;

	public LazyPrimMinimumSpanningTree(Graph graph) {
		marked = new boolean[graph.getNumberOfVertices()];
		minimumSpanningTree = new LinkedList<Edge>();
		priorityQueue = new PriorityQueue<Edge>(graph.getNumberOfVertices());

		// odwiedzamy pierwszy wierzcholek
		visit(graph, 0);
		while (!priorityQueue.isEmpty()) {
			// pobieramy kolejna krawedz z kolejki priorytetowj
			Edge e = priorityQueue.poll();
			int v = e.getEitherVertex();
			int w = e.getOtherVertex(v);
			// jesli wierzcholki sa oznaczone jako odwiedzone pomijamy reszte
			// instrukcji
			if (marked[v] && marked[w]) {
				continue;
			}
			// dodajemy do drzewa rozpinajacego krawedz
			minimumSpanningTree.offer(e);
			// aktualizacja wagi drzewa rozpinajacego
			weight += e.getWeight();

			// dodajemy do drzewa wierzcholki jesli sa nieodwiedzone
			if (!marked[v]) {
				visit(graph, v);
			}
			if (!marked[w]) {
				visit(graph, w);
			}
		}
	}

	/**
	 * 
	 * @return iterowalna kolekcje krawedzi wyznaczonego drzewa
	 */
	public Iterable<Edge> edges() {
		return minimumSpanningTree;
	}

	public long getWeight() {
		return weight;
	}

	private void visit(Graph graph, int v) {
		// oznaczamy wierzcholek jako odwiedzony
		marked[v] = true;
		// dodajemy wszystkie nieodwiedzone sasiednie wierzcholki vierzcholka v
		// do kolejki priorytetowej
		for (Edge edge : graph.getAdjacencyList(v)) {
			if (!marked[edge.getOtherVertex(v)]) {
				priorityQueue.offer(edge);
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Rozwiazanie przykladu z lekcji HEGARTYMATHS
		// http://www.youtube.com/watch?v=DqpmZiC3ito&list=PL7F1A69E79B5D6E3D
		Graph graph = new Graph(5);
		graph.addEdge(new Edge(0, 1, 6));
		graph.addEdge(new Edge(0, 2, 4));
		graph.addEdge(new Edge(0, 3, 8));
		graph.addEdge(new Edge(0, 4, 2));

		graph.addEdge(new Edge(1, 2, 5));
		graph.addEdge(new Edge(1, 3, 8));
		graph.addEdge(new Edge(1, 4, 6));

		graph.addEdge(new Edge(2, 3, 9));
		graph.addEdge(new Edge(2, 4, 4));

		graph.addEdge(new Edge(3, 4, 7));

		LazyPrimMinimumSpanningTree lazyPrimMST = new LazyPrimMinimumSpanningTree(
				graph);

		// krawedzie znalezionego drzewa
		for (Edge edge : lazyPrimMST.edges()) {
			System.out.println(edge);
		}
		System.out.println("Suma wag: " + lazyPrimMST.getWeight());

	}
}
