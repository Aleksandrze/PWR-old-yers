package Lista4;

import java.util.Random;

public class TablicaUporzadkowana {

	boolean CzyRoznowart = true;
	public static int[] tab;
	private int rozmiar;

	public TablicaUporzadkowana(int rozmiar) {
		this.rozmiar = rozmiar;
		this.tab = new int[rozmiar];
	}

	public int getRozmiar() {
		return rozmiar;
	}

	public void setRozmiar(int rozmiar) {
		this.rozmiar = rozmiar;
	}

	public void wypelnij(int zakres) {
		Random r = new Random();
		for (int i = 0; i < tab.length; i++)
			tab[i] = r.nextInt(zakres);
		System.out.println("wartość maksymalna w tablicy moze byc = " + zakres);
	}

	public void bubbleSort() {

		for (int i = tab.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {

				if (tab[j] > tab[j + 1]) {
					int tmp = tab[j];
					tab[j] = tab[j + 1];
					tab[j + 1] = tmp;
				}
			}
		}
	}

	public void copi(int x) {
		int[] tab2 = new int[rozmiar++];
		for (int i = 0; i < tab2.length; i++) {
			tab2[i] = x;
		}
		System.arraycopy(tab2, 0, tab, 1, 1);
	}

	public void wyswietl() {
		for (int i = 0; i < tab.length; i++) {
			System.out.print(tab[i] + " ");
		}
		System.out.println();

	}

	public int wstaw(int element) {
		int[] newTab = new int[tab.length + 1];
		int loc = -1;
		for (int i = 0; i < tab.length; i++) {
			if (tab[i] > element) {
				loc = i;
				break;
			}
		}
		for (int j = 0; j < tab.length + 1; j++) {
			if (j < loc)
				newTab[j] = tab[j];
			if (j == loc)
				newTab[j + 1] = loc;
			if (j > loc)
				newTab[j + 2] = tab[j + 1];
		}
		return loc;

	}

	public int sprawdzLiczbe(int w) {

		for (int i = 0; i < tab.length; i++) {
			if (tab[i] == w) {
				System.out.print("liczba " + w + " jest pod indexsem ");
				return i;
			}
		}
		System.out.print("liczb " + w + " brakuie  ");
		return -1;
	}

	public void wyeliminuj() {
		int shift = 0;
		for (int i = 0; i < tab.length; i++) {
			for (int j = i + 1; j < tab.length; j++)
				if (tab[i] == tab[j]) {
					tab[i] = -1;
					shift++;
				}
		}
		if (shift != 0) {
			int j = 0;
			int[] tab2 = new int[tab.length - shift];
			for (int i = 0; i < tab.length; i++) {
				if (tab[i] != -1) {
					tab2[j] = tab[i];
					j++;
				}
			}
			tab = tab2;
		}
	}

	public void usun(int x) {
		int elementX = x;
		int i;
		for (i = 0; i < rozmiar; i++) {
			if (tab[i] == elementX) {
				break;

			}
		}
		for (int k = i; k < rozmiar - 1; k++) {
			tab[k] = tab[k + 1];
			rozmiar--;
		}

	}

	public void usunIndex(int x) {
		int elementX = x;
		int i = 0;
		for (i = 0; i < rozmiar; i++) {
			if (i == elementX) {
				tab[i] = (Integer) 0;
			}
		}
	}

	public void usunWszy(int x) {
		int elementX = x;
		int i;
		for (i = 0; i < tab.length; i++) {
			for (i = 0; i < rozmiar; i++) {
				if (tab[i] == elementX) {
					break;
				}
			}
			for (int k = i; k < rozmiar - 1; k++) {
				tab[k] = tab[k + 1];
				rozmiar--;
			}
		}
	}

	public static void main(String[] args) {

		TablicaUporzadkowana t = new TablicaUporzadkowana(10);

		t.wypelnij(12);
		t.wyswietl();
		System.out.println("-*-*-*-*-*-*-*");
		t.copi(15);
		t.wyswietl();
		System.out.println("*-**-*-*-*-*-*-");

		t.bubbleSort();
		t.wyswietl();
		System.out.println(t.sprawdzLiczbe(15));

		t.wyswietl();
		System.out.println("============");
		t.usun(8);
		t.wyswietl();
		t.usunIndex(2);
		t.wyswietl();
		t.usunWszy(5);
		t.wyswietl();
		t.wyeliminuj();
		t.wyswietl();

	}
}
