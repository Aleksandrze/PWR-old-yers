public abstract class Pracownik {

	protected String nazwisko;
	protected double etat;
	protected double placaPodstawowa;

	public Pracownik(String nazwisko, double etat, double placaPodstawowa) {
		this.nazwisko = nazwisko;

		this.etat = etat;
		this.placaPodstawowa = placaPodstawowa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nazwisko == null) ? 0 : nazwisko.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object pracownik) {
		Pracownik p1 = (Pracownik) pracownik;
		if (this.nazwisko.equals(p1.nazwisko)) {
			return true;
		} else {
			return false;
		}
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public double getEtat() {
		return etat;
	}

	public boolean czyUrzednik() {
		return this instanceof Urzednik;
	}

	public boolean czyRobotnik() {
		return this instanceof Rabotnik;
	}

	public abstract double wyplata();

	public double getPlacaPodstawowa() {
		return placaPodstawowa;
	}

	public void setPlacaPodstawowa(double placaPodstawowa) {
		this.placaPodstawowa = placaPodstawowa;
	}



}
