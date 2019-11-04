
public class Urzednik extends Pracownik {

    private double pensjaPodstawowa;
    private double premia; 

    public Urzednik(String nazwisko, double etat, double pensjaPodstawowa, double premia) {
        super(nazwisko, etat);
        this.pensjaPodstawowa = pensjaPodstawowa;
        this.premia = (premia / 100);
    }
    public double obliczWyplate() {
        return pensjaPodstawowa + pensjaPodstawowa * premia;
    }


//_______________________________ GET i SET___________________________

    public double getPensjaPodstawowa() {
        return pensjaPodstawowa;
    }

    public void setPensjaPodstawowa(int pensjaPodstawowa) {
        this.pensjaPodstawowa = pensjaPodstawowa;
    }

    public double getPremia() {
        return premia;
    }

    public void setPremia(int premia) {
        this.premia = premia;
    }


    @Override
    public int compareTo(Pracownik o) {
        int porownaneNazwiska = getNazwisko().compareTo(o.getNazwisko());

        if(porownaneNazwiska == 0) {
            return getNazwisko().compareTo(o.getNazwisko());
        }
        else {
            return porownaneNazwiska;
        }
    }
}
