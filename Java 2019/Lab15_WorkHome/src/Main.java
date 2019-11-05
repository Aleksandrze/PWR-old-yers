import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) {

		int linght = 0;
		char[] tabAlfabet = { 'a', 'b', 'c', 'd', 'e'};
		int[] tabLiczba = { 5, 4, 4, 25,15 };

		if (tabAlfabet.length == tabLiczba.length) {
			linght = tabLiczba.length;
		} else {
			System.out.println("Nie poprawna size tablic");
			System.exit(0);
		}

		// prirytet Węzeła
		PriorityQueue<Node> q = new PriorityQueue<Node>(linght, new Sprawdz());
		for (int i = 0; i < linght; i++) {
			Node start = new Node();
			start.alfabet = tabAlfabet[i];
			start.liczba = tabLiczba[i];
			q.add(start);
		}

		Node korzen = null;
		// przechodzim po kolejki prioretowej
		while (q.size() > 1) {
			Node One = q.poll(); // dostajemy i usuna
			Node Two = q.poll();
			Node konec = new Node();
			// czestosc sumeryczna
			konec.liczba = One.liczba + Two.liczba; // suma
			konec.left = One;
			konec.right = Two;
			korzen = konec;
			q.add(konec);
		}
		Huffman.print(korzen, "");
	}
}
