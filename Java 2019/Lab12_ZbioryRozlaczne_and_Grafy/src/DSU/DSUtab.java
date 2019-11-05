package DSU;

import java.util.ArrayList;

public class DSUtab {
	int p[];
	int rank[];

	public DSUtab(int n) {
		p = new int[n];
		rank = new int[n];
	}

	public void makeSet(int x) {
		System.out.println("makeSet(" + x + ")");
		p[x] = x;
	}

	public int find(int x) { // z kompresja
		if (p[x] == x) {
			return x;
		}
		return p[x] = find(p[x]);
	}

	public int ufind(int x) {
		if (p[x] == x) {
			return x;
		}
		return find(p[x]);
	}

	public void path(int x) {
		if (p[x] == x)
			return;
		System.out.print(find(p[x]) + " ");
	}

	public void unite(int x, int y) { // z optymalizacja
		System.out.println("unite(" + x + ", " + y + ")");
		x = find(x);
		y = find(y);
		if (rank[x] < rank[y])
			p[x] = y;
		else {
			p[y] = x;
			if (rank[x] == rank[y])
				++rank[x];
		}
	}

	public void findLeafs() { // szukanie liscia
		ArrayList<Integer> leafs = new ArrayList<Integer>();
		for (int i = 0; i < p.length; i++)
			for (int j = 0; j < p.length; j++) {
				if (i == p[j])
					continue;
				leafs.add(i);
			}
		System.out.print("Leafs: ");
		for (int l : leafs)
			System.out.print(l + "(" + ufind(l) + ") ");
	}

}
