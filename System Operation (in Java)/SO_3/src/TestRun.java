import java.util.ArrayList;
import java.util.Random;

public class TestRun {
	static int iloscRamek = 15;
	static int iloscStron = 5;
	static int iloscOdwolan = 1000;
	ArrayList<PamiecWirtualna> strony = new ArrayList<PamiecWirtualna>();
	ArrayList<Integer> odwolania = new ArrayList<Integer>();
	Random r = new Random();

	/*
	 * Wygenerowanie losowego ciaga "n" odwolan od strony.
	 */
	public void randomizer() {
		for (int i = 0; i < iloscOdwolan; i++) {
			odwolania.add(r.nextInt(iloscRamek) + 1);
		}
	}

	public void start() {
		PamiecWirtualna pam = new PamiecWirtualna(0, 0);
		for (int i = 0; i < iloscStron; i++) {
			strony.add(pam);
		}
	}

	public void clear() {
		PamiecWirtualna mem = new PamiecWirtualna(0, 0);
		for (int i = 0; i < iloscStron; i++) {
			strony.set(i, mem);
		}
	}

	/*
	 * FIFO (usuwamy strone najdluzej przebywajaca w pamieci fizycznej)
	 */
	public void algorytmFIFO() {
		int brakStron = 0;
		boolean czyWyk = false;
		for (int i = 0; i < iloscOdwolan; i++) {
			for (int j = 0; j < iloscStron && !czyWyk; j++) {
				if (strony.get(j).wartosc == odwolania.get(i)) {
					czyWyk = true;
				}
				if (strony.get(j).wartosc == 0) {
					PamiecWirtualna mem = new PamiecWirtualna(odwolania.get(i), 0);
					strony.set(j, mem);
					brakStron++;
					czyWyk = true;
				}
			}
			if (czyWyk == false) {
				strony.remove(0);
				PamiecWirtualna mem = new PamiecWirtualna(odwolania.get(i), 0);
				strony.add(mem);
				brakStron++;
			}
			czyWyk = false;
		}
		System.out.println("Ilość błędów braku stron dla algorytmu FIFO wynosi: " + brakStron);
		clear();
	}

	/*
	 * OPT (optymalny - usuwamy strone, ktora nie bedzie najdluzej uzywana)
	 */
	public void algorytmOPT() {
		int brakStron = 0;
		boolean czyWyk = false;
		for (int i = 0; i < iloscOdwolan; i++) {
			for (int j = 0; j < iloscStron && !czyWyk; j++) {
				if (strony.get(j).wartosc == odwolania.get(i)) {
					czyWyk = true;
				}
				if (strony.get(j).wartosc == 0) {
					PamiecWirtualna mem = new PamiecWirtualna(odwolania.get(i), 0);
					strony.set(j, mem);
					brakStron++;
					czyWyk = true;
				}
			}
			if (czyWyk == false) {
				int pom = 0;
				for (int j = 0; j < iloscStron; j++) {
					for (int k = i; k < iloscOdwolan; k++) {
						if (strony.get(j).wartosc != odwolania.get(k)) {
							pom++;
						} else {
							PamiecWirtualna pamiec = new PamiecWirtualna(strony.get(j).wartosc, pom);
							strony.set(j, pamiec);
							break;
						}
					}
					pom = 0;
				}
				pom = 0;
				int index = 0;
				for (int l = 0; l < iloscStron; l++) {
					if (strony.get(l).bitPom > pom) {
						pom = strony.get(l).bitPom;
						index = l;
					}
				}
				strony.remove(index);
				PamiecWirtualna memr = new PamiecWirtualna(odwolania.get(i), 0);
				strony.add(memr);
				brakStron++;
			}
			czyWyk = false;
		}
		System.out.println("Ilość błędów braku stron dla algorytmu OPT wynosi: " + brakStron);
		clear();
	}

	/*
	 * LRU (usuwamy strone, do ktorej najdluzej nie nastapilo odwolanie) Least
	 * Recently Used - Najmniej Ostatnio Używany algorytm stronicowania polegający
	 * na zastępowaniu w cache'u w pierwszej kolejności strony używanej najdawniej.
	 * Wymaga on informacji o tym, kiedy poszczególne strony były używane, co jest
	 * procesem kosztownym czasowo, jeśli chce się uzyskać pewność, że wyrzuca się
	 * rzeczywiście stronę używaną najdawniej.
	 * 
	 * Licznik i Stosy
	 */
	public void algorytmLRU() {
		int brakStron = 0;
		boolean czyWyk = false;
		for (int i = 0; i < iloscOdwolan; i++) {
			for (int j = 0; j < iloscStron && !czyWyk; j++) {
				if (strony.get(j).wartosc == odwolania.get(i))// strony==ramki
				{
					PamiecWirtualna mem = new PamiecWirtualna(odwolania.get(i), 0);
					strony.set(j, mem);
					for (int k = 0; k < iloscStron; k++) {
						if (strony.get(k).wartosc != odwolania.get(i)) {
							int zp = strony.get(k).wartosc;
							int zp2 = strony.get(k).bitPom;
							PamiecWirtualna pam = new PamiecWirtualna(zp, (zp2) + 1);
							strony.set(k, pam);
						}
					}
					czyWyk = true;
				}
				if (strony.get(j).wartosc == 0) {
					PamiecWirtualna mem = new PamiecWirtualna(odwolania.get(i), 0);
					strony.set(j, mem);
					brakStron++;
					czyWyk = true;
				}
			}
			if (czyWyk == false) {
				int zp3 = 0;
				int index = 0;
				for (int l = 0; l < iloscStron; l++) {
					if (strony.get(l).bitPom > zp3) {
						zp3 = strony.get(l).bitPom;
						index = l;
					}
				}
				strony.remove(index);
				PamiecWirtualna memr = new PamiecWirtualna(odwolania.get(i), 0);
				strony.add(memr);
				brakStron++;
			}
			czyWyk = false;
		}
		System.out.println("Ilość błędów ,braku stron dla algorytmu LRU wynosi: " + brakStron);
		clear();
	}

	public void algorytmALRU() {
		int brakStron = 0;
		boolean czyWyk = false;
		for (int i = 0; i < iloscOdwolan; i++) {
			for (int j = 0; j < iloscStron && !czyWyk; j++) {
				if (strony.get(j).wartosc == odwolania.get(i)) {
					PamiecWirtualna mem = new PamiecWirtualna(odwolania.get(i), 1);
					strony.set(j, mem);
					czyWyk = true;
				}
				if (strony.get(j).wartosc == 0) {
					PamiecWirtualna mem = new PamiecWirtualna(odwolania.get(i), 0);
					strony.set(j, mem);
					brakStron++;
					czyWyk = true;
				}
			}
			if (czyWyk == false) {
				boolean czyWstaw = false;
				while (czyWstaw == false) {
					for (int k = 0; k < iloscStron; k++) {
						if (strony.get(k).bitPom == 1) {
							PamiecWirtualna memr = new PamiecWirtualna(strony.get(k).wartosc, 0);
							strony.set(k, memr);
						} else {
							strony.remove(k);
							PamiecWirtualna memr2 = new PamiecWirtualna(odwolania.get(i), 0);
							strony.add(memr2);
							brakStron++;
							czyWstaw = true;
							break;
						}
					}
				}
			}
			czyWyk = false;
		}
		System.out.println("Ilość błędó, braku stron, dla algorytmu ALRU wynosi: " + brakStron);
		clear();
	}

	/*
	 * RAND (usuwamy losowo wybrana strone)
	 */
	public void algorytmRAND() {
		int brakStron = 0;
		boolean czyWyk = false;
		for (int i = 0; i < iloscOdwolan; i++) {
			for (int j = 0; j < iloscStron && !czyWyk; j++) {
				if (strony.get(j).wartosc == odwolania.get(i)) {
					czyWyk = true;
				}
				if (strony.get(j).wartosc == 0) {
					PamiecWirtualna mem = new PamiecWirtualna(odwolania.get(i), 0);
					strony.set(j, mem);
					brakStron++;
					czyWyk = true;
				}
			}
			if (czyWyk == false) {
				int losowyIndex = r.nextInt(iloscStron);
				strony.remove(losowyIndex);
				PamiecWirtualna memr = new PamiecWirtualna(odwolania.get(i), 0);
				strony.add(memr);
				brakStron++;
			}
			czyWyk = false;
		}
		System.out.println("Ilość błędów,braku stron, dla algorytmu RAND wynosi: " + brakStron);
		clear();
	}
}
