public class Main {

	public static void main(String[] args) {

		Firma firma = new Firma(6);

		// Телепузик измени имена и числа, А так же название методов(чуть-чуть). Спасибо =D
		
		
		Rabotnik r1 = new Rabotnik("Amadeusz", 1, 2500, 15);
		Rabotnik r2 = new Rabotnik("Ludwig ", 0.5, 90, 12);
		Urzednik u1 = new Urzednik("Vivaldi", 1.5, 2000, 10);
		Urzednik u2 = new Urzednik("Chopin", 1.0, 1500, 15);
		Rabotnik r3 = new Rabotnik("Bach", 1, 3000, 0.18);

		firma.zatrudnij(r1);
		firma.zatrudnij(r2);
		firma.zatrudnij(r3);
		firma.zatrudnij(u1);
		firma.zatrudnij(u2);
		
		firma.listaPlac();

		firma.usun("Amadeusz");
		System.out.println();
		firma.zatrudnij(new Rabotnik("Nowy", 1, 200, 10));
		firma.listaPlac();

		System.out.println();
		System.out.println("lista Robotnikow");
		firma.listaRobotnikow();

		System.out.println();
		System.out.println("Lista Urzednikow");
		firma.listaUrzednikow();
	}
}