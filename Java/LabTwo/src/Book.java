
public class Book {

	String autor;
	String tytul;
	int strony;
	boolean wypozyczona;

	public Book(String autor, String tytul, int strony) {
		this.wypozyczona = false;
		this.autor = autor;
		this.tytul = tytul;
		this.strony = strony;

	}

	public void wyswietl() {
		System.out.println("Autor : " + autor);
		System.out.println("Tytul : " + tytul);
		System.out.println("Strony : " + strony);
	}

	public boolean czyDostepna() {
		if (wypozyczona == false) {
			System.out.println("Ksenzka dostepna");
			return true;
		} else {
			System.out.println("Ksenzka teraz nie dostepna");
		}
		return false;
	}

	public void wypozycz() {
		if (wypozyczona == false) {
			System.out.println("OK");
			this.wypozyczona = true;
		} else
			System.out.println("Ksiazka juz jest wypoczona");
	}

	public void zwrot() {
		this.wypozyczona = false;
		System.out.println("Ksiezka zworcana");
	}

	public static void main(String[] args) {
		Book autor = new Book("Mickewicz", "Dziady", 300);
		autor.wyswietl();
		System.out.println("------");
		autor.wypozycz();
		autor.wypozycz();
		System.out.println("------");
		autor.zwrot();
		autor.czyDostepna();
	}

}
