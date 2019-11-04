package Lista4;

import java.util.Random;

public class Tablica {

	public static int[] tab;
	private int rozmiar;

	@SuppressWarnings("static-access")
	public Tablica(int rozmiar) {
		this.rozmiar = rozmiar;
		this.tab = new int[rozmiar];
	}

	public int getRozmiar() {
		return rozmiar;
	}

	public void setRozmiar(int rozmiar) {
		this.rozmiar = rozmiar;
	}

	// -*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*

	public void wypelnij(int zakres) {
		Random r = new Random();
		for (int i = 0; i < tab.length; i++)
			tab[i] = r.nextInt(zakres);
		System.out.println("wartość maksymalna w tablicy moze byc = " + zakres);
	}

	public void wyswietl() {
		for (int i = 0; i < tab.length; i++) {
			System.out.print(tab[i] + " ");
		}
		System.out.println();
	}

	public double sredn() {
		double maxsred = 0;
		for (int i = 0; i < tab.length; i++) {
			maxsred = maxsred + tab[i];
		}
		System.out.println("Suma wartości elementów tablicy = " + maxsred);
		return maxsred;
	}

	public void MaxMin() {

		int indexMax = 0;
		int Max = tab[0];

		for (int i = 0; i < tab.length; i++) {

			if (tab[i] > Max) {
				Max = tab[i];
				indexMax = i;
			}
		}
		System.out.println("Wartosc max = " + Max + ". Jej indeks jest to " + indexMax);
	}

	public String CzyRoznowart() {

		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab.length; j++) {
				if (tab[i] == tab[j] && i != j) {
					return "false";
				}
			}
		}
		return "true";
	}

	public boolean sprawdzLiczbe(int xVal, int Klinght) {

		if (Klinght > tab.length) {
			return false;
		}
		for (int i = 0; i < Klinght; i++) {
			if (tab[i] == xVal) {

				return true;
			}
		}

		return false;
	}

	public void zrobRoznoWart() {
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

		Tablica t = new Tablica(20);

		t.wypelnij(20);
		t.wyswietl();
		t.sredn();
		t.MaxMin();
		System.out.println(t.sprawdzLiczbe(5, 4));


		t.usun(8);
		t.wyswietl();
		t.zrobRoznoWart();
		t.wyswietl();

	}
}
