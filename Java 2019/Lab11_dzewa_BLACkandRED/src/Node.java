
public class Node extends TreeRandB {
	int value;
	Node left;
	Node right;
	Node parent;
	boolean color;

	int nodes;
	int lnodes;
	int rnodes;

	int wysokoscPoddrzewa;
	int wysokoscLewegoPoddrzewa;
	int wysokoscPrawegoPoddrzewa;

	public void setParams() {
		wysokoscPoddrzewa = findHeight(this);
		wysokoscLewegoPoddrzewa = findHeight(this.left);
		wysokoscPrawegoPoddrzewa = findHeight(this.right);
	}

	public void getParams() {
		System.out.println("Wysokosc poddrzewa " + this.value + ": " + wysokoscPoddrzewa);
		System.out.println("Wysokosc lewego poddrzewa " + this.value + ": " + wysokoscLewegoPoddrzewa);
		System.out.println("Wysokosc prawego poddrzewa " + this.value + ": " + wysokoscPrawegoPoddrzewa);
		System.out.println("Liczba wezlow poddrzewa " + this.value + ": " + nodes);
		System.out.println("Liczba wezlow lewego poddrzewa " + this.value + ": " + lnodes);
		System.out.println("Liczba wezlow prawego poddrzewa " + this.value + ": " + rnodes);
	}

	public int getNodes() {
		return nodes;
	}

	public int getLnodes() {
		return lnodes;
	}

	public int getRnodes() {
		return rnodes;
	}

	public String getColor() {
		if (this.color == true)
			return "(R)";
		return "(B)";
	}

	Node(int v) {
		value = v;
		color = RED;
		left = right = parent = null;
		nodes = lnodes = rnodes = 0;
	}

	Node(int v, Node l, Node r) {
		value = v;
		left = l;
		right = r;
		parent = null;
		color = RED;
	}
}
