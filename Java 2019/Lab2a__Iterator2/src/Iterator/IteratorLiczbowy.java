package Iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorLiczbowy implements Iterator<Integer> {
	private int i = 2;
	private int liczba;

	public IteratorLiczbowy(int sc) {
		this.liczba = sc;
	}

	public boolean hasNext() {
		return i <= liczba;
	}

	public Integer next() throws NoSuchElementException {
		if (hasNext())
			return i++;
		else
			throw new NoSuchElementException();
	}

}