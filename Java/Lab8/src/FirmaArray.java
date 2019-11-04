import java.util.ArrayList;
import java.util.Iterator;

public class FirmaArray {

	public final static int SIZE = 15;
	private ArrayList<Pracownik> lista;

	public FirmaArray() {

		lista = new ArrayList<Pracownik>();

	}

	public boolean zatrudnij(Pracownik pracownik) {
		if (lista.isEmpty()) {
			lista.add(pracownik);
			return true;
		} else {
			for (Pracownik a : lista) {
				if (a.equals(pracownik))
					return false;
			}
		}
		lista.add(pracownik);
		return true;
	}
	
	public Pracownik znajdz(String nazwisko) {
		for(Pracownik p: lista) {
			if(p.getNazwisko()==nazwisko);
			return p;
		}
		return null;
	}

	public void usunZListy(String nazwisko) {
		int i;
		for (i = 0; i < lista.size(); i++) {
			if (lista.get(i).getNazwisko().equals(nazwisko)) {
				lista.remove(lista.get(i));
			}
		}
	}

	public int iluUrzednikow() {
		int u = 0;
		Iterator<Pracownik> i = lista.iterator();
		while (i.hasNext()) {

			if (i.next() instanceof Urzednik)
				u++;
		}
		System.out.println("Lista Urzednikow: " + u);
		return u;

	}

	public int iluRobotnikow(String iluRobotnikow) {
		int r = 0;
		Iterator<Pracownik> i = lista.iterator();
		while (i.hasNext()) {

			if (i.next() instanceof Rabotnik)
				r++;
		}
		System.out.println("Lista Rabotnikow: " + iluRobotnikow);
		return r;
	}

// ----------------------------------------------------------------------------------------------*
	
	public void sumaWyplatUrzednikow(){
        double suma = 0;

        if(this.lista!=null){
            Iterator<Pracownik> iter = this.lista.iterator();
            while(iter.hasNext()){
                Pracownik x = (Pracownik) iter.next();
                if(x instanceof Urzednik){
                    suma +=x.wyplata();
                }
            }

        }
        System.out.println("Suma płac Urzedników: " + suma);

    }

    public void sumaWyplatRobotnikow(){
        double suma = 0;
        if(this.lista!=null){
            Iterator<Pracownik> iter = this.lista.iterator();
            while(iter.hasNext()){
                Pracownik x = (Pracownik) iter.next();
                if(x instanceof Rabotnik){
                    suma +=x.wyplata();
                }
            }

        }
        System.out.println("Suma płac Robotników: " + suma);

    }
	

    
//----------------------------------------------------------------------------------------------*
    
    
    public void listaPracownik(){
        int lp = 1;
        if(this.lista!=null){
            System.out.println("Lista pracowników");
            System.out.println("Lp\tNazwisko\tETAT\tRodzaj ");
            for(Pracownik x : this.lista){
                System.out.println(lp+"\t"+x.getNazwisko()+"\t"+"\t"+  x.getEtat()+"\t"+x.getClass().getSimpleName());
                lp++;
            }
        }
 
    }


    public void listaPlac(){
        int lp = 1;
            if(this.lista!=null) {
                System.out.println("Lista wyplat wszystkich pracownikow: ");
                System.out.println("Lp\tNazwisko\tETAT\tRodzaj      Wyplat");
                for(Pracownik x:this.lista) {
                    System.out.printf(lp+"\t"+x.getNazwisko()+"\t"+"\t"+x.getEtat()+"\t"+x.getClass().getSimpleName()+"   ");
                    System.out.printf("%.2f",x.wyplata());
                    System.out.println("");
                    lp++;
                }
            }

    }
}