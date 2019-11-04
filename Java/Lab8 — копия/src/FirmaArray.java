import java.util.ArrayList;
import java.util.Iterator;

public class FirmaArray {

	public final static int SIZE = 15;
	private ArrayList<Pracownik> lista;

	public FirmaArray() {

		lista = new ArrayList<Pracownik>();

	}

	public boolean zatrudnij(Pracownik pracownik) {
		if (lista.isEmpty()) {
			lista.add(pracownik);
			return true;
		} else {
			for (Pracownik a : lista) {
				if (a.equals(pracownik))
					return false;
			}
		}
		lista.add(pracownik);
		return true;
	}

	public void usunZListy(String nazwisko) {
		int i;
		for (i = 0; i < lista.size(); i++) {
			if (lista.get(i).getNazwisko().equals(nazwisko)) {
				lista.remove(lista.get(i));
			}
		}
	}

	public int iluUrzednikow(String iluUrzednikow) {
		int u = 0;
		Iterator<Pracownik> i = lista.iterator();
		while (i.hasNext()) {

			if (i.next() instanceof Urzednik)
				u++;
		}
		System.out.println("Lista Urzednikow: " + iluUrzednikow);
		return u;

	}

	public int iluRobotnikow(String iluRobotnikow) {
		int r = 0;
		Iterator<Pracownik> i = lista.iterator();
		while (i.hasNext()) {

			if (i.next() instanceof Rabotnik)
				r++;
		}
		System.out.println("Lista Rabotnikow: " + iluRobotnikow);
		return r;
	}

	public double sumaWyplatUrzednikow() {
		double sumaWyplatUrzednikow = 0;
		Iterator<Pracownik> i = lista.iterator();
		while (i.hasNext()) {
			if (i.next() instanceof Urzednik)
				sumaWyplatUrzednikow = sumaWyplatUrzednikow + i.next().wyplata();
		}
		System.out.println("suma wyplat Urzednikow: " + sumaWyplatUrzednikow);
		return sumaWyplatUrzednikow;
	}

	public double sumaWyplatRobotnikow() {
		double sumaWyplatRobotnikow = 0;
		Iterator<Pracownik> i = lista.iterator();
		while (i.hasNext()) {
			if (i.next() instanceof Rabotnik)
				sumaWyplatRobotnikow = sumaWyplatRobotnikow + i.next().wyplata();
		}
		System.out.println("suma wyplat Rabotnik: " + sumaWyplatRobotnikow);
		return sumaWyplatRobotnikow;
	}

	public void listaPracownik() {
		int lp = 1;
		System.out.println("lp\tnazwisko\tetat");
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i) instanceof Urzednik) {
				System.out.println(lp + "\t" + lista.get(i).getNazwisko() + "\tUrzednik\t" + lista.get(i).getEtat());
				lp++;
			} else if (lista.get(i) instanceof Rabotnik) {
				System.out.println(lp + "\t" + lista.get(i).getNazwisko() + "\tRabotnik\t" + lista.get(i).getEtat());
				lp++;
			}
		}
	}

	public void listaPlac() {
		System.out.println("Lp" + "\t" + "Nazwislo\tGRUPA\t\tETAT\tPLACA");
		int lp = 1;
		for (int i = 0; i < lista.size(); i++) {

			if (lista.get(i) instanceof Urzednik) {
				System.out.println(lp + "\t" + lista.get(i).getNazwisko() + "\tUrzednik\t" + lista.get(i).getEtat()
						+ "\t " + lista.get(i).getPlacaPodstawowa());
				lp++;
			} else if (lista.get(i) instanceof Rabotnik) {
				System.out.println(lp + "\t" + lista.get(i).getNazwisko() + "\tRabotnik\t" + lista.get(i).getEtat()
						+ "\t " + lista.get(i).getPlacaPodstawowa());
				lp++;
			}
		}
	}

}