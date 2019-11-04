
import java.util.*;


public class Firma{

    public TreeSet<Pracownik> listaPracownikow = new TreeSet<>();
    Iterator<Pracownik> pracownikIterator;

    public void zatrudnijUrzednika(String nazwisko, double etat, double pensja, double premia){
        this.listaPracownikow.add(new Urzednik(nazwisko,etat,pensja,premia));
    }

    public  void zatrudnijRobotnika(String nazwisko,double etat,double stawkaZaGodzine,double liczbaGodzin) {
        this.listaPracownikow.add(new Robotnik(nazwisko,etat,stawkaZaGodzine,liczbaGodzin));
    }


    public void zwolnij(String nazwisko){
        if(this.listaPracownikow!=null){
            pracownikIterator=this.listaPracownikow.iterator();
            while(pracownikIterator.hasNext()){
                Pracownik x = pracownikIterator.next();
                if(x.getNazwisko().equals(nazwisko)){
                    pracownikIterator.remove();
                }
            }
        }
        else {return;}
        System.out.println("Zwolniono: " + nazwisko);
    }

    public void iloscPracownikow(){
        int urzednik=0;
        int robotnik = 0;
        for(Pracownik x : this.listaPracownikow){
            if(x instanceof Urzednik){
                urzednik++;
            }
            else if(x instanceof Robotnik){
                robotnik++;
            }
        }
        System.out.println("Liczba Urzednikow: " + urzednik + ". Liczba Robotników: " + robotnik);
    }

    public void wydukujListeRobotnikow(){
        int lp = 1;
        if(this.listaPracownikow!=null){
            System.out.println("Lista Robotników");
            System.out.println("Lp.  Nazwisko   Etat");
            for(Pracownik x : this.listaPracownikow){
                if(x instanceof Robotnik){
                    System.out.println("Lp."+lp+" "+x.getNazwisko()+"      "+x.getEtat());
                    lp++;
                }
            }
            System.out.println("------------------------");
        }
    }

    public void wydrukujListeUrzednikow(){
        int lp = 1;
        if(this.listaPracownikow!=null){
            System.out.println("Lista Urzędników");
            System.out.println("Lp.  Nazwisko   Etat  ");
            for (Pracownik x : this.listaPracownikow){
                if (x instanceof Urzednik){
                    System.out.println("Lp."+lp+" "+x.getNazwisko()+"      "+x.getEtat());
                    lp++;
                }
            }
            System.out.println("------------------------");
        }
    }

    public void sumaWyplatUrzednikow(){
        double suma = 0;
        if(this.listaPracownikow!=null){
            pracownikIterator = this.listaPracownikow.iterator();
            while (pracownikIterator.hasNext()){
                Pracownik x = pracownikIterator.next();
                if(x instanceof Urzednik){
                    suma+=x.obliczWyplate();
                }
            }
        }  System.out.println("Suma pensji Urzedników: "+suma);
    }

    public void sumaWyplatRobotnikow(){
        double suma = 0;
        if(this.listaPracownikow!=null){
            pracownikIterator = this.listaPracownikow.iterator();
            while (pracownikIterator.hasNext()){
                Pracownik x = pracownikIterator.next();
                if(x instanceof Robotnik){
                    suma+=x.obliczWyplate();
                }
            }

        }
        System.out.println("Suma pensji Robotników: "+suma);
    }

    public void sumaWyplatPracownikow(){
        double suma = 0;
        if(this.listaPracownikow!=null){
            pracownikIterator=this.listaPracownikow.iterator();
            while (pracownikIterator.hasNext()){
                Pracownik x = pracownikIterator.next();
                if(x instanceof Pracownik){
                    suma+=x.obliczWyplate();
                }
            }

        }
        System.out.println("Suma wypłat pracowników firmy: "+suma);
    }

    public void wydrukujListePracownikow(){
        int lp = 1;
        if(this.listaPracownikow!=null){
            System.out.println("Lista Pracowników");
            System.out.println("Lp.  Nazwisko   Etat  Klasa");
            for (Pracownik x : this.listaPracownikow){
                System.out.println("Lp."+lp+" "+x.getNazwisko()+"      "+x.getEtat()+"   "+x.getClass().getSimpleName());
                lp++;
            }
        }
        System.out.println("-------------------------------");
    }

    public void wydrukujListaPlacIPracownikow(){
    int lp = 1;
        if(this.listaPracownikow!=null){
            System.out.println("Lista wyplat wszystkich pracownikow: ");
            System.out.println("Lp.    Nazwisko     Etat Klasa     Pensja");
            for(Pracownik x:this.listaPracownikow) {
                System.out.print("Lp."+lp+" ");
                x.toString();
                lp++;
            }
        }
    }







    public static void main(String [] args){
        Firma firmaTreeSet = new Firma();

        firmaTreeSet.zatrudnijRobotnika("Kubia",1.0,14,120);
        firmaTreeSet.zatrudnijRobotnika("Wazel",1.5,24,190);
        firmaTreeSet.zatrudnijUrzednika("Panek",0.5,2500,10);
        firmaTreeSet.zatrudnijUrzednika("Lolek",1.0,3500,15);


        firmaTreeSet.wydrukujListePracownikow();
        System.out.println();

        firmaTreeSet.zwolnij("Kubia");
        System.out.println();


        firmaTreeSet.wydrukujListePracownikow();
        System.out.println();

        firmaTreeSet.wydrukujListeUrzednikow();
        System.out.println();
        firmaTreeSet.wydukujListeRobotnikow();
        System.out.println();

        firmaTreeSet.sumaWyplatRobotnikow();
        firmaTreeSet.sumaWyplatUrzednikow();
        firmaTreeSet.sumaWyplatPracownikow();
        System.out.println();
        firmaTreeSet.wydrukujListaPlacIPracownikow();





    }


}


