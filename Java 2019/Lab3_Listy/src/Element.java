
final class Element {
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