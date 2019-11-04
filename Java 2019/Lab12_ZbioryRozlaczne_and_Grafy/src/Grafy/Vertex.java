package Grafy;

import java.util.LinkedList;

public class Vertex<E> {

	E id;
	boolean visited = false;
	LinkedList<E> adj;

	Vertex(E id) {
		this.id = id;
		adj = new LinkedList<>();
	}

	public void setAdjency(E v) {
		adj.add(v);
	}

	@Override
	public String toString() {
		return "(" + id + ") -> " + adj;
	}
}
