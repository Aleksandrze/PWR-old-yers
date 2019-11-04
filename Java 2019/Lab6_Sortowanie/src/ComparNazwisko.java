
public final class ComparNazwisko implements Comparator {

	public static final ComparNazwisko INSTANCE = new ComparNazwisko();

	private ComparNazwisko() {
	}

	@Override
	public int compare(Object left, Object right) throws ClassCastException {
		return ((Osoba) left).getNazwisko().compareTo(((Osoba) right).getNazwisko());
	}

}
