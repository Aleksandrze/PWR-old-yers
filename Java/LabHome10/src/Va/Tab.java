package Va;
import java.util.Scanner;
//import java.io.BufferedReader;

public class Tab {

	int tab[][];
	private Scanner r;
	private Scanner num2;
	private Scanner num1;

	public Tab() {
		int a, b;

		num1 = new Scanner(System.in);
		System.out.println("Wprowadz liczbe wierszy");
		a = num1.nextInt();

		num2 = new Scanner(System.in);
		System.out.println("Wprowadz liczbe kolumn");
		b = num2.nextInt();

		tab = new int[a][b];
	}

	public void wypelnij() {
		System.out.println("Wypelnij tablice");
		r = new Scanner(System.in);
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[i].length; j++) {
				tab[i][j] = r.nextInt();
			}
		}
	}


	public void wyswietl() {
		System.out.println("\tTablica:");

		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[i].length; j++) {
				System.out.printf("%8d", tab[i][j]);
			}
			System.out.println();
		}
	}

	public void transponowana() {
		System.out.println("\t\tTablica transponowana:");
		System.out.println("-----------------------------------------");
		System.out.println();
		for (int i = 0; i < tab[0].length; i++) {
			for (int j = 0; j < tab.length; j++) {
				System.out.printf("%8d" , tab[j][i]);
			}
			System.out.println();
		}
	}


	public void srednia() {
		double suma = 0;
		int n = 0;

		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[i].length; j++) {
				suma += tab[i][j];
				n++;
			}
		}
		System.out.println("Srednie tablicy: " + (double) suma / n);

	}

}