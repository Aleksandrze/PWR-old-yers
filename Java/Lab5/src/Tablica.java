import java.util.Random;

public class Tablica {
	int rozmiar;
	boolean CzyRoznowart = true;

	public static int[] tab;

	public Tablica(int rozmiar) {
		this.rozmiar = rozmiar;
		this.tab = new int[rozmiar];
	}

	public void wypelnij(int zakres) {
		Random r = new Random();
		for (int i = 0; i < tab.length; i++)
			tab[i] = r.nextInt(zakres);
	}

	public void wyswietl() {
		for (int i = 0; i < tab.length; i++) {
			System.out.print(tab[i] + " ");
		}
		System.out.println();
	}

	public void odwroc(int[] tab) {
		int poczatek = 0;
		int koniec = tab.length - 1;
		while (poczatek < koniec) {
			int pomoc = tab[poczatek];
			tab[poczatek] = tab[koniec];
			tab[koniec] = pomoc;
			poczatek++;
			koniec--;
		}
		System.out.println("Tabica odwrotna");
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

	public void MaxMin() {
		int indexMin = 0;
		int indexMax = 0;
		int Max = tab[0];
		int Min = tab[0];
		for (int i = 0; i < tab.length; i++) {

			if (tab[i] < Min) {
				Min = tab[i];
				indexMin = i;

			}
			if (tab[i] > Max) {
				Max = tab[i];
				indexMax = i;
			}
		}
		System.out.println("Wartosc min = " + Min + ". Jej indeks jest to " + indexMin);
		System.out.println("Wжджэ.artosc max = " + Max + ". Jej indeks jest to " + indexMax);
	}

	public double sredn() {
		double maxsred = 0;
		double sd = 0;
		for (int i = 0; i < tab.length; i++) {
			maxsred = maxsred + tab[i];
		}
		maxsred = maxsred / rozmiar;
		for (int i = 0; i < tab.length; i++) {
			sd += ((tab[i] - maxsred) * (tab[i] - maxsred)) / (tab.length - 1);
		}
		System.out.println("odchylenia standardowego " + Math.sqrt(sd));
		System.out.print("Srednia wartosc = ");
		return maxsred;
	}

	public boolean CzyRoznowart() {

		for (int i = 0; i < tab.length; i++) {
			for (int j = 1; j < tab.length; j++) {
				if (tab[i] == tab[j] && i != j) {
					return false;
				}
			}
		}
		return true;
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

	public static void main(String[] args) {

		Tablica t = new Tablica(20);

		t.wypelnij(15);
		t.wyswietl();
		t.odwroc(tab);
		t.wyswietl();
		System.out.println(t.sprawdzLiczbe(5));
		t.MaxMin();
		System.out.println(t.sredn());
		System.out.println("Czy tablica jest Roznowartosciewa? " + t.CzyRoznowart());
		t.zrobRoznoWart();
		t.wyswietl();
		System.out.println("Czy tablica jest Roznowartosciewa? " + t.CzyRoznowart());

	}
}

//kolokwium 1= 1 punktow;
