import java.util.Comparator;

/*
 *  comparator, ktury w razie potrzebna szereguje listy procesow.
 */
class Compar implements Comparator<Proces> {
	public int compare(Proces procesOne, Proces procesTwo) {
		if (procesOne.getTime() < procesTwo.getTime()) {
			return 1;
		} else {
			if (procesOne.getTime() > procesTwo.getTime()) {
				return -1;
			} else {
				if (procesOne.getNumer() < procesTwo.getNumer()) {
					return 1;
				} else {
					return -1;
				}
			}
		}
	}
}