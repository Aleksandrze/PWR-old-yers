import Iterator.Predicate;

public class CzyWyczerpany implements Predicate {
	public boolean accept(Object o) {
		Towar t = (Towar) o;
		return t.getIlosc() == 0;
	}
}