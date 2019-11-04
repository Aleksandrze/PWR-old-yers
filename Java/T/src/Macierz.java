import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Macierz {

	double[][] macierz;

	Scanner in = new Scanner(System.in);
	int liczbaW;
	int liczbaK;
	int zakresLiczbOd;
	int zakresLiczbDo;
	int min;
	int max;
	int indeksWiersze = 0;
	int indeksKolumny = 0;

	public Macierz() {

		System.out.print("Podaj liczbę wierszy:");
		this.liczbaW = in.nextInt();
		System.out.print("Podaj liczbę kolumn:");
		this.liczbaK = in.nextInt();
		System.out.print("Podaj zakres liczb od:");
		this.zakresLiczbOd = in.nextInt();
		System.out.print("Podaj zakres liczb do:");
		this.zakresLiczbDo = in.nextInt();
		this.macierz = new double[liczbaW][liczbaK];

		try {
			for (int i = 0; i < macierz.length; i++) {
				for (int j = 0; j < macierz[i].length; j++) {
					macierz[i][j] = (int) (Math.random() * (int) ((zakresLiczbDo - zakresLiczbOd) + zakresLiczbDo));
					System.out.print(macierz[i][j] + " ");
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void zapiszBin(String p1) throws IOException {
		System.out.println(" zapis");

		DataOutputStream fos = new DataOutputStream(new FileOutputStream(p1));

		fos.write((byte) macierz.length);
		fos.write((byte) macierz[0].length);

		for (int i = 0; i < macierz.length; i++)
			for (int j = 0; j < macierz[0].length; j++) {
				fos.writeDouble(macierz[i][j]);
			}

		fos.close();

		System.out.println("Zakonczono ");
	}

	double[][] odczytajMacierz;

	public void czytajBin(String p1) throws IOException {
		System.out.println("Oczytywanie z pliku: " + p1);
		DataInputStream fis = new DataInputStream(new FileInputStream(p1));
		int a, b;
		a = fis.read();
		b = fis.read();
		odczytajMacierz = new double[a][b];
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < b; j++) {
				odczytajMacierz[i][j] = fis.readDouble();
			}
		}

//============================================= W Y D R U K ================================================

		System.out.println();
		for (int i = 0; i < odczytajMacierz.length; i++) {
			for (int j = 0; j < odczytajMacierz[0].length; j++) {
				System.out.print("[");
				System.out.printf("%.2f", odczytajMacierz[i][j]);
				System.out.print("]");
				System.out.print(" ");
			}
			System.out.println();
		}

		System.out.println();

//========================================= Obliczanie Średniej=============================================
	}

	public void min() {

		for (int i = 0; i < macierz.length; i++) {
			for (int j = 0; j < macierz[i].length; j++) {
				if (macierz[i][j] < macierz[indeksWiersze][indeksKolumny]) {
					indeksWiersze = i;
					indeksKolumny = j;
				}
			}
		}
		System.out.println();
		System.out.println(" Min tablicy:  ");
		System.out.printf("%2.2f", macierz[indeksWiersze][indeksKolumny]);
	}

	public void max() {

		for (int i = 0; i < macierz.length; i++) {
			for (int j = 0; j < macierz[i].length; j++) {
				if (macierz[i][j] > macierz[indeksWiersze][indeksKolumny]) {
					indeksWiersze = i;
					indeksKolumny = j;
				}
			}
		}
		System.out.println();
		System.out.println(" Max tablicy:  ");
		System.out.printf("%2.2f", macierz[indeksWiersze][indeksKolumny]);
	}

	public static void main(String[] args) throws IOException {

		Macierz macierz1 = new Macierz();

		macierz1.zapiszBin("plix.txt");

		macierz1.czytajBin("plix.txt");
		macierz1.max();
		macierz1.min();

	}

}
