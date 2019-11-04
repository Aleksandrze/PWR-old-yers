public class Towar {
	private String nazwa;
	private int ilosc;
	private double cena;
	private double wartosc;

	public Towar(String nazwa, int ilosc, double cena) {
		this.nazwa = nazwa;
		this.ilosc = ilosc;
		this.cena = cena;
		this.wartosc = cena * ilosc;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public int getIlosc() {
		return ilosc;
	}

	public void setIlosc(int ilosc) {
		this.ilosc = ilosc;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
		this.setWartosc(cena);
	}

	public double getWartosc() {
		return wartosc;
	}

	public void setWartosc(double wartosc) {
		this.wartosc = this.cena * this.ilosc;
	}

	public void wyswietlTowar() {
		System.out.printf("%s\t %d\t %.2f\t %.2f %n%n", nazwa, ilosc, cena, wartosc);
	}

}
