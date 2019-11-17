import java.util.*;

public class Dysk {
	public final int MAX_BLOKOW = 500;
	private final int LICZBA_ZGLOSZEN = 100;
	public List<Zgloszenie> kolejka = new ArrayList<Zgloszenie>();

	public Dysk() {
		for (int i = 0; i < LICZBA_ZGLOSZEN; i++) {
			kolejka.add(new Zgloszenie());
		}
	}

// pierszy wchodza, pierszy wychodza
	public int FCFS() {
		int suma = 0;
		for (int i = 0; i < kolejka.size() - 1; i++) {
			suma += mod(kolejka.get(i).getBlok(), kolejka.get(i + 1).getBlok());
		}
		return suma;
	}

//========================================================================
	// Krótki Czas Wyszukiwania (najpierw najkrótszy czas przeszukiwania)
	/*
	 * ZNAJDŹ, OBSŁUŻ I USUŃ ZGŁOSZENIE NAJBLIŻEJ AKTUALNEJ POZYCJI GŁOWICY
	 * 
	 * W tym przypadku żądanie jest przetwarzane na najkrótszej odległości. Od 50,
	 * następujący najkrótsza będzie zamiast 62 34, tak jak to tylko 12 utworów od
	 * 62 i 16 utworów od 34. Proces będzie kontynuowany, aż wszystkie procesy
	 * dbają. Na przykład, w następujący wydarzeniem było przeniesienie z 62 do 64
	 * zamiast 34, ponieważ między nimi są tylko 2 utwory, a nie 18, gdyby to było w
	 * drugą stronę. Choć to wydaje się najlepszym serwisem, ponieważ podróżował w
	 * sumie 236 utworów, to nie jest optymalne. Istnieje duża szansa, że głód
	 * będzie mieć miejsce. Powodem tego jest to, że jeśli było wiele zapytań,
	 * blisko siebie, inne wnioski nigdy nie będą przetwarzane, tak jak odległość
	 * zawsze będzie więcej.
	 */
	public int SSTF() {
		int suma = 0;
		int current = 0;
		int currentMin = MAX_BLOKOW;
		int next = 0;
		int licznikZgloszen = 0;

		while (licznikZgloszen < LICZBA_ZGLOSZEN) {
			for (int j = 0; j < kolejka.size(); j++) {
				if ((mod(kolejka.get(current).getBlok(), kolejka.get(j).getBlok()) < currentMin)
						&& (kolejka.get(j).zrobiony != true) && (current != j)) {
					currentMin = mod(kolejka.get(current).getBlok(), kolejka.get(j).getBlok());
					next = j;
				}
			}
			suma += currentMin;
			kolejka.get(current).zrobiony = true;
			currentMin = 500;
			current = next;
			licznikZgloszen++;
		}
		zeruj();
		return suma;
	}

//=================================================================================
	/*
	 * POSORTUJ ZGŁOSZENIA ZGODNIE Z NUMEREM CYLINDRA OBSŁUŻ I USUŃ PIERWSZE
	 * ZGŁOSZENIE Z LISTY
	 * 
	 * Winda algotitm To podejście działa jak winda. Skanuje w dół do najbliższego
	 * końca, a następnie, kiedy dostaje się na dno, skanuje obsługa zapytań, które
	 * nie otrzymał w dół. Jeśli zapytanie trafia po zakończeniu skanowania, on nie
	 * będzie obsługiwany, dopóki proces nie wróci lub nie przesunie się z powrotem.
	 * Ten proces ruszył w sumie 230 utworów. Po raz kolejny jest bardziej optymalny
	 * niż poprzedni algorytm, ale nie najlepszy.
	 */
	public int CSCAN() {
		Random rand = new Random();
		int suma = 0;
		int blokTemp = 0;
		int addDiff = 0;
		int zrob;
		boolean brak = true;
		while (!kolejkaIsDone()) {
			brak = true;
			for (int i = 0; i <= MAX_BLOKOW; i++) {
				for (int j = 0; j < kolejka.size(); j++) {
					int s = kolejka.get(j).getBlok();
					boolean jest = kolejka.get(j).zrobiony;
					zrob = rand.nextInt(2);
					if (s == i && !jest && zrob == 1) {
						suma += mod(blokTemp, i) + addDiff;
						blokTemp = i;
						kolejka.get(j).zrobiony = true;
						addDiff = 0;
						brak = false;
					}
				}
			}
			if (brak = false) {
				addDiff = MAX_BLOKOW - blokTemp;
			} else {
				addDiff += MAX_BLOKOW;
			}
			blokTemp = 0;
		}
		zeruj();
		return suma;
	}
	// ========================================================================

	/*
	 * algorytm C-SCAN (ang. circular SCAN – skanowanie cykliczne) jest odmianą
	 * algorytmu SCAN algorytm działa podobnie jak metoda SCAN z tą różnicą, że po
	 * dojściu głowicy do skrajnego położenia wraca ona natychmiast do
	 * przeciwległego położenia (bez obsługi zamówień znajdujących się po drodze)
	 * 
	 * 
	 * Okrągłe skanowanie (C-SCAN) [wykres] Okrągłe skanowanie działa tak samo, jak
	 * winda w pewnym stopniu. Zaczyna skanowanie do najbliższego końca i działa do
	 * samego końca systemu. Jak tylko dostanie się w dolny lub górny, skacze na
	 * drugi koniec i porusza się w tym samym kierunku. Należy pamiętać, że ogromny
	 * skok nie jest ruchem głowy. Ogólny ruch głowy do tego algorytmu wynosi
	 * zaledwie 187 utworów,ale to nie wystarczy.
	 */
	public int SCAN() {
		Random rand = new Random();
		int suma = 0;
		int blokTemp = 0;
		int zrob;
		while (!kolejkaIsDone()) {
			for (int i = 0; i <= MAX_BLOKOW; i++) {
				for (int j = 0; j < kolejka.size(); j++) {
					int s = kolejka.get(j).getBlok();
					boolean jest = kolejka.get(j).zrobiony;
					zrob = rand.nextInt(2);
					if (s == i && !jest && zrob == 1) {
						suma += mod(blokTemp, i);
						blokTemp = i;
						kolejka.get(j).zrobiony = true;
					}
				}
			}
			suma += mod(MAX_BLOKOW, blokTemp);
			for (int k = MAX_BLOKOW; k >= 0; k--) {
				for (int l = 0; l < kolejka.size(); l++) {
					int s = kolejka.get(l).getBlok();
					boolean jest = kolejka.get(l).zrobiony;
					zrob = rand.nextInt(2);
					if (s == k && !jest && zrob == 1) {
						suma += mod(blokTemp, k);
						blokTemp = k;
						kolejka.get(l).zrobiony = true;
					}
				}
			}
			if (!kolejkaIsDone()) {
				suma += mod(0, blokTemp);
			}
			blokTemp = 0;
		}
		zeruj();
		return suma;
	}

//==========================================================
	public int mod(int l1, int l2) {
		int suma = 0;
		if (l1 > l2) {
			suma = l1 - l2;
		} else {
			suma = l2 - l1;
		}
		return suma;
	}

	public boolean kolejkaIsDone() {
		boolean isDone = true;
		for (int i = 0; i < kolejka.size(); i++) {
			if (kolejka.get(i).zrobiony == false) {
				isDone = false;
				break;
			}
		}
		return isDone;
	}

	public void zeruj() {
		for (int i = 0; i < kolejka.size(); i++) {
			kolejka.get(i).zrobiony = false;
		}
	}
}
