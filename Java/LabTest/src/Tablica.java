import java.util.Random;

public class Tablica {
	int[][] tablica;
	int[][] newTablica;

	int liczbaKolumn;
	int liczbaWierszy;

	public Tablica(int liczbaKolumn, int liczbaWierszy, int zakres) {
		tablica = new int[liczbaWierszy][liczbaKolumn];
		newTablica = new int[liczbaWierszy][liczbaKolumn];
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

	public void wyswietlKolumnami() {
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

	public void wartoscMin() {
		int indeksWiersze = 0;
		int indeksKolumny = 0;
		for (int i = 0; i < liczbaWierszy; i++) {
			for (int j = 0; j < liczbaKolumn; j++) {
				if (tablica[i][j] < tablica[indeksWiersze][indeksKolumny]) {
					indeksWiersze = i;
					indeksKolumny = j;
				}
			}
		}
		System.out.println("Element minimalna: " + tablica[indeksWiersze][indeksKolumny] + " indeks: [" + indeksWiersze
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

	public void najwiekszaKolumna() {
		int[] sumy = new int[liczbaKolumn];
		for (int j = 0; j < liczbaKolumn; j++) {
			for (int i = 0; i < liczbaWierszy; i++) {
				sumy[j] += tablica[i][j];
			}
		}
		int indeksMax = 0;
		for (int k = 0; k < sumy.length; k++) {
			if (sumy[k] > sumy[indeksMax])
				indeksMax = k;
			System.out.print(sumy[k] + " , ");
		}
		System.out.println();
		System.out.println("Najwieksza suma elementow Kolumny: " + indeksMax + ", suma: " + sumy[indeksMax]);

	}

	public void usunuc() {
		int max = 0;
		int indeksWiersze = 0;
		int indeksKolumny = 0;
		int[][] newTablica = new int[liczbaWierszy -1][liczbaKolumn -1];

		for (int i = 0; i < liczbaWierszy; i++) {
			for (int j = 0; j < liczbaKolumn; j++) {
				if (max < tablica[i][j]) {
					max = tablica[i][j];
					indeksWiersze = i;
					indeksKolumny = j;
				}

			}
		}

		for (int i = 0; i < liczbaWierszy - 1; i++) {
			for (int j = 0; j < liczbaKolumn - 1; j++) {
				if (i == indeksWiersze) {
					newTablica[i][j] = tablica[i+1][j];
				} else
					newTablica[i][j] = tablica[i][j];
				if (j == indeksKolumny) {
					newTablica[i][j] = tablica[i][j + 1];
				} else
					newTablica[i][j] = tablica[i][j];

			}
		}

		for (int i = 0; i < tablica.length; i++) {
			for (int j = 0; j < tablica.length; j++) {
				System.out.print(tablica[i][j] + " , ");

			}
			System.out.println("");
		}
		System.out.println("-----");
		for (int i = 0; i < newTablica.length; i++) {
			for (int j = 0; j < newTablica.length; j++) {
				System.out.print(newTablica[i][j] + " , ");

			}
			System.out.println(" ");
		}
	}
}
