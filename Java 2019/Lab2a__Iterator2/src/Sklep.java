import java.util.ArrayList;
import java.util.Scanner;

import Iterator.IteratorFilt;
import Iterator.IteratorLiczbowy;
import Iterator.IteratorTab;

public class Sklep {
	private Towar[] tab;
	private Towar[] wyczerpane;

	public static void main(String[] args) {
		Sklep klient = new Sklep();

	/*	klient.tab = new Towar[6];
		System.out.println("Lista towarow \n");
		System.out.println("Nazwa \t\t ilosc \t cost \t\t wartosc");
		klient.tab[0] = new Towar("Test 2019", 3, 4500);
		klient.tab[1] = new Towar("MacBook Pro 13", 7, 5000);
		klient.tab[2] = new Towar("Dell Vosto", 1, 1500);
		klient.tab[3] = new Towar("ASUS R510G", 6, 1700);
		klient.tab[4] = new Towar("Air 2016", 0, 3400);
		klient.tab[5] = new Towar("Samsung N9005", 3, 2100);

		klient.wyswietlTowary();
		System.out.println("Zmiana ceny \n");
		klient.zmienCene(klient.tab[5], 1900);
		klient.wyswietlTowary();
		System.out.println("Lista tanszej \n");
		klient.wyswietlTanie();

		klient.wyswietlTanie();*/

		klient.czyPierwsza();

	}

	public void wyswietlTowary() {
		IteratorTab<Towar> it = new IteratorTab<Towar>(tab);
		while (it.hasNext()) {
			it.next().wyswietlTowar();
		}
		System.out.println();
	}

	public void zmienCene(Towar t, int cena) {
		t.setCena(cena);
	}

	public void wyswietlTanie() {
		IteratorFilt<Towar> it = new IteratorFilt<Towar>(new IteratorTab<Towar>(tab), new CzyTani());
		while (it.hasNext())

			it.next().wyswietlTowar();
		System.out.println();
	}

	public void skopiujWyczerpane() {
		ArrayList<Towar> lWyczerpane = new ArrayList<Towar>();
		IteratorFilt<Towar> it = new IteratorFilt<Towar>(new IteratorTab<Towar>(tab), new CzyWyczerpany());
		while (it.hasNext())
			lWyczerpane.add(it.next());
		this.wyczerpane = new Towar[lWyczerpane.size()];
		for (int i = 0; i < lWyczerpane.size(); i++)
			wyczerpane[i] = lWyczerpane.get(i);
	}

	public void czyPierwsza() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Wprowadz przedział od 0 do n");
		int liczba;
		liczba = sc.nextInt();
		IteratorFilt<Integer> it = new IteratorFilt<Integer>(new IteratorLiczbowy(liczba), new CzyPierwsza());
		while (it.hasNext())
			System.out.print(it.next() + " ");
		System.out.println("\n");
	}
}
