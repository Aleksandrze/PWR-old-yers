
public final class ComparImie implements Comparator {

	public static final ComparImie INSTANCE = new ComparImie();

	public ComparImie() {
	}

	@Override
	public int compare(Object left, Object right) throws ClassCastException {
		return ((Osoba) left).getImie().compareTo(((Osoba) right).getImie());
	}

}
