package com.HomeLab.PracownikiSklepa;
public class Urzednik extends Pracownik {

	private double placaPodstawowa;

	private double premia;

	public Urzednik(String nazwisko, String imie, double etat, double placaPodstawowa, double premia) {

		super(nazwisko, imie, etat, placaPodstawowa);

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
}