import java.util.Stack;

public class Drzewa {

	Wezel korzen;

	public Drzewa() {
		korzen = null;
	}

	public void dodaj(int n) {
		korzen = dodaj(n, korzen);
	}

	private Wezel dodaj(int n, Wezel r) {
		if (r == null)
			r = new Wezel(n);
		else {
			Wezel temp = null;
			if (n < r.value) {
				temp = dodaj(n, r.left);
				r.left = temp;
			} else if (n > r.value) {
				temp = dodaj(n, r.right);
				r.right = temp;
			} else {
				System.out.println("Istnieje juz taki wezel");
			}
		}
		return r;
	}

	private Wezel wyszukaj(int n) {
		Wezel r = korzen;
		while (r != null && r.value != n) {
			r = n < r.value ? r.left : r.right;
		}
		return r;
	}

	public String znajdz(int x) {
		Wezel t = wyszukaj(x);
		return t != null ? "Znaleziono " + x : " Nie znalezono " + x;
	}

	String przegladInOrder() {
		String b = "In Order: ";
		if (korzen != null) {
			b += korzen.inOrder();
		} else {
			b += "Drzewo puste";
		}
		return b.substring(0, b.length() - 2);
	}

	String przegladPreOrder() {
		String b = "Pre Order: ";
		if (korzen != null) {
			b += korzen.preOrder();
		} else {
			b += "Drzewo puste";
		}
		return b.substring(0, b.length() - 2);
	}

	String przegladPostOrder() {
		String b = "Post Order: ";
		if (korzen != null) {
			b += korzen.postOrder();
		} else {
			b += "Drzewo puste";
		}
		return b.substring(0, b.length() - 2);
	}

	public int min() {
		return min(korzen).value;
	}

	private Wezel min(Wezel n) {
		while (n.left != null)
			n = n.left;
		return n;
	}

	public int max() {
		return max(korzen).value;
	}

	private Wezel max(Wezel n) {
		while (n.right != null)
			n = n.right;
		return n;
	}

	public int znajdzWysokosc() {
		if (korzen == null) {
			return -1;
		} else {
			return znajdzWysokosc(korzen);
		}
	}

	private int znajdzWysokosc(Wezel n) {
		if (n == null || (n.left == null && n.right == null)) {
			return 0;
		}
		return (Math.max(znajdzWysokosc(n.left), znajdzWysokosc(n.right)) + 1);
	}

	public int iloscLisc() {
		if (korzen == null) {
			return -1;
		} else {
			return iloscLisc(korzen);
		}
	}

	private int iloscLisc(Wezel n) {
		if (n == null)
			return 0;
		if (n.left == null && n.right == null)
			return 1;
		else
			return iloscLisc(n.left) + iloscLisc(n.right);
	}

	public int iloscWezlow() {
		if (korzen == null) {
			return -1;
		} else {
			return iloscWezlow(korzen);
		}
	}

	private int iloscWezlow(Wezel n) {
		int c = 1;
		if (n == null)
			return 0;
		else {
			c += iloscWezlow(n.left);
			c += iloscWezlow(n.right);
			return c;
		}
	}

	public void displayTree() {
		Stack<Wezel> globalStack = new Stack<Wezel>();
		globalStack.push(korzen);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		System.out.println();
		while (isRowEmpty == false) {
			@SuppressWarnings("rawtypes")
			Stack localStack = new Stack();
			isRowEmpty = true;

			for (int j = 0; j < nBlanks; j++)
				System.out.print(' ');
			while (globalStack.isEmpty() == false) {
				Wezel temp = (Wezel) globalStack.pop();
				if (temp != null) {
					System.out.print(temp.value);
					localStack.push(temp.left);
					localStack.push(temp.right);
					if (temp.left != null || temp.right != null)
						isRowEmpty = false;
				} else {
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}
				for (int j = 0; j < nBlanks * 2 - 2; j++)
					System.out.print(' ');
			}
			System.out.println();
			nBlanks /= 2;
			while (localStack.isEmpty() == false)
				globalStack.push((Wezel) localStack.pop());
		}
		System.out.println();
	}

//_______________________________Online test ________________________

	public int successor(int n) {
		Wezel x = wyszukaj(n);
		Wezel result = null;
		if (x != null)
			result = successor(x);
		if (result == null) {
			return -1;
		}
		return result.value;
	}

	private Wezel successor(Wezel n) {
		if (n.right != null)
			return min(n.right);

		Wezel succ = null;
		Wezel r = korzen;
		while (r != null) {
			if (n.value < r.value) {
				succ = r;
				r = r.left;
			} else if (n.value > r.value)
				r = r.right;
			else
				break;
		}
		return succ;
	}

	public int predecessor(int n) {
		Wezel x = wyszukaj(n);
		Wezel result = null;
		if (x != null)
			result = predecessor(x);
		if (result == null) {
			return -1;
		}
		return result.value;
	}

	private Wezel predecessor(Wezel n) {
		if (n.left != null)
			return max(n.left);

		Wezel succ = null;

		Wezel r = korzen;
		while (r != null) {
			if (n.value > r.value) {
				succ = r;
				r = r.right;
			} else if (n.value < r.value)
				r = r.left;
			else
				break;
		}
		return succ;
	}

	public void delete(int key) {
		@SuppressWarnings("unused")
		Wezel l = wyszukaj(key);
		korzen = deleteRec(korzen, key);
	}

	public Wezel deleteRec(Wezel n, int key) {
		if (n == null)
			return n;

		if (key < n.value)
			n.left = deleteRec(n.left, key);
		else if (key > n.value)
			n.right = deleteRec(n.right, key);
		else {
			if (n.left == null)
				return n.right;
			else if (n.right == null)
				return n.left;

			n.value = minValue(n.right);
			n.right = deleteRec(n.right, n.value);
		}
		return n;
	}

	public int minValue(Wezel r) {
		int minv = r.value;
		while (r.left != null) {
			minv = r.left.value;
			r = r.left;
		}
		return minv;
	}
}
