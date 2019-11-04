
public class tryg {

	public static void spraw(double a, double b, double c) {
		System.out.println("Liczby: a= " + a + " b= " + b + " c= " + c);
		if (a == 0) {
			if (b == 0 && c == 0)
				System.out.println("Rownanie tozsamosci");
			if (b == 0 && c != 0)
				System.out.println("Sprzeznaczonc");
			if (b != 0)
				System.out.println("X = " + (double) (-c / b));
		}
		if (a != 0) {
			double delta = (b * b) - (4 * a * c);
			if (delta == 0)
				System.out.println("X = " + (double) (-b / (2 * a)));
			if (delta < 0)
				System.out.println("Delta wynosi BRAK rozwianzan");
			if (delta > 0) {
				System.out.println("x1 = " + (double) (((-b) - Math.sqrt(delta)) / (2 * a)));
				System.out.println("x1 = " + (double) (((-b) + Math.sqrt(delta)) / (2 * a)));
			}
		}

		System.out.println("---------");
		System.out.println();
	}

	public static void main(String[] args) {

		spraw(1, 2, 3);
		spraw(2, 2, -12);
		spraw(2, -16, 32);
		spraw(0, 4, 2);
		spraw(0, 0, 2);
		spraw(0, 0, 0);

	}

}
