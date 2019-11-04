
public class Firma {

	private int iloscPracownikow = 0;
	private Pracownik[] lista;

	public Firma(int ilosc) {
		lista = new Pracownik[ilosc];
	}

	public void zatrudnij(Pracownik parametr) {
		try {

			if (equals(parametr)) {
				System.out.println("Takie nazwisko jest już");
			} else {
				lista[iloscPracownikow] = parametr;
				iloscPracownikow++;
				System.out.println(parametr.getNazwisko() + " został zatrudniony!");
			}
		} catch (Exception e) {
			System.out.println(" Brak wolnych miejsc");
		}

	}

	public Pracownik znajdz(String nazwisko) {
		for (Pracownik p : lista) {
			if (p != null) {
				if (p.getNazwisko().equals(nazwisko)) {
					return p;
				}
			}
		}
		return null;
	}

	public void usun(String nazwisko) {
		for (int i = 0; i < iloscPracownikow; i++) {
			if (lista[i] != null) {
				if (lista[i].getNazwisko().equals(nazwisko)) {
					lista[i] = null;
				}
			}
		}
	}

	public int iluUrzednikow() {
		int ilosc = 0;
		for (Pracownik p : lista) {
			if (p != null && p.czyUrzednik()) {
				ilosc++;
			}
		}
		return ilosc;
	}

	public int iluRobotnikow() {
		int ilosc = 0;
		for (Pracownik p : lista) {
			if (p != null && p.czyRobotnik()) {
				ilosc++;
			}
		}
		return ilosc;
	}

//*******************************************
	public double sumaWyplatUrzednikow() {
		int suma = 0;
		for (Pracownik p : lista) {
			if (p != null && p.czyUrzednik()) {
				suma += p.wyplata();
			}
		}
		return suma;
	}

	public double sumaWyplatRabotnikow() {
		int suma = 0;
		for (Pracownik p : lista) {
			if (p != null && p.czyRobotnik()) {
				suma += p.wyplata();
			}
		}
		return suma;
	}

//*******************************************
	public void listaPracownikow() {
		System.out.println("Lp\tNazwisko\t\tGrupa\t\tetat");
		int lp = 1;
		String grupa;
		for (Pracownik p : lista) {
			if (p != null) {
				if (p.czyUrzednik())
					grupa = "Urzednik";
				else
					grupa = "Robotnik";
				System.out.println(lp + "\t" + p.getNazwisko() + "\t\t" + grupa + "\t\t" + p.getEtat());
				lp++;
			}
		}
	}

	// ******************************************************************************
	public void listaUrzednikow() {
		System.out.println("Lp\tnazwisko\t\tetat");
		int lp = 1;
		for (Pracownik p : lista) {
			if (p != null && p.czyUrzednik()) { // Он может попросить показать "metod czyUrzednik" он в классе Pracownik
				System.out.println(lp + "\t" + p.getNazwisko() + "\t\t" + p.getEtat());
				lp++;
			}
		}
	}

	public void listaRobotnikow() {
		System.out.println("Lp\tnazwisko\t\tetat");
		int lp = 1;
		for (Pracownik p : lista) {
			if (p != null && p.czyRobotnik()) {// Он может попросить показать "metod czyRobotnik" он в классе Pracownik
				System.out.println(lp + "\t" + p.getNazwisko() + "\t\t" + p.getEtat());
				lp++;
			}
		}
	}

	public void listaPlac() {
		System.out.println("Lp\tNAZWISKO\t\tGRUPA\t\tETAT\t\tPLACA");
		int lp = 1;
		String grupa;
		for (Pracownik p : lista) {
			if (p != null) {
				if (p.czyUrzednik()) // Он может попросить показать "metod czyUrzednik" он в классе Pracownik
					grupa = "Urzednik";
				else
					grupa = "Robotnik";
				System.out.println(
						lp + ") " + p.getNazwisko() + "\t\t\t" + grupa + "\t" + p.getEtat() + "\t\t" + p.wyplata());
				lp++;
			}
		}
	}

}
