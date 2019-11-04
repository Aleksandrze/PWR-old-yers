
public class e13e {
	static int funkcja(int m, int n) {
		int wynik = 0;
		if (m < 0 || n < 0) {
			wynik = 0;
		} else if (m == 0) {
			wynik = n + 1;
		} else if (m > 0 && n == 0) {
			wynik = funkcja(m - 1, 1);
		} else if (m > 0 && n > 0) {
			wynik = funkcja(m - 1, funkcja(m, n - 1));
		}
		return wynik;
	}

	public static void main(String[] args) {
		System.out.println(funkcja(2, 1));
	}

}

