package Hotel;

public class Hotel {
	int[][] tablica;

	int s = 1;
	int pietro;
	int pokoj;

	public Hotel(int pietro, int pokoj) {
		tablica = new int[pokoj][pietro];

		this.pietro = pietro;
		this.pokoj = pokoj;
		for (int i = 0; i < pokoj; i++) {
			for (int j = 0; j < pietro; j++) {
				tablica[i][j] = s++;
			}
		}
	}

	public void wyswietlWierszami() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < pokoj; i++) {
			for (int j = 0; j < pietro; j++) {
				sb.append(tablica[i][j]);
				sb.append(", ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public String czyJestWolny() {
		for (int i = 0; i < pokoj; i++) {
			for (int j = 0; j < pietro; j++) {
				if (tablica[i][j] != 0) {
					return "Jest wolny pokoj";
				}
			}
		}
		return "Nie ma wolnego pokoja";

	}

	public void Wynajm(int x) {
		for (int i = 0; i < pokoj; i++) {
			for (int j = 0; j < pietro; j++) {
				if (tablica[i][j] == x) {
					tablica[i][j] = 0;
					int indexI = i;
					int indexJ = j;
					System.out.println("Index pokoju = (" + i + " | " + j + ")");
				}
			}
		}
	}

	public String WynajmKilka(int k) {
		int f=0;
		for (int i = 0; i < pokoj; i++) {
			for (int j = 0; j < pietro; j++) {
				if (tablica[i][j] != 0) {
					f++;
				
					if(k==f && tablica[i][j] != 0) {
						System.out.println(tablica[i][j]);
					}
				}
			}
		}
		return "null";
	}

	public static void main(String[] args) {

		Hotel t = new Hotel(4, 5);

		t.wyswietlWierszami();
		System.out.println(t.czyJestWolny());
		t.Wynajm(13);
		t.Wynajm(1);
		t.Wynajm(5);
		t.wyswietlWierszami();
		t.WynajmKilka(4);
		

	}

}
