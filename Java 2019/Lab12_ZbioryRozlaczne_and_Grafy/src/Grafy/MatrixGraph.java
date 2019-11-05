package Grafy;

public class MatrixGraph {

	private int valuel;
	private int[][] matrix;

	public MatrixGraph(int v) {
		valuel = v;
		matrix = new int[v][v];
	}

	// dołączenia wierzchołka do grafu
	public void addVertex() {
		valuel++;
		int[][] tmp = new int[valuel][valuel];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				tmp[i][j] = matrix[i][j];
			}
		}
		matrix = tmp;
	}
	
	//dołączenia krawędzi do grafu,
	public void addEdge(int v, int w) {
		matrix[v][w] = 1;
		matrix[w][v] = 1;
	}

	public void print() {
		System.out.print("   ");
		for (int i = 0; i < matrix.length; i++) {
			System.out.print(" " + (i) + " ");
		}
		System.out.println();
		System.out.print("   ");
		for (int i = 0; i < matrix.length; i++) {
			System.out.print("---");
		}
		System.out.println();
		for (int i = 0; i < matrix.length; i++) {
			System.out.print(i + " |");
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(" " + matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

}
