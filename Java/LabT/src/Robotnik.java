
public class Robotnik extends Pracownik {

    double liczbaGodzin;
    double stawkaZaGodzine;
    final int LIMIT = 150;

    public Robotnik(String nazwisko, double etat, double stawkaZaGodzine, double liczbaGodzin) {
        super(nazwisko, etat);
        this.liczbaGodzin=liczbaGodzin;
        this.stawkaZaGodzine=stawkaZaGodzine;
    }


    public double obliczWyplate(){
        return liczbaGodzin>LIMIT ? (stawkaZaGodzine*liczbaGodzin)+(stawkaZaGodzine*(liczbaGodzin-LIMIT)*1.5) : liczbaGodzin*stawkaZaGodzine;
    }

	@Override
	public int compareTo(Pracownik o) {
		int porownaneNazwiska = getNazwisko().compareTo(o.getNazwisko());

		if (porownaneNazwiska == 0) {
			return getNazwisko().compareTo(o.getNazwisko());
		} else {
			return porownaneNazwiska;
		}
	}

    //______________________ GET i SET_______________________________
    public double getLiczbaGodzin() {
        return liczbaGodzin;
    }

    public void setLiczbaGodzin(double liczbaGodzin) {
        this.liczbaGodzin = liczbaGodzin;
    }

    public double getStawkaZaGodzine() {
        return stawkaZaGodzine;
    }

    public void setStawkaZaGodzine(double stawkaZaGodzine) {
        this.stawkaZaGodzine = stawkaZaGodzine;
    }



}
