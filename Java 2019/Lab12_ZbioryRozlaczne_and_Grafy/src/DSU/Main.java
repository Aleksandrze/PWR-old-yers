package DSU;

public class Main {

	public static void main(String[] args) {
		DSUtab dsu_tab = new DSUtab(10);
		dsu_tab.makeSet(1); // dodac
		dsu_tab.makeSet(2);
		dsu_tab.makeSet(3);
		dsu_tab.makeSet(4);
		dsu_tab.makeSet(5);
		System.out.println();

		System.out.println("find(" + 4 + ") = " + dsu_tab.find(4) + "\n");

		// find - szukac
		// unite jednoczyć
		dsu_tab.unite(1, 4);
		dsu_tab.unite(3, 5);
		System.out.println();

		System.out.println("find(" + 4 + ") = " + dsu_tab.find(4));
		System.out.println("find(" + 1 + ") = " + dsu_tab.find(1));
		System.out.println("find(" + 2 + ") = " + dsu_tab.find(2) + "\n");

		dsu_tab.unite(5, 2);
		System.out.println();
		

		System.out.println("find(" + 5 + ") = " + dsu_tab.find(5));
		System.out.println("find(" + 3 + ") = " + dsu_tab.find(3) + "\n");
		
		 dsu_tab.findLeafs();
	}

}
