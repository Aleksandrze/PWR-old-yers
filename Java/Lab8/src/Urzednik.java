public class Urzednik extends Pracownik {

	private double placaPodstawowa;

	private double premia;

	public Urzednik(String nazwisko, double etat, double placaPodstawowa, double premia) {

		super(nazwisko, etat);

		this.placaPodstawowa = placaPodstawowa;

		this.premia = premia;

	}

	public double wyplata() {
		return placaPodstawowa * etat * (1 + premia);
	}

	@Override
	public String toString() {
		return "Urzednik [premia=" + premia + ", nazwisko=" + nazwisko + "]";
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