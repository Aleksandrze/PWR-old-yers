public class Main {
	public static void main(String[] args) {
		System.out.println("Tworzymy drzewo czerwono-czarne");
		TreeRandB rb = new TreeRandB();
		int[] liczby = { 37, 49, 82, 39, 28, 76, 54, 6, 10, 66, 30, 70 };
		System.out.print("Dodajemy do drzewa elementy: ");
		for (int l : liczby) {
			System.out.print(l + " ");
			rb.insert(l);
		}
		rb.levelOrder();
		System.out.println("\n");
		System.out.println("Wstawimy element 80:");
		rb.insert(80);
		System.out.println("\n");
		rb.levelOrder();
		System.out.println();
		System.out.println("Szukamy wezel o kluczu 45: ");
		rb.searchNode(66);
		System.out.println("Szukamy wezel o kluczu 10: ");
		rb.searchNode(77);

		System.out.println();

		System.out.println("BLACK = B and RED = R");

		System.out.println("inOrder");
		rb.inOrderWalk();
		System.out.println("\npreOrder");
		rb.preOrderWalk();
		System.out.println("\npostOrder");
		rb.postOrderWalk();


		System.out.println("\n");
		rb.levelOrder();
		System.out.println();
		rb.printHeights();
		System.out.println();
		rb.printNodes();
		System.out.println();
		rb.printHeights();
		
		
		System.out.println();
		
		rb.search(76).getParams();
	}
}
