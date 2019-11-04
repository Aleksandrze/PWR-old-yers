
public class Student implements Hashable{
	private String numerIndeksu;
	private String nazwisko;
	private String imie;
	
	public Student(String numerIndeksu, String nazwisko, String imie) {
		this.numerIndeksu = numerIndeksu;
		this.nazwisko = nazwisko;
		this.imie = imie;
	}
	
	public String getKey() {
		return numerIndeksu;
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
	
	public void wyswietlStudenta() {
		System.out.printf("%s\t%s %s " + "%n%n", numerIndeksu, nazwisko, imie);
	}
	
	@Override
	public String toString() {
		return numerIndeksu + " " + nazwisko + " " + imie + " ";
	}
}
