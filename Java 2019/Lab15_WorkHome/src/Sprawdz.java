import java.util.Comparator;

public class Sprawdz implements Comparator<Node> {
	public int compare(Node x, Node y) {

		return x.liczba - y.liczba;
	}
}