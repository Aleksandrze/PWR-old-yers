
public abstract class Pracownik {

	protected String nazwisko;

	protected double etat;

	public Pracownik(String nazwisko, double etat) {
		this.nazwisko = nazwisko;
		this.etat = etat;
	}
//******************************************************************************
	
	// Вот самоe интересное))
	public boolean czyUrzednik() {
		return this instanceof Urzednik;
	}

	public boolean czyRobotnik() {
		return this instanceof Rabotnik;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pracownik other = (Pracownik) obj;
		if (nazwisko == null) {
			if (other.nazwisko != null)
				return false;
		} else if (!nazwisko.equals(other.nazwisko))
			return false;
		return true;
	}

	public abstract double wyplata();
	//******************************************************************************	
	

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public double getEtat() {
		return etat;
	}

	public void setEtat(double etat) {
		this.etat = etat;
	}
	
	public String toString() {
		return "Pracownik [nazwisko=" + nazwisko + ", etat=" + etat + "]";
	}

}
