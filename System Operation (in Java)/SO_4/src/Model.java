import java.util.ArrayList;
import java.util.Random;

public class Model {
	Random r = new Random();
	static int liczbaRamek = 100;
	static int liczbaProcesow = 10;
	static int iloscOdwolan = 1000;
	static int maxProg = 2;
	static int minProg = -15;
	static int oknoZbioruR = 8;
	static int zrSize = 20;
	ArrayList<Proces> procesy = new ArrayList<Proces>();
	ArrayList<PamiecFiz> ramki = new ArrayList<PamiecFiz>();
	ArrayList<Integer> przydz = new ArrayList<Integer>();

	public void dodajProcesy() {
		for (int i = 0; i < liczbaProcesow; i++) {
			int liczbaStron = r.nextInt(10) + 5;
			ArrayList<Integer> odwolania = new ArrayList<Integer>();
			for (int j = 0; j < iloscOdwolan; j++) {
				odwolania.add(r.nextInt(liczbaStron) + 1);
			}
			procesy.add(new Proces(liczbaStron, odwolania, 0, 0));
		}
		init();
	}

	public void init() {
		PamiecFiz pam = new PamiecFiz(0, 0);
		for (int i = 0; i < liczbaRamek; i++) {
			ramki.add(pam);
		}
	}

	public void clear() {
		PamiecFiz mem = new PamiecFiz(0, 0);
		for (int i = 0; i < liczbaRamek; i++) {
			ramki.set(i, mem);
		}
	}

	public Proces getp(int i) {
		return procesy.get(i);
	}

	/*
	 * Przydział równy (ang. equal allocation) - np. jeli mamy 100 ramek i 5
	 * procesów, to każdy proces może dostać 20 ramek
	 */

	public void przydzialRowny() {
		for (int i = 0; i < liczbaProcesow; i++) {
			int p = liczbaRamek / liczbaProcesow;
			przydz.add(p);
		}

	}
	/*
	 * Przydział proporcjonalny (ang. proportional allocation) - każdemu procesowi
	 * przydziela się dostępnš pamięć proporcjonalnie do jego rozmiaru
	 */

	public void przydzialProporcjonalny() {
		int suma = 0;
		for (int i = 0; i < liczbaProcesow; i++) {
			suma += getp(i).liczbaStron;
		}
		for (int j = 0; j < liczbaProcesow; j++) {
			double p = (getp(j).liczbaStron * liczbaRamek) / suma;
			przydz.add((int) p);
		}
	}

	/*
	 * LRU (usuwamy strone, do ktorej najdluzej nie nastapilo odwolanie);
	 * 
	 * Najmniej Ostatnio Używany algorytm stronicowania polegający na zastępowaniu w
	 * cache'u w pierwszej kolejności strony używanej najdawniej. Wymaga on
	 * informacji o tym, kiedy poszczególne strony były używane, co jest procesem
	 * kosztownym czasowo, jeśli chce się uzyskać pewność, że wyrzuca się
	 * rzeczywiście stronę używaną najdawniej.
	 */

	public void LRUdlaRiP() {
		int przydzial = przydz.get(0);
		int przedzialA = 0;
		int przedzialB = przydzial;
		int sumaB = 0;
		for (int i = 0; i < liczbaProcesow; i++) {
			int brakStron = 0;
			boolean czyWyk = false;
			if (i != 0) {
				przydzial = przydz.get(i);
				przedzialA = przedzialB;
				przedzialB += przydzial;
			}
			for (int j = 0; j < iloscOdwolan; j++) {
				for (int p = przedzialA; p < przedzialB && !czyWyk; p++) {
					if (getp(i).get(j) == ramki.get(p).wartosc) {
						PamiecFiz mem = new PamiecFiz(getp(i).get(j), 0);
						ramki.set(p, mem);
						for (int k = 0; k < przedzialB; k++) {
							if (getp(i).get(j) != ramki.get(k).wartosc) {
								int zp1 = ramki.get(k).wartosc;
								int zp2 = ramki.get(k).bitPom;
								PamiecFiz pam = new PamiecFiz(zp1, (zp2) + 1);
								ramki.set(k, pam);
							}
						}
						czyWyk = true;
					}
					if (ramki.get(p).wartosc == 0) {
						PamiecFiz mem2 = new PamiecFiz(getp(i).get(j), 0);
						ramki.set(p, mem2);
						brakStron++;
						czyWyk = true;
					}
				}
				if (czyWyk == false) {
					int zp3 = 0;
					int index = 0;
					for (int l = 0; l < przedzialB; l++) {
						if (ramki.get(l).bitPom > zp3) {
							zp3 = ramki.get(l).bitPom;
							index = l;
						}
					}
					PamiecFiz mem3 = new PamiecFiz(getp(i).get(j), 0);
					ramki.set(index, mem3);
					brakStron++;
				}
				czyWyk = false;
			}
			System.out.println("Dla procesu numer " + (i + 1) + " który posiada " + getp(i).liczbaStron
					+ " stron i otrzymał " + przydzial + " ramek " + " wystąpiło " + brakStron + " braków stron.");
			sumaB += brakStron;
		}
		System.out.println("W sumie " + sumaB + " błędów braku stron");
		przydz.clear();
		clear();
	}

//Sterowanie czestoscia bledow strony

	/*
	 * Górna i dolna granica dopuszczalnego poziomu częstości błędów braku strony Po
	 * przekroczeniu górnej granicy –przydziałnowej ramki Po przekroczeniu dolnej
	 * granicy –odebranie ramki Wymiana całych procesów
	 * 
	 * Implementacja bitu poprawności wymagawsparcia ze strony sprzętu Jeśli wystąpi
	 * odwołanie do strony z bitem 0,sprzęt stronicujący spowoduje przejście
	 * dosystemu operacyjnego : błąd zwany brakiemstrony
	 */

	public void LRUdlaSLIB() {
		int sumaB = 0;
		for (int i = 0; i < liczbaProcesow; i++) {
			int przydzialPocz = 10;
			int bit = 0;
			int bit2 = 0;
			int brakStron = 0;
			boolean czyWyk = false;
			for (int j = 0; j < iloscOdwolan; j++) {
				if (procesy.get(i).bitPom >= maxProg) {
					przydzialPocz++;
					bit = 0;
					// bit2=0;
					Proces pr = new Proces(procesy.get(i).liczbaStron, procesy.get(i).odw, bit, bit2);
					procesy.set(i, pr);
					PamiecFiz mem = new PamiecFiz(0, 0);
					ramki.set(przydzialPocz, mem);
				}
				if (procesy.get(i).bitPom2 <= minProg) {
					przydzialPocz--;
					bit2 = 0;
					// bit=0;
					Proces pr = new Proces(procesy.get(i).liczbaStron, procesy.get(i).odw, bit, bit2);
					procesy.set(i, pr);
					PamiecFiz mem = new PamiecFiz(0, 0);
					ramki.set(przydzialPocz + 1, mem);
				}
				for (int p = 0; p < przydzialPocz && !czyWyk; p++) {
					if (getp(i).get(j) == ramki.get(p).wartosc) {
						bit2--;

						Proces pr = new Proces(procesy.get(i).liczbaStron, procesy.get(i).odw, bit, bit2);
						procesy.set(i, pr);
						PamiecFiz mem = new PamiecFiz(getp(i).get(j), 0);
						ramki.set(p, mem);
						for (int k = 0; k < przydzialPocz; k++) {
							if (getp(i).get(j) != ramki.get(k).wartosc) {
								int zp1 = ramki.get(k).wartosc;
								int zp2 = ramki.get(k).bitPom;
								PamiecFiz pam = new PamiecFiz(zp1, (zp2) + 1);
								ramki.set(k, pam);
							}
						}
						czyWyk = true;
					}
					if (ramki.get(p).wartosc == 0) {
						bit++;

						Proces pr = new Proces(procesy.get(i).liczbaStron, procesy.get(i).odw, bit, bit2);
						procesy.set(i, pr);
						PamiecFiz mem2 = new PamiecFiz(getp(i).get(j), 0);
						ramki.set(p, mem2);
						brakStron++;
						czyWyk = true;
					}
				}
				if (czyWyk == false) {
					int zp3 = 0;
					int index = 0;
					for (int l = 0; l < przydzialPocz; l++) {
						if (ramki.get(l).bitPom > zp3) {
							zp3 = ramki.get(l).bitPom;
							index = l;
						}
					}
					bit++;
					Proces pr = new Proces(procesy.get(i).liczbaStron, procesy.get(i).odw, bit, bit2);
					procesy.set(i, pr);
					PamiecFiz mem3 = new PamiecFiz(getp(i).get(j), 0);
					ramki.set(index, mem3);
					brakStron++;
				}
				czyWyk = false;
			}
			System.out.println("Dla procesu numer " + (i + 1) + " który posiada " + getp(i).liczbaStron
					+ " stron, wystąpiło " + brakStron + " braków stron.");
			sumaB += brakStron;
			clear();
		}
		System.out.println("W sumie " + sumaB + " błędów braku stron");
		przydz.clear();
	}

	/*
	 * Model strefowy (ang. locality model) zakłada, że w trakcie wykonania
	 * przechodzi się z jednej strefy programu do innej, gdzie przez strefę programu
	 * rozumie się zbiór stron pozostajacych we wspólnym użyciu
	 * 
	 * strefa –zbiór stron używanych wspólnie proces przechodzi przez kolejne strefy
	 * programu
	 * 
	 * 
	 */
	public void LRUdlaMS() {
		int sumaB = 0;
		for (int i = 0; i < liczbaProcesow; i++) {
			int brakStron = 0;
			boolean czyWyk = false;
			ArrayList<Integer> zr = new ArrayList<Integer>();
			ArrayList<Integer> iloscR = new ArrayList<Integer>();
			int iloscPrzydz = iloscOdwolan / zrSize;
			int przydz = 0;
			int przydz2 = zrSize;
			for (int ilePrzydz = 0; ilePrzydz < iloscPrzydz; ilePrzydz++) {
				for (int j = przydz; j < przydz2; j++) {
					if (zr.size() == 0) {
						zr.add(getp(i).get(j));
					} else {
						boolean czyZna = false;
						for (int k = 0; k < zr.size(); k++) {
							if (zr.get(k) == getp(i).get(j)) {
								czyZna = true;
								break;
							}
						}
						if (czyZna == false) {
							zr.add(getp(i).get(j));
						}
					}
				}
				iloscR.add(zr.size());
				zr.clear();
				przydz += zrSize;
				przydz2 += zrSize;
			}
			int hp = 0;
			int hp2 = 0;
			przydz = 0;
			przydz2 = iloscR.get(hp2);
			for (int j = 0; j < iloscOdwolan; j++) {
				if (hp > zrSize) {
					hp = 0;
					hp2++;
					przydz = iloscR.get(hp2);
				}
				for (int p = 0; p < przydz && !czyWyk; p++) {
					if (getp(i).get(j) == ramki.get(p).wartosc) {
						PamiecFiz mem = new PamiecFiz(getp(i).get(j), 0);
						ramki.set(p, mem);
						for (int k = 0; k < przydz2; k++) {
							if (getp(i).get(j) != ramki.get(k).wartosc) {
								int zp1 = ramki.get(k).wartosc;
								int zp2 = ramki.get(k).bitPom;
								PamiecFiz pam = new PamiecFiz(zp1, (zp2) + 1);
								ramki.set(k, pam);
							}
						}
						czyWyk = true;
					}
					if (ramki.get(p).wartosc == 0) {
						PamiecFiz mem2 = new PamiecFiz(getp(i).get(j), 0);
						ramki.set(p, mem2);
						brakStron++;
						czyWyk = true;
					}
				}
				if (czyWyk == false) {
					int zp3 = 0;
					int index = 0;
					for (int l = 0; l < przydz2; l++) {
						if (ramki.get(l).bitPom > zp3) {
							zp3 = ramki.get(l).bitPom;
							index = l;
						}
					}
					PamiecFiz mem3 = new PamiecFiz(getp(i).get(j), 0);
					ramki.set(index, mem3);
					brakStron++;
				}
				czyWyk = false;
				hp++;
			}
			System.out.println("Dla procesu numer " + (i + 1) + " który posiada " + getp(i).liczbaStron
					+ " stron, wystąpiło " + brakStron + " braków stron.");
			sumaB += brakStron;
			clear();
		}
		System.out.println("W sumie " + sumaB + " błędów braku stron");
		przydz.clear();
	}

}
