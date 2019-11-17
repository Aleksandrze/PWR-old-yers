import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

class Generuj {
	Ciag c = new Ciag();

	public void CreateProces(int ilosc, int maxdlProces, int maxMomentZglosz) {
		int iloscProc = ilosc;
		int max = maxdlProces;
		int maxM = maxMomentZglosz;

		if (iloscProc < 0) {
			iloscProc = 0;
		}
		if (max < 1) {
			max = 1;
		}
		if (maxM < 1) {
			maxM = 1;
		}
		if (max < maxM) {
			maxM = max - 1;
		}

		Random r = new Random();

		for (int i = 0; i <= iloscProc; i++) {
			int dlugosc = r.nextInt(max);
			int moment = r.nextInt(maxM);
			int numer = i + 1;
			Proces proc = new Proces(dlugosc, numer, moment);
			if (i == iloscProc) {
				Proces proc2 = new Proces(0, 0, 0);
				c.dodajProces(proc2);
			} else {
				c.dodajProces(proc);
			}
		}

	}

	public void seeProces() {
		c.wypiszProcesy();
	}

	public int dlgoscsKolejki() {
		return c.dlugoscCiagu();
	}

//-----------------------------------------------------
	/*
	 * Pierwszy nadszedl - pierwszy obsluzony. Wedlug tego schematu proces, który
	 * pierwszy zamówi procesor, pierwszy go otrzyma. Algorytm FCFS implementuje sie
	 * za pomoca kolejki FIFO: blok kontrolny procesu wchodzacego do kolejki jest
	 * dolaczany na jej koncu. Wolny procesor przydziela sie procesowi z czola
	 * kolejki.
	 * 
	 * 
	 */

	public int sredniCzasFCSF() {
		int time = 0;
		for (int i = 0; i < c.dlugoscCiagu() - 1; i++) {
			time += c.getProces(i).getTime() - c.getProces(i + 1).getMoment();
		}
		return time / (c.dlugoscCiagu() - 1);
	}
//-----------------------------------------------------

	/*
	 * SJF (SJN, SPF, SPN, Shortest Job/Process First/Next) — najpierw najkrótsze
	 * zadanie
	 * 
	 * krótszy proces = szybciej wykonany
	 * 
	 * Z punktu widzenia algorytmu SJF lub SRT oznacza to, że całkowity czas obsługi
	 * musi być znany w momencie zgłoszenia procesu do systemu. Tak sytuacja jest
	 * potencjalnie możliwa w systemach wsadowych, gdzie użytkownik specyfikuje ten
	 * czas. Jego zaniżenie może skutkować odrzuceniem zadania w trakcie
	 * przetwarzania po przekroczeniu zadeklarowanej wielkości, więc nie należy
	 * spodziewać się nadużyć w tym zakresie. Z drugiej strony sytuacja, w której
	 * proces wymaga przez większość czasu wyłącznie obsługi ze strony procesora
	 * jest nieprawdopodobna w realnym przetwarzaniu. Dlatego w algorytmach SJF lub
	 * SRT uwzględnia się czas następnej (przyszłej) fazy procesora. W ogólnym
	 * przypadku czas taki trudno oczywiście wydedukować z atrybutów procesu, można
	 * jedynie próbować estymować go na podstawie czasu obsługi wcześniejszych faz.s
	 */

	public int sredniSJF() {
		int time = 0;

		boolean zp = false;
		for (int i = 0; i < c.dlugoscCiagu() - 1; i++) {
			if (i == 0) {
				if (c.getProces(i + 1).getMoment() == 0) {
					if (c.getProces(i).getTime() < c.getProces(i + 1).getTime()) {
						time += c.getProces(i).getTime();
						c.usunProces(i);
					} else {
						if (c.getProces(i).getTime() > c.getProces(i + 1).getTime()) {
							time += c.getProces(i + 1).getTime();
							c.usunProces(i + 1);
						} else {
							time += c.getProces(i).getTime();
							c.usunProces(i);
						}
					}
				} else {
					time += c.getProces(i).getTime() - c.getProces(i + 1).getMoment();
					c.usunProces(i);
				}
			} else {
				if (zp == false) {
					Collections.sort(c.ciag, new Compar());
					zp = true;
				}
				time += c.getProces(i).getTime() - c.getProces(i + 1).getMoment();
			}
		}

		return time / c.dlugoscCiagu();
	}

	// ------------------------------------------------------------------------

	/*
	 * RR (Round-Robin), czyli planowanie rotacyjne, to strategia, w której każdy
	 * proces po kolei otrzymuje kwant czasu procesora do wykorzystania. Zwykle jest
	 * to około 20-100 milisekund. Żaden proces nie czeka więc dłużej na procesor
	 * niż długość kwantu razy liczba procesów.
	 * 
	 * Planowanie rotacyjne powoduje znacznie więcej przełączeń kontekstu jest więc
	 * dość kosztowną strategią. Kwant czasu musi być co najmniej o rząd wielkości
	 * większy niż czas przełączenia kontekstu. W przeciwnym wypadku prace
	 * administracyjne (biurokracja systemowa) zduszą rzeczywistą pracę wykonywaną
	 * przez system dla użytkowników.
	 */
	public int sredniRot() {
		int kwantCzasu = 100; // ustalamy czasu.
		int time = 0;
		ArrayList<Proces> rot = new ArrayList<Proces>();
		int zp = 0;
		for (int i = 0; i < c.dlugoscCiagu(); i++) {
			Proces r = new Proces(c.getProces(i).getTime(), c.getProces(i).getNumer(), c.getProces(i).getMoment());
			rot.add(r);
		}
		for (int j = 0; zp < c.dlugoscCiagu() - 1; j++) {
			if (kwantCzasu > rot.get(j).getMoment()) {
				if (j < c.dlugoscCiagu() - 1) {
					if (rot.get(j).czyWyk() != true) {
						if (kwantCzasu > rot.get(j).getTime()) {
							time += rot.get(j).getTime();
							rot.get(j).setWyk(kwantCzasu);
							zp++;
						} else {
							time += kwantCzasu;
							rot.get(j).setWyk(kwantCzasu);
						}
					} else {
						zp++;
					}
				} else {
					j = 0;
				}
			} else {
				if (j < c.dlugoscCiagu() - 1) {
					if (rot.get(j).czyWyk() != true) {
						if (kwantCzasu > rot.get(j).getTime()) {
							time += rot.get(j).getTime() + rot.get(j).getMoment();
							rot.get(j).setWyk(kwantCzasu);
							zp++;
						} else {
							time += kwantCzasu + rot.get(j).getMoment();
							rot.get(j).setWyk(kwantCzasu);
						}
					} else {
						zp++;
					}
				} else {
					j = 0;
				}
			}
		}
		return time / (c.dlugoscCiagu() - 1);
	}

}
