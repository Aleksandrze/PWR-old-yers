package Iterator;

import java.util.Iterator;

public class IteratorFilt<T> implements Iterator<T> {
	private Iterator<T> iterator;
	private Predicate filtr;

	private T elemNext = null;
	private boolean bHasNext = true;

	public IteratorFilt(Iterator<T> iterator, Predicate filtr) {
		super();
		this.iterator = iterator;
		this.filtr = filtr;
		findNextValid();
	}

	private void findNextValid() {
		while (iterator.hasNext()) {
			elemNext = iterator.next();
			if (filtr.accept(elemNext)) {
				return;
			}
		}
		bHasNext = false;
		elemNext = null;
	}

	@Override
	public boolean hasNext() {
		return bHasNext;
	}

	@Override
	public T next() {
		T nextValue = elemNext;
		findNextValid();
		return nextValue;
	}

}
