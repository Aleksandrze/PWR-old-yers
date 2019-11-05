import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		System.out.println("Tworzymy drzewo BST");
		Drzewa bts = new Drzewa();
		int[] liczby = { 5, 3, 7, 1, 4, 0, 2, 6, 10, 9 };
		System.out.print("Dodajemy do drzewa elementy: ");
		for (int l : liczby) {
			System.out.print(l + " ");
			bts.dodaj(l);
		}
		System.out.println("\n");

		System.out.println(bts.przegladInOrder());
		System.out.println(bts.przegladPreOrder());
		System.out.println(bts.przegladPostOrder());
		System.out.println("Rysunek:");
		bts.displayTree();
		System.out.println();

		System.out.println(bts.znajdz(2));
		System.out.println(bts.znajdz(11));
		System.out.println();

		System.out.println("Klucz minimalny: " + bts.min());
		System.out.println("Klucz maksymalny: " + bts.max());
		System.out.println();

		System.out.println("Wysokość: " + bts.znajdzWysokosc());
		System.out.println("Liczba węzłów: " + bts.iloscWezlow());
		System.out.println("Liczba liści: " + bts.iloscLisc());
		System.out.println();

		while (true) {
			Scanner sc = new Scanner(System.in);
			String choice;
			int value;
			System.out.print("Wpisz rozkaz, (dodaj, znajdz, usun, pokaz, nastepnik, poprzednik): ");
			choice = sc.next();

			switch (choice.toUpperCase()) {
			case "DODAJ":
				System.out.print("Enter dla dodowania: ");
				value = Integer.parseInt(sc.next());
				bts.dodaj(value);
				break;
			case "ZNAJDZ":
				System.out.print("Enter dla szukania:  ");
				value = Integer.parseInt(sc.next());
				System.out.println(bts.znajdz(value));
				System.out.print("\n");
				break;
			case "USUN":
				System.out.print("Enter dla delete: ");
				value = Integer.parseInt(sc.next());
				bts.delete(value);
				break;
			case "POKAZ":
				bts.displayTree();
				break;
			case "NASTEPNIK":
				System.out.print("Enter dla nastepnika: ");
				value = Integer.parseInt(sc.next());
				System.out.println("Następnik dla " + value + " jest: " + bts.successor(value));
				break;
			case "POPRZEDNIK":
				System.out.print("Enter poprzednik: ");
				value = Integer.parseInt(sc.next());
				System.out.println("Poprzednik dla " + value + " jest: " + bts.predecessor(value));
				break;
			default:
				sc.close();
				break;
			}
		}
	}
}
