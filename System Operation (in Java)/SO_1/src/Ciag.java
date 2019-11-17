import java.util.ArrayList;

/*\
 * buduiemy kolieku Procesow(ArrayList)
 * Wiele metod w tej klase nie zostaіo urzytych, ale mogut byc poczebnay do dodowania i usunuenja.
 */
class Ciag {

	ArrayList<Proces> ciag = new ArrayList<Proces>();

	public void dodajProces(Proces proces) {
		ciag.add(proces);
	}

	public void dodajProcesIn(int index, Proces proces) {
		ciag.add(index, proces);
	}

	public void wyczyscyCiagi() {
		ciag.clear();
	}

	public Proces getProces(int index) {
		return ciag.get(index);
	}

	public boolean czyPusta() {
		return ciag.isEmpty();
	}

	public void usunProces(int index) {
		ciag.remove(index);
	}

	public void setProces(int index, Proces proces) {
		ciag.set(index, proces);
	}

	public int dlugoscCiagu() {
		return ciag.size();
	}

	public void wypiszProcesy() {
		for (int i = 0; i < dlugoscCiagu() - 1; i++) {
			System.out.println("Numer procesu: " + getProces(i).getNumer() + "\nMoment przybycia: "
					+ getProces(i).getMoment() + "\nDlugosc zycia: " + getProces(i).getTime() + "\n -------");
		}
	}

}