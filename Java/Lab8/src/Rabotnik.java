public class Rabotnik extends Pracownik {

	public final static int LIMIT = 160;
	private int przepracowaneGodziny;
	private double stawkaGodzinowa;

	public Rabotnik(String nazwisko, double etat,  int przepracowaneGodziny,
			double stawkaGodzinowa) {
		super(nazwisko, etat);

		this.przepracowaneGodziny = przepracowaneGodziny;

		this.stawkaGodzinowa = stawkaGodzinowa;
		
	}

	@Override
	public String toString() {
		return "Rabotnik [stawkaGodzinowa=" + stawkaGodzinowa + ", nazwisko=" + nazwisko + ", etat=" + etat + "]";
	}


	public double wyplata() {
		double wyplata = przepracowaneGodziny * stawkaGodzinowa;
		if (przepracowaneGodziny > etat * LIMIT) {
			wyplata += (przepracowaneGodziny - (etat * LIMIT)) * 0.5 * stawkaGodzinowa; 
		}
		return wyplata;
	}
}