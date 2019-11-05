package Grafy;

public class Main {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {

		MatrixGraph mg = new MatrixGraph(5);

		mg.addEdge(0, 1);
		mg.addEdge(1, 2);
		mg.addEdge(0, 3);
		mg.addEdge(0, 4);
		mg.addEdge(1, 4);
		mg.addEdge(2, 4);
		mg.addEdge(3, 4);

		mg.print();
		System.out.println();
		mg.addVertex();
		mg.print();

		System.out.println("==========\n");
		
		// ===============================================
		ListaGraph g = new ListaGraph();
		g.addVertex(0);
		g.addVertex(1);
		g.addVertex("i");
		g.addVertex(3);
		g.addVertex(4);
		g.addVertex(5);

		g.addEdge(0, 1);
		g.addEdge(0, "i");
		g.addEdge(1, "i");
		g.addEdge("i", 3);
		g.addEdge(1, 4);
		g.addEdge(4, 5);

		g.print();
		System.out.println();
	}
}
