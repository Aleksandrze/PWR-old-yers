import java.util.ArrayList;

public class ComparCompar implements Comparator {
	private ArrayList<Comparator> listComparatos = new ArrayList();

	public ComparCompar() {
		listComparatos = new ArrayList<Comparator>();
	}

	public void addComarator(Comparator cpr) {
		listComparatos.add(cpr);
	}

	@Override
	public int compare(Object left, Object right) throws ClassCastException {
		int res = 0;
		for (Comparator cpr : listComparatos) {
			if (res != cpr.compare(left, right)) {
				res = cpr.compare(left, right);
			}
		}
		return res;
	}
}
