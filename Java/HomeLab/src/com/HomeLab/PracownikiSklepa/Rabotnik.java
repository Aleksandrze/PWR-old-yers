package com.HomeLab.PracownikiSklepa;
public class Rabotnik extends Pracownik {

	public final static int LIMIT = 160;
	private int przepracowaneGodziny;
	private double stawkaGodzinowa;

	public Rabotnik(String nazwisko, String imie, double etat,double placaPodstawowa,  int przepracowaneGodziny, double stawkaGodzinowa) {
		super(nazwisko, imie, etat, placaPodstawowa);

		this.przepracowaneGodziny = przepracowaneGodziny;

		this.stawkaGodzinowa = stawkaGodzinowa;
	}

	public String toString() {
		return nazwisko;
	}

	public double wyplata() {
		double wyplat = 0;

		stawkaGodzinowa = (int) (LIMIT * etat);

		if (stawkaGodzinowa >= przepracowaneGodziny)
			wyplat = przepracowaneGodziny * stawkaGodzinowa;
		else
			wyplat = stawkaGodzinowa * stawkaGodzinowa
					+ (przepracowaneGodziny - stawkaGodzinowa) * stawkaGodzinowa * 3 / 2;
		return wyplat;

	}
}