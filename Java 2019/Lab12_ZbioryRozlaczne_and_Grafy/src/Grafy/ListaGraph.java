package Grafy;

import java.util.LinkedList;

public class ListaGraph<E> {

	private int value;
	@SuppressWarnings("rawtypes")
	private LinkedList<Vertex> vertexes;

	public ListaGraph() {
		value = 0;
		vertexes = new LinkedList<>();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void addVertex(E id) { // dodaj szczyt
		vertexes.add(new Vertex(id));
		value++;
	}

	@SuppressWarnings("rawtypes")
	public Vertex findVertex(E id) {
		for (Vertex v : vertexes) {
			if (v.id == id) {
				return v;
			}
		}
		return null;
	}

	public void addEdge(E v, E w) { //dodaj żebro
		if (v != w) {
			LinkedList<E> adj = findVertex(v).adj;
			boolean exist = false;
			for (E i : adj) {
				if (i == w) {
					exist = true;
					break;
				}
			}
			if (!exist) {
				adj.add(w);
			}

			LinkedList<E> adj2 = findVertex(w).adj;

			exist = false;
			for (E i : adj2) {
				if (i == v) {
					exist = true;
					break;
				}
			}
			if (!exist) {
				adj2.add(v);
			}
		}
	}

	public void print() {
		for (@SuppressWarnings("rawtypes")
		Vertex v : vertexes)
			System.out.println(v);
	}

	public void print(E id) {
		System.out.println(findVertex(id));
	}
}
