package Tablica6a;

public class Main {

	public static void main(String[] args) {

		Tablica t = new Tablica(5, 5,20);

		t.wyswietlWierszami();
		t.transponowana(); //transponowana
		t.sumaElementow();
		t.wartoscMaksymalna();
		System.out.println("Czy wystepuje?: " + t.czyWystepuje(15)[1] + " " + t.czyWystepuje(15)[0]);
		t.najwiekszyWiersz();
		System.out.println(t.CzyRoznowart());

	}

}
