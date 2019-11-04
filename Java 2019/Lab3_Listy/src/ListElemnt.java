public class ListElemnt extends ListySprawdzian {

	private final Element head = new Element(null);
//	private final Element p = new Element(null);
	private int size;

//_______________________Czesc 1______________________

	@Override
	public void insert(int index, Object value) throws IndexOutOfBoundsException {
		Element t = new Element(value);
		Element pop = head;
		Element next = head.getNext();
		int i = 0;
		if (index <= size) {
			while (i < index) {
				pop = pop.getNext();
				next = next.getNext();
				i++;
			}
			size++;
			pop.setNext(t);
			t.setNext(next);
		}
	}

	@Override
	public Object get(int index) throws IndexOutOfBoundsException {
		Element pop = head;
		int i = 0;
		if (index < size) {

			while (i <= index) {
				pop = pop.getNext();
				i++;
			}
			return pop.getValue();
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		head.setNext(null);
		size = 0;
	}

	public void wyswietlListe() {
		Element pop = head;
		int i = 0;
		while (pop.getNext() != null) {
			pop = pop.getNext();
			System.out.println(i + " " + pop.getValue());
			i++;
		}
	}

//_______________________________Czesc 2______________________________

	@Override
	public void add(Object value) {
		Element e = new Element(value);
		Element pod = head;

		while (pod.getNext() != null) {
			pod = pod.getNext();
		}
		size++;
		pod.setNext(e);

	}

	@Override
	public Object delete(int index) throws IndexOutOfBoundsException {
		Element pop = head;
		Element szukaj;
		Element next;
		int i = 0;
		if (index <= size) {

			while (i < index) {
				pop = pop.getNext();
				i++;
			}
			szukaj = pop.getNext();
			if (szukaj.getNext() != null) {
				next = szukaj.getNext();
				pop.setNext(next);
			}
			size--;
			return szukaj.getValue();
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public boolean delete(Object value) {
		Element pop = head;
		if (pop.getNext().getValue().equals(value)) {
			pop.setNext(pop.getNext().getNext());
			size--;
			return true;
		}
		if (pop.getNext() != null) {
			Element next = pop.getNext();

			while (next.getNext() != null) {
				pop = pop.getNext();
				next = next.getNext();
				if (next.getValue().equals(value)) {
					pop.setNext(next.getNext());
					size--;
					return true;
				}
			}
			return false;
		}
		return false;

	}

	@Override
	public Object set(int index, Object value) throws IndexOutOfBoundsException {

		Element next = head;
		Object ret;
		int i = 0;
		if (index < size && index >= 0) {
			while (i <= index) {

				next = next.getNext();
				i++;
			}

			ret = next.getValue();
			next.setValue(value);
			return ret;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public int indexOf(Object value) {

		Element next = head;
		int index = 0;
		next = next.getNext();
		while (next != null) {

			if (next.getValue().equals(value)) {
				return index;
			}
			next = next.getNext();
			index++;
		}
		return -1;

	}

	@Override
	public boolean contains(Object value) {
		Element next = head.getNext();
		while (next != null) {
			if (next.getValue().equals(value)) {
				return true;
			}
			next = next.getNext();
		}
		return false;
	}

//___________________________Czesc 3______________________

	@Override
	public Iterator iterator() {
		return new ValueIterator();
	}

	private final class ValueIterator implements Iterator {
		private Element current = head;

		public void first() {
			current = head.getNext();
		}

		public boolean isDone() {
			return current == null;
		}

		public void next() {
			current = current.getNext();
		}

		public Object current() throws IndexOutOfBoundsException {
			if (isDone())
				throw new IndexOutOfBoundsException();
			return current.getValue();
		}
	}
}
