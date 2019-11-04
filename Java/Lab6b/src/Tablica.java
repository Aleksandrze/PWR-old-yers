import java.util.Random;

public class Tablica {
	int[][] tablica;

	int zakres;
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
		for (int[] row : tablica) {
			for (int element : row) {
				System.out.print(element + " ");
			}
			System.out.println();
		}
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
		int sum = 0;		
				int sred =0;
		for (int[] wiersz : tablica) {
			for (int element : wiersz) {
				sum += element;
				
			}
			
		}
		sred  =  sum/(liczbaWierszy*liczbaKolumn);

/*		for (int i = 0; i < liczbaKolumn; i++) {
			for (int j = 0; j < tablica[i].length; j++) {
				sum=sum +tablica[i][j];
		}
			}*/
		System.out.println("Suma elementow: " + sum+" test "+ sred);
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
		System.out.println("Najwieksza suma elementow Kolumny: " + indeksMax + ", suma = " + sumy[indeksMax]);

	}

	public void usuwanieWierKol() {
		System.out.println("Usuwanie wiersza i kolumny");
		int max = tablica[0][0];
		int indexMaxX = 0, indexMaxY = 0;
		for (int i = 0; i < tablica.length; i++) {
			for (int j = 0; j < tablica[i].length; j++)
				if (tablica[i][j] > max) {
					max = tablica[i][j];
					indexMaxX = i;
					indexMaxY = j;
				}
		}
		System.out.println("Max to: " + max + " i wsporzedne: [" + indexMaxX + "][" + indexMaxY + "]");
		int[][] tab2 = new int[tablica.length - 1][tablica[0].length - 1];
		int a = 0, b = 0;
		for (int i = 0; i < tablica.length; i++) {
			if (i != indexMaxX) {
				for (int j = 0; j < tablica[0].length; j++) {
					if (j != indexMaxY) {
						tab2[a][b] = tablica[i][j];
						b++;
					}
				}
				b = 0;
				a++;
			}
		}
		tablica = tab2;
	}

}
