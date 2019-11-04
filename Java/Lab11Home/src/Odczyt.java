import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Odczyt {

	int min;
	int max;
	int indeksWiersze = 0;
	int indeksKolumny = 0;
	double[][] odczytajMacierz;

	public void czytajBin(String plik) throws IOException {
		System.out.println();
		System.out.println("Oczytywanie: " + plik);
		DataInputStream odczyt = new DataInputStream(new FileInputStream(plik));
		int wiersz = odczyt.read();
		int kolumna = odczyt.read();
		odczytajMacierz = new double[wiersz][kolumna];
		for (int i = 0; i < wiersz; i++) {
			for (int j = 0; j < kolumna; j++) {
				odczytajMacierz[i][j] = odczyt.readDouble();
			}
		}

		System.out.println();
		for (int i = 0; i < odczytajMacierz.length; i++) {
			for (int j = 0; j < odczytajMacierz[0].length; j++) {
				System.out.printf("%.2f", odczytajMacierz[i][j]);
				System.out.print("\t");
			}
			System.out.print("\n");
		}

	}

	public void min() {

		for (int i = 0; i < odczytajMacierz.length; i++) {
			for (int j = 0; j < odczytajMacierz[i].length; j++) {
				if (odczytajMacierz[i][j] < odczytajMacierz[indeksWiersze][indeksKolumny]) {
					indeksWiersze = i;
					indeksKolumny = j;
				}
			}
		}
		System.out.println();
		System.out.println("Min tablicy:  ");
		System.out.printf("%2.2f", odczytajMacierz[indeksWiersze][indeksKolumny]);
	}

	public void max() {

		for (int i = 0; i < odczytajMacierz.length; i++) {
			for (int j = 0; j < odczytajMacierz[i].length; j++) {
				if (odczytajMacierz[i][j] > odczytajMacierz[indeksWiersze][indeksKolumny]) {
					indeksWiersze = i;
					indeksKolumny = j;
				}
			}
		}
		System.out.println();
		System.out.println("Max tablicy:  ");
		System.out.printf("%2.2f", odczytajMacierz[indeksWiersze][indeksKolumny]);
	}

}
