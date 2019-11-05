package Prim;

public class Main {

	public static void main(String[] args) {

		Graph g = new Graph(7);
		//waga
		g.addEdge(new Edge(0, 1, 6));
		g.addEdge(new Edge(0, 2, 3));
		g.addEdge(new Edge(0, 3, 8));
		g.addEdge(new Edge(0, 4, 2));
		g.addEdge(new Edge(0, 5, 7));
		g.addEdge(new Edge(0, 6, 5));
		
		g.addEdge(new Edge(1, 2, 5));
		g.addEdge(new Edge(1, 3, 8));
		g.addEdge(new Edge(1, 5, 4));

		g.addEdge(new Edge(2, 3, 9));
		g.addEdge(new Edge(2, 4, 4));
		g.addEdge(new Edge(2, 6, 1));

		g.addEdge(new Edge(3, 4, 6));
		g.addEdge(new Edge(3, 6, 4));
		g.addEdge(new Edge(3, 5, 9));

		Prim suma = new Prim(g);

		for (Edge edge : suma.edges()) {
			System.out.println(edge);
		}
		System.out.println("Suma: " + suma.getWeight());

	}
}
