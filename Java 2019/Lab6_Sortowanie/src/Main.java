public class Main {
	public static void main(String[] args) {

		Osoba[] tab = new Osoba[5];

		
		ComparNazwisko nazwisko = ComparNazwisko.INSTANCE;
		ComparWiek wiek = ComparWiek.INSTANCE;
		ComparImie imie = ComparImie.INSTANCE;
		ZlozonyComparator zlozonyfunkcja = ZlozonyComparator.INSTANCE;
		ComparCompar zlozonyArrayList = new ComparCompar();
		zlozonyArrayList.addComarator(nazwisko);
		zlozonyArrayList.addComarator(imie);
		zlozonyArrayList.addComarator(wiek);

		System.out.println("\n Nie Sortowana");
		tab[0] = new Osoba("KLimenkov", "Aleksandr", 21);
		tab[1] = new Osoba("Zlikaricz", "Zygmunt", 24);
		tab[2] = new Osoba("Wild", "Qwort", 28);
		tab[3] = new Osoba("Bot", "Qwerty", 23);
		tab[4] = new Osoba("Brin", "Tess", 23);
		for (int i = 0; i < tab.length; i++) {
			System.out.println(tab[i]);
		}
		System.out.println("\n posotrowana po nazwisko/imie/wiek prosty");
		Sortowanie sort = new Sortowanie(nazwisko);
		System.out.println();
		tab = (Osoba[]) sort.sort(tab);
		for (int i = 0; i < tab.length; i++) {
			System.out.println(tab[i]);
		}

		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=---=-=-=-=-=-===-=-=-=-=-=-=-=-=-=

/*		System.out.println("\n Nieposotrowana");
		tab = new Osoba[10];
		tab[0] = new Osoba("KLimenkov", "Aleksandr", 21);
		tab[1] = new Osoba("Zlikaricz", "Zygmunt", 24);
		tab[2] = new Osoba("absd", "qwerty", 28);
		tab[3] = new Osoba("abcd", "Anna", 23);
		tab[4] = new Osoba("Test", "Test", 23);
		tab[5] = new Osoba("Dandys", "Ilona", 22);
		tab[6] = new Osoba("Zlikarija", "Aleksa", 23);
		tab[7] = new Osoba("absd", "qwerty", 27);
		tab[8] = new Osoba("abcd", "Anna", 26);
		tab[9] = new Osoba("Test", "Test", 26);
		for (int i = 0; i < tab.length; i++) {
			System.out.println(tab[i]);
		}

		System.out.println("\nComparator zlozony z prostych na ArrayList");
		Sortowanie sort1 = new Sortowanie(zlozonyArrayList);
		tab = (Osoba[]) sort1.sort(tab);
		for (int i = 0; i < tab.length; i++) {
			System.out.println(tab[i]);
		}*/

		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=---=-=-=-=-=-===-=-=-=-=-=-=-=-=-=

		System.out.println("\n Nieposotrowana");
		tab = new Osoba[10];
		tab[0] = new Osoba("KLimenkov", "Aleksandr", 21);
		tab[1] = new Osoba("Zlikaricz", "Zygmunt", 24);
		tab[2] = new Osoba("Absd", "Qwerty", 28);
		tab[3] = new Osoba("Abcd", "Anna", 23);
		tab[4] = new Osoba("Test", "Test", 23);
		tab[5] = new Osoba("Dandys", "Ilona", 22);
		tab[6] = new Osoba("Zlikarija", "Aleksa", 23);
		tab[7] = new Osoba("Absd", "Qwerty", 27);
		tab[8] = new Osoba("Abcd", "Anna", 26);
		tab[9] = new Osoba("Test", "Test", 26);
		for (int i = 0; i < tab.length; i++) {
			System.out.println(tab[i]);
		}
System.out.println("\n Sortowanie");
	/*	System.out.println("\nComparator zlozony z prostych na funkcji");*/
		Sortowanie sort11 = new Sortowanie(zlozonyfunkcja);
		tab = (Osoba[]) sort11.sort(tab);
		for (int i = 0; i < tab.length; i++) {
			System.out.println(tab[i]);
		}
	}
}
