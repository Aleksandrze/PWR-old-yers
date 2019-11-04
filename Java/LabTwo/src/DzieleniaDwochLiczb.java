
public class DzieleniaDwochLiczb {

	public static int spraw(int a, int b) {

		while (a != b) {

			if (a > b) {
				a -= b;
			} else
				b -= a;

		}
		return a;
	}

	public static void main(String[] args) {

		System.out.println("Obcy dzielnik jest liczb jest: " +spraw(21, 14));
		System.out.println("Obcy dzielnik jest liczb jest: " +spraw(100, 50));
		System.out.println("Obcy dzielnik jest liczb jest: " +spraw(15, 4));
	}

}
