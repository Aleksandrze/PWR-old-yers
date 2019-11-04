public class Main {

	public static void main(String[] args) {
		FirmaArray firma = new FirmaArray();

		System.out.println();
		firma.zatrudnij(new Rabotnik("Nowy", 1, 140,150, 1000));
		firma.zatrudnij(new Urzednik("Patryk" , 2, 155,154));
		firma.zatrudnij(new Rabotnik("111" , 1.5, 154,15, 1581));
		firma.zatrudnij(new Rabotnik("Amadeusz", 1.5, 154,15,180));
		firma.listaPracownik();
		System.out.println();
		firma.listaPlac();
		firma.usunZListy("Amadeusz");
		System.out.println();
		firma.listaPracownik();

		System.out.println();

		firma.sumaWyplatRobotnikow();
		firma.sumaWyplatUrzednikow();
		System.out.println();	
	}
}