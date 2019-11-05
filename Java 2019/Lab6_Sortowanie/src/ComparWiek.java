public final class ComparWiek implements Comparator {

	public static final ComparWiek INSTANCE = new ComparWiek();

	private ComparWiek() {
	}

	public int compare(Object left, Object right) throws ClassCastException {
		if (((Osoba) left).getWiek() == ((Osoba) right).getWiek()) {
			return 0;
		} else {
			if (((Osoba) left).getWiek() < ((Osoba) right).getWiek()) {
				return -1;
			} else {
				return 1;

			}
		}
	}
}
