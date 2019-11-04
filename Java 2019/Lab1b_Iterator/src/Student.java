public class Student {
	private String numerIndeksu;
	private String nazwisko;
	private String imie;
	private double ocena;

	public Student(String numerIndeksu, String nazwisko, String imie, double ocena) {
		this.numerIndeksu = numerIndeksu;
		this.nazwisko = nazwisko;
		this.imie = imie;
		this.ocena = ocena;
	}

	public void wyswietlStudenta() {
		System.out.printf("%s\t%s %s " + ocena + "%n%n", numerIndeksu, nazwisko, imie);
	}

	public String formatuj() {
		return numerIndeksu + " " + nazwisko + " " + imie + " " + ocena;
	}

	@Override
	public String toString() {
		return "Student [numerIndeksu=" + numerIndeksu + ", nazwisko=" + nazwisko + ", imie=" + imie + ", ocena="
				+ ocena + "]";
	}

	public int compareTo(Student obiekt) {
		if (imie.compareTo(obiekt.imie) == 1) {
			if (nazwisko.compareTo(obiekt.nazwisko) == 1) {
				return 0;
			} else {
				return 1;
			}

		}

		return -1;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((imie == null) ? 0 : imie.hashCode());
		result = prime * result + ((nazwisko == null) ? 0 : nazwisko.hashCode());
		result = prime * result + ((numerIndeksu == null) ? 0 : numerIndeksu.hashCode());
		long temp;
		temp = Double.doubleToLongBits(ocena);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (imie == null) {
			if (other.imie != null)
				return false;
		} else if (!imie.equals(other.imie))
			return false;
		if (nazwisko == null) {
			if (other.nazwisko != null)
				return false;
		} else if (!nazwisko.equals(other.nazwisko))
			return false;
		if (numerIndeksu == null) {
			if (other.numerIndeksu != null)
				return false;
		} else if (!numerIndeksu.equals(other.numerIndeksu))
			return false;
		if (Double.doubleToLongBits(ocena) != Double.doubleToLongBits(other.ocena))
			return false;
		return true;
	}

	public String getNumerIndeksu() {
		return numerIndeksu;
	}

	public void setNumerIndeksu(String numerIndeksu) {
		this.numerIndeksu = numerIndeksu;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public double getOcena() {
		return ocena;
	}

	public void setOcena(double ocena) {
		this.ocena = ocena;
	}

}
