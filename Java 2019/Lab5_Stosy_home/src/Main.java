import java.util.Scanner;

public class Main {
//	private Scanner odczyt;
	public static void main(String[] args) {

		try {
			System.out.println("Zadanie 1");
			StosNieogr stosn = new StosNieogr();
			stosn.wyswietl();
			stosn.push("test");
			stosn.push("test1");
			stosn.push("test2");
			stosn.wyswietl();
			System.out.println(stosn.pop());
			System.out.println();
			stosn.wyswietl();
			System.out.println("perk " + stosn.peek());
			System.out.println();
			stosn.wyswietl();

			System.out.println(stosn.pop());
			System.out.println("ost " + stosn.pop());

			stosn.wyswietl();
		} catch (Exception e) {

		}
		System.out.println("Zadanie 3");
		Tests t = new Tests();
		t.odczyt = new Scanner(System.in);
		t.sprawdzStos();
		System.out.println();
		System.out.println("Zadanie 4");
		t.obliczWyrazenia("plik.txt");
		t.odczyt.close();
	}
}