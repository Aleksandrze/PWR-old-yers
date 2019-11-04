package Tablica6a;

import java.util.Random;

public class Tablica {
	int[][] tablica;
	int liczbaKolumn;
	int liczbaWierszy;

	public Tablica(int liczbaKolumn, int liczbaWierszy, int zakres) {
		tablica = new int[liczbaWierszy][liczbaKolumn];
		this.liczbaKolumn = liczbaKolumn;
		this.liczbaWierszy = liczbaWierszy;
		Random r = new Random();
		for (int i = 0; i < liczbaKolumn; i++) {
			for (int j = 0; j < liczbaWierszy; j++) {
				tablica[j][i] = r.nextInt(zakres);
			}
		}
	}

	public void wyswietlWierszami() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < liczbaWierszy; i++) {
			for (int j = 0; j < liczbaKolumn; j++) {
				sb.append(tablica[i][j]);
				sb.append(", ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

//transponowana
	public void transponowana() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < liczbaKolumn; i++) {
			for (int j = 0; j < liczbaWierszy; j++) {
				sb.append(tablica[j][i]);
				sb.append(", ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public void sumaElementow() {
		int suma = 0;
		for (int[] wiersz : tablica) {
			for (int element : wiersz) {
				suma += element;
			}
		}
		System.out.println("Suma elementow: " + suma);
	}

	public void wartoscMaksymalna() {
		int indeksWiersze = 0;
		int indeksKolumny = 0;
		for (int i = 0; i < liczbaWierszy; i++) {
			for (int j = 0; j < liczbaKolumn; j++) {
				if (tablica[i][j] > tablica[indeksWiersze][indeksKolumny]) {
					indeksWiersze = i;
					indeksKolumny = j;
				}
			}
		}
		System.out.println("Element maksymalny: " + tablica[indeksWiersze][indeksKolumny] + " indeks: [" + indeksWiersze
				+ "][" + indeksKolumny + "]");
	}

	public int[] czyWystepuje(int liczba) {
		for (int i = 0; i < liczbaWierszy; i++) {
			for (int j = 0; j < liczbaKolumn; j++) {
				if (tablica[i][j] == liczba) {
					int[] wynik = { i, j };
					return wynik;
				}
			}
		}
		int[] wynik = { -1, -1 };
		return wynik;
	}

// najwiekszyWiersz
	public void najwiekszyWiersz() {
		int[] sumy = new int[liczbaWierszy];
		for (int i = 0; i < liczbaWierszy; i++) {
			for (int j = 0; j < liczbaKolumn; j++) {
				sumy[i] += tablica[i][j];
			}
		}
		int indeksMax = 0;
		for (int k = 0; k < sumy.length; k++) {
			if (sumy[k] > sumy[indeksMax])
				indeksMax = k;
		}
		System.out.println("Najwieksza suma elementow wierszy: " + indeksMax + ", suma: " + sumy[indeksMax]);
	}

// Break
	public boolean CzyRoznowart() {
		for (int i = 0; i < liczbaWierszy; i++) {
			for (int j = 0; j < liczbaKolumn; j++) {
				for (int w2 = 1; w2 < liczbaWierszy-1; w2++) {
					for (int k2 = 1; k2 < liczbaKolumn-1; k2++) {
						if (tablica[i][j] == tablica[w2][k2] && !((i==w2)&&(j==k2))) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

}
