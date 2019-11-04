
public class HashTable<T extends Hashable> {
	private static final int DEFAULT_CAPACITY = 11;
	private T[] table;

	public T[] getTable() {
		return table;
	}

	@SuppressWarnings("unchecked")
	public HashTable(int size) {
		table = (T[]) new Hashable[size];
	}

	public HashTable() {
		this(DEFAULT_CAPACITY);
		System.out.println("Max rozmiar tablicy: " + DEFAULT_CAPACITY);
	}

	private int hash(String key) {
		int output = 0;
		for (int i = 0; i < key.length(); i++) {
			output ^= key.charAt(i);
		}
		return output;
	}

	public int size() {
		int counter = 0;
		for (int i = 0; i < table.length; i++) {
			if (table[i] != null) {
				counter++;
			}
		}
		return counter;
	}

	private void resize(double p) {
		HashTable<T> tempHashTable = new HashTable<T>((int) (table.length * p));
		for (int i = 0; i < table.length; i++)
			if (table[i] != null)
				tempHashTable.put(table[i].getKey(), table[i]);
		table = tempHashTable.getTable();
	}

	public void put(String key, T value) {
		if (size() >= table.length * 0.8) {
			resize(2);
		}
		for (int i = 0; i < table.length; i++)
			if (table[(hash(key) + i) % table.length] == null) {
				table[(hash(key) + i) % table.length] = value;
				break;
			}
	}

	public T get(String key) {
		for (int i = 0; i < table.length; i++)
			if (table[(hash(key) + i) % table.length] != null)
				if (table[(hash(key) + i) % table.length].getKey() == key)
					return table[(hash(key) + i) % table.length];

		return null;
	}

	public T remove(String key) {
		T output;
		output = get(key);
		for (int i = 0; i < table.length; i++)
			if (table[(hash(key) + i) % table.length].getKey() == key)
				table[(hash(key) + i) % table.length] = null;
		return output;
	}

	public boolean containsKey(String key) {
		for (int i = 0; i < table.length; i++)
			if (table[(hash(key) + i) % table.length].getKey() == key)
				return true;

		return false;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public void dump() {
		for (T t : table)
			if (t == null)
				System.out.println("null");
			else
				System.out.println(t);
	}

}