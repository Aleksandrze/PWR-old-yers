import Iterator.Predicate;

public class CzyPierwsza implements Predicate {
	public boolean accept(Object o) {
		Integer t = (Integer) o;
		return czyPierwsza(t);
	}

	public static boolean czyPierwsza(Integer liczba) {
		boolean flag = true;
		for (int i = 2; i < liczba; i++)
			if (liczba % i == 0)
				flag = false;
		return flag;
	}

	/*public static void przedzial(int a, int b) {

		for (int i = a; i <= b; i++) {
			if (czyPierwsza(i) == true) {
				System.out.println(i + " ");
			}
		}
	}*/

}