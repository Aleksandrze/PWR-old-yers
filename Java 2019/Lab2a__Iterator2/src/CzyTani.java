import Iterator.Predicate;

public class CzyTani implements Predicate {
		public boolean accept(Object o) {
			Towar t = (Towar) o;
			return t.getCena() < 2000;
		}
	}