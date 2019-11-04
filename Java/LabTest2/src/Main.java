
public class Main {
	public static void main(String[] args) {
		
		
		Przetwarzanie p = new Przetwarzanie("staryplik.txt", "nowyplik.txt");


		Plik c = new Plik("nowyplik.txt");
		System.out.println("liczba wierszy: " + c.ileWierszy());
		System.out.println("liczba znaków: " + c.ileZnakow());
		System.out.println("dlugoæ najdulszego wiersza: " + c.najdluzszyWiersz());
		System.out.println("liczba wyrazów: " + c.ileWyrazow());
		System.out.println("liczba wystepieñ slowa: " + c.ileRazy());

	}

}

