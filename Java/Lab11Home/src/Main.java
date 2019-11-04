import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

		Zapisz macierz1 = new Zapisz();

		macierz1.zapiszBin("plix.bin");

		Odczyt od = new Odczyt();
		od.czytajBin("plix.bin");
		od.max();
		od.min();

	}
}
