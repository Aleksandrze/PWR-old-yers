import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Tablica2  {

	int indeksWiersze = 0;
	int indeksKolumny = 0;
	StringTokenizer tok;
	double[][] macierz2 = null;
	
	public void wczytajMacierz() {
		int wiersz;
		int kolumna;

		try {
			BufferedReader wczytajZpliku = new BufferedReader(new FileReader("tablica.txt"));
			wczytajZpliku.readLine();

			tok = new StringTokenizer(wczytajZpliku.readLine());
			macierz2 = new double[Integer.valueOf(tok.nextToken())][Integer.valueOf(tok.nextToken())];

			
			for(int i=0;i<macierz2.length;i++) {
				tok = new StringTokenizer(wczytajZpliku.readLine());
				for(int j = 0;j<macierz2[0].length;j++) {
					if(tok.hasMoreTokens()) {
						macierz2[i][j]=Double.valueOf(tok.nextToken());
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < macierz2.length; i++) {
			for (int j = 0; j < macierz2[i].length; j++) {
				System.out.print("\t");

				System.out.printf("%,2f", macierz2[i][j]);

				System.out.print("\t");
			}
			System.out.print("\n");
		}
	}

	public void min() {

		for (int i = 0; i < macierz2.length; i++) {
			for (int j = 0; j < macierz2[i].length; j++) {
				if (macierz2[i][j] < macierz2[indeksWiersze][indeksKolumny]) {
					indeksWiersze = i;
					indeksKolumny = j;
				}
			}
		}
		System.out.println();
		System.out.println(" Min tablicy:  ");
		System.out.printf("%,2f", macierz2[indeksWiersze][indeksKolumny]);
	}

	public void max() {

		for (int i = 0; i < macierz2.length; i++) {
			for (int j = 0; j < macierz2[i].length; j++) {
				if (macierz2[i][j] > macierz2[indeksWiersze][indeksKolumny]) {
					indeksWiersze = i;
					indeksKolumny = j;
				}
			}
		}
		System.out.println();
		System.out.println(" Maz tablicy:  ");
		System.out.printf("%,2f", macierz2[indeksWiersze][indeksKolumny]);
	}

}
