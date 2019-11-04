public abstract class Pracownik {

	protected String nazwisko;
	protected double etat;


	public Pracownik(String nazwisko, double etat) {
		this.nazwisko = nazwisko;

		this.etat = etat;

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

	
	
	
    public String toString() {
        System.out.print(this.nazwisko+" "+this.etat+this.getClass().getSimpleName());
        System.out.printf("%.2f",wyplata());
        System.out.println("");
        return "";
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





}
