public abstract class Pracownik implements Comparable<Pracownik>{



    private String nazwisko;
    private double etat;

    abstract double obliczWyplate();

    public int hashCode() {
        return this.nazwisko.hashCode();
    }

    public Pracownik(String nazwisko, double etat){
        this.nazwisko=nazwisko;
        this.etat=etat;

    }
    public boolean equals(Object pracownik){
        Pracownik p1 = (Pracownik) pracownik;
        if(this.nazwisko.equals(p1.nazwisko)){
            return true;
        } else{
            return false;}
    }

    public String toString() {
        System.out.print("    "+this.nazwisko+"      "+this.etat+"  "+this.getClass().getSimpleName());
        System.out.printf("  %.2f",obliczWyplate());
        System.out.println("");
        return "";
    }


    //________________________ GET i SET______________________________________________
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

}
