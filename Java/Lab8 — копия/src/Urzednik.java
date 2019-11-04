public class Urzednik extends Pracownik {

	private double placaPodstawowa;

	private double premia;

	public Urzednik(String nazwisko, double etat, double placaPodstawowa, double premia) {

		super(nazwisko, etat,placaPodstawowa);

		this.placaPodstawowa = placaPodstawowa;

		this.premia = premia;

	}

	public double wyplata() {

		double wyplata = 0;
		wyplata = placaPodstawowa * etat + placaPodstawowa * etat * premia * 1 / 100;
		return wyplata;
	}

	public String toString() {
		return nazwisko;
	}

	public double getPlacaPodstawowa() {
		return placaPodstawowa;
	}

	public void setPlacaPodstawowa(double placaPodstawowa) {
		this.placaPodstawowa = placaPodstawowa;
	}

	public double getPremia() {
		return premia;
	}

	public void setPremia(double premia) {
		this.premia = premia;
	}
}