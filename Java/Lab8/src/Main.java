public class Main {

	public static void main(String[] args) {
		FirmaArray firma = new FirmaArray();

		System.out.println();
		firma.zatrudnij(new Rabotnik("Kubiako",1.0,13,150));
		firma.zatrudnij(new Urzednik("Patryk" , 2, 155,154));
		firma.zatrudnij(new Rabotnik("111" , 1.5,15, 1581));
		firma.zatrudnij(new Rabotnik("111" , 1.5,15, 1581));
		firma.zatrudnij(new Rabotnik("Adam", 1.5,15,180));
		
		firma.listaPracownik();
		System.out.println("========================================================");
		System.out.println();
		firma.listaPlac();
		firma.usunZListy("Adam");
		System.out.println("========================================================");
		System.out.println();
		firma.listaPracownik();

		System.out.println();

		firma.sumaWyplatRobotnikow();
		firma.sumaWyplatUrzednikow();
		System.out.println();	
		firma.iluUrzednikow();
		
	}
}