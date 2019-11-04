import java.util.Scanner;

public class CzyPierszaLiczba {

	public static boolean licz(int a) {

		if (a == 1)
			return false;
		for (int i = 2; i <= Math.sqrt(a); i++) {
			if (a % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void przedzial(int a, int b) {

		System.out.println("W przydziale (" + a + "," + b + ") piersza jest: ");
		for (int i = a; i <= b; i++) {
			if (licz(i) == true) {
				System.out.println(i + " ");
			}
		}
	}

	
//----------------------
	
	public static String liczOne(int a) {


		if (a == 1) {
			return "Nie jest piersza";
		}
		for (int i = 2; i <= Math.sqrt(a); i++) {
			if (a % i == 0) {
				return "Nie jest piersza";
			}
		}
		return "Jest piersza";
	}
	
	public static void main(String[] args) {
int a;
		Scanner  sc = new Scanner(System.in);
		a=sc.nextInt();
		przedzial(1, 15);
		System.out.println("---------");
		System.out.println( liczOne(a));
	}

}
