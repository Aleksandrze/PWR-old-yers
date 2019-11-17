
public class Main {

	public static void main(String[] args) {

		Model m = new Model();
		m.dodajProcesy();
		System.out.println("Przydział równy: ");
		m.przydzialRowny();
		m.LRUdlaRiP();
		System.out.println("\n Przydział proporcjonalny: ");
		m.przydzialProporcjonalny();
		m.LRUdlaRiP();
		System.out.println("\n Sterowanie częstością błędów braku stron: ");
		m.LRUdlaSLIB();
		System.out.println("\nModel strefowy: ");
		m.LRUdlaMS();
	}
}
