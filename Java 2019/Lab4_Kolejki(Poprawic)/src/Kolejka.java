
public class Kolejka implements Queue {

	private Element _head = null;
	private int _size = 0;

	public Kolejka() {
		clear();
	}

	@Override
	public void enqueue(Object value) {
		_size++;
		Element n = new Element(value);
		if (_head == null) {
			// n.setNext(_head);
			_head = n;
		}
		Element a = _head;
		while (a.getNext() != null) {
			a = a.getNext();
		}
		n.setNext(null);
		a.setNext(n);

	}

	@Override
	public Object dequeue() throws EmptyQueueException {
		_size--;
		if (_size == 0) {
			throw new EmptyQueueException();
		} else {
			Element el = _head;
			_head = _head.getNext();

			return el;
		}
	}

	@Override
	public void enqueue2(Object value) {
		Element e = new Element(value);
		Element next = _head;
		while (next.getNext() != null) {
			next = next.getNext();
		}
		next.setNext(e);
		_size++;
	}

	@Override
	public Object dequeue2() throws EmptyQueueException {
		Element next = _head;
		if (next.getNext() == null) {
			throw new EmptyQueueException();
		} else {
			Element e = next.getNext();
			next.setNext(e.getNext());
			_size--;
			return e.getValue();
		}
	}

	public void wyswietl() {
		Element next = _head;
		while (next.getNext() != null) {
			next = next.getNext();
			System.out.println(next.getValue());
		}
	}

	@Override
	public void clear() {
		_head = null;
		_size = 0;
	}

	@Override
	public int size() {
		return _size;
	}

	@Override
	public boolean isEmpty() {
		return _size == 0;
	}

}
