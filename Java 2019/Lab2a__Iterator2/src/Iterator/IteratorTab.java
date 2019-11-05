package Iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorTab<T> implements Iterator<T> {
	private T tablica[];
	private int pozycja = 0;

	public IteratorTab(T tablica[]) {
		this.tablica = tablica;
	}

	public boolean hasNext() {
		return pozycja < tablica.length;
	}

	public T next() throws NoSuchElementException {
		if (hasNext())
			return tablica[pozycja++];
		else
			throw new NoSuchElementException();
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}
}
