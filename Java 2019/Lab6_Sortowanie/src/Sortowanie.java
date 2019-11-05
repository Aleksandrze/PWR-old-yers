
public class Sortowanie {
	private final Comparator cpr;

	public Sortowanie(Comparator comparator) {
		cpr = comparator;
	}
// insert sort
	public Object[] sort(Object[] list) {
		for (int i = 1; i < list.length; ++i) {
			Object value = list[i], temp;
			int j;
			for (j = i; j > 0 && cpr.compare(value, temp = list[j - 1]) < 0; --j)
				list[j] = temp;
			list[j] = value;
		}
		return list;
	}
	
}