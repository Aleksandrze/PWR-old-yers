public class Main {

	public static void main(String[] args) {

		Tablica t = new Tablica(5, 6, 50);

		t.wyswietlWierszami();
		t.wyswietlKolumnami();
		t.sumaElementow();
		t.wartoscMin();
		System.out.println("Czy wystepuje?: " + t.czyWystepuje(15)[0] + " " + t.czyWystepuje(15)[0]);
		t.najwiekszaKolumna();
		t.usunuc();

	}
}