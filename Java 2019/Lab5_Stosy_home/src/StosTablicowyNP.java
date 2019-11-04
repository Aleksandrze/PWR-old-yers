

public class StosTablicowyNP<T> implements StosT<T> {
	private static final int DEFAULT_CAPACITY = 4;
	private T tablica[];
	private int rozmiar;
	private int indeksGorny;

	@SuppressWarnings("unchecked")
	public StosTablicowyNP(int rozmiarPocz) {
		tablica = (T[]) new Object[rozmiarPocz];
		rozmiar = rozmiarPocz;
		indeksGorny = 0;
	}

	public StosTablicowyNP() {
		this(DEFAULT_CAPACITY);
	}

	public boolean isEmpty() {
		return indeksGorny == 0;
	}

	public boolean isFull() {
		return false;
	}

	@SuppressWarnings("unchecked")
	public void resize(double p) {
		T[] tempTablica = (T[]) new Object[(int) (rozmiar * p)];
		
		for (int i = 0; i < size(); i++)
			tempTablica[i] = tablica[i];
		
		tablica = tempTablica;
		rozmiar = tablica.length;
	}

	public T pop() {
		if (indeksGorny <= rozmiar * 0.2 && rozmiar > DEFAULT_CAPACITY)
			resize(0.5);
		return tablica[--indeksGorny];
	}

	public void push(T element) {
		if (indeksGorny >= rozmiar * 0.8)
			resize(2);
		tablica[indeksGorny++] = element;
	}

	public int size() {
		return indeksGorny;
	}

	public T top() {
		return tablica[indeksGorny - 1];
	}

	public int getRozmiar() {
		return this.rozmiar;
	}
}
