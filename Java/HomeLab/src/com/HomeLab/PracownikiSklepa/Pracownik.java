package com.HomeLab.PracownikiSklepa;



public abstract class Pracownik {

	private String imie;
	protected String nazwisko;
	protected double etat;
	protected double placaPodstawowa;

	public Pracownik(String imie, String nazwisko, double etat,double placaPodstawowa) {
		this.nazwisko = nazwisko;
		this.imie = imie;
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

	public String getImie() {
		return imie;
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
