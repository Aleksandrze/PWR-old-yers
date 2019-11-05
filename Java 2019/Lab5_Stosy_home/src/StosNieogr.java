
import java.util.EmptyStackException;

public class StosNieogr implements Stack {

	private Element first;
	private int size;

	private static final class Element {
		private Object _value;
		private Element _next;

		public Element(Object value) {
			setValue(value);
		}

		public void setValue(Object value) {
			_value = value;
		}

		public Object getValue() {
			return _value;
		}

		public Element getNext() {
			return _next;
		}

		public void setNext(Element next) {
			_next = next;
		}

	}

	@Override
	public void push(Object value) {
		Element e = new Element(value);
		e.setNext(first);
		first = e;
		size++;

	}

	@Override
	public Object pop() throws EmptyStackException {

		if (first == null) {
			throw new EmptyStackException();
		} else {
			Object ret = first.getValue();
			first = first.getNext();
			size--;
			return ret;

		}
	}

	@Override
	public Object peek() throws EmptyStackException {
		// TODO Auto-generated method stub
		if (first == null) {
			throw new EmptyStackException();
		} else {
			Object ret = first.getValue();
			return ret;
		}

	}

	public void wyswietl() {
		Element e = first;

		while (e != null) {
			System.out.println(e.getValue());
			e = e.getNext();
		}
		System.out.println();
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		first = new Element(null);
		size = 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}
}
