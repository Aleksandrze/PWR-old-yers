
public class Main {

	public static void main(String[] args) {
	 
		Tablica t= new Tablica(4,5,20);
		t.wyswietlWierszami();
		System.out.println();
		t.wyswietlKolumnami();
		t.sumaElementow();
		t.wartoscMin();
		System.out.println("Czy wystepuje?: " + t.czyWystepuje(15)[0] + " " + t.czyWystepuje(15)[1]);
		t.najwiekszaKolumna();
		System.out.println();
		t.usuwanieWierKol();
		t.wyswietlWierszami();
		
	}

}
