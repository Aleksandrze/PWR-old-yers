
public class Bufor implements Queue {
	Object[] tab;
	final int _size;
	int first = 0;
	int last;
	int rozmiar;

	public Bufor(int size) {
		_size = size;
		tab = new Object[_size];
		clear();
	}

	@Override
	public void enqueue(Object value) {
		if (_size == rozmiar) {
			System.out.println("Tablica jest pelna");
		} else {
			tab[last] = value;
			if (last < _size - 1) {
				last++;
			} else {
				last = 0;
			}
			rozmiar++;

		}
	}

	@Override
	public Object dequeue() throws EmptyQueueException {
		if (size() == 0) {
			System.out.println("pusta");
			throw new EmptyQueueException();
		} else {
			Object e = tab[first];
			if (first < _size - 1) {
				first++;
			} else {
				first = 0;
			}
			rozmiar--;

			return e;
		}
	}

	@Override
	public void clear() {
		first = 0;
		last = 0;
		rozmiar = 0;

	}

	public void wyswietl() {
		for (int i = 0; i < rozmiar; i++) {
			if (i + first < _size) {
				System.out.println("lp. " + i + " w tabelie " + (i + first) + " " + tab[i + first]);
			} else {
				System.out.println("lp. " + i + "  w tabelie " + (i + first - _size) + " " + tab[i + first - _size]);
			}
		}
	}

	@Override
	public int size() {
		return rozmiar;
	}

	@Override
	public boolean isEmpty() {
		return rozmiar == 0;
	}

	@Override
	public void enqueue2(Object value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object dequeue2() throws EmptyQueueException {
		// TODO Auto-generated method stub
		return null;
	}

}
