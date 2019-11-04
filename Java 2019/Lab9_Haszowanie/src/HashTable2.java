
public class HashTable2<T extends Hashable> {

	public T[] table;

	@SuppressWarnings("unchecked")
	public HashTable2(int size) {
		table = (T[]) new Object[size];
	}



	private int hash(String key) {
		int output = 0;
		for (int i = 0; i < key.length(); i++)
			output ^= key.charAt(i);
		return output;
	}

	public void put(String key, T value) {
		if (size() == table.length)
			resize(2);

		for (int i = 0; i < table.length; i++) {//&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
			if (table[hash(key) + i % table.length] == null) {
				table[hash(key) + i % table.length] = value;
				break;
			}
		}
	}

	public T get(String key) {
		for (int i = 0; i < table.length; i++)
			if (table[hash(key) + i % table.length].getKey() == key)
				return table[hash(key) + i % table.length];

		return null;
	}

	public T remove(String key) {
		T output;
		output = get(key);
		for (int i = 0; i < table.length; i++)
			if (table[hash(key) + i % table.length].getKey() == key)
				table[hash(key) + i % table.length] = null;
		return output;
	}

	public boolean containsKey(String key) {
		for (int i = 0; i < table.length; i++)
			if (table[hash(key) + i % table.length].getKey() == key)
				return true;

		return false;
	}

	public int size() {
		int counter = 0;
		for (int i = 0; i < table.length; i++)
			if (table[i] != null)
				counter++;
		return counter;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	@SuppressWarnings("unchecked")
	private void resize(double p) {
		T[] tempTable = (T[]) new Object[(int) (table.length * p)];
		for (int i = 0; i < size(); i++)
			tempTable[i] = table[i];
		table = tempTable;
	}

	public void dump() {
		for (T t : table)
			if (t == null)
				System.out.println("null");
			else
				System.out.println(t);
	}

}
