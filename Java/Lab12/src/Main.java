
public class Main {
	public static void main(String[] args) {

		CopingPlik coping = new CopingPlik();

		coping.Coping();

		Plik c = new Plik("plik02.txt");
		System.out.println("liczba znaków wszystki: " + c.WszystkiZnaki());
		System.out.println("Znaki czarny " + c.ZnakiCzarny());
		System.out.println("liczba wyrazów: " + c.ileWyrazow());
		System.out.println("liczba wierszy: " + c.ileWierszy());
		System.out.println("dlugosc najdulszego wiersza: " + c.najdluzszyWiersz());
		System.out.println("najdugszczy wyraz: " + c.najdluzszyWyraz());

		System.out.println("liczba wystepieñ slowa: " + c.ileRazy());

	}
}
