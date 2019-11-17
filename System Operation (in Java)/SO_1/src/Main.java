
public class Main {
	public static void main(String[] args) {

		Generuj gen = new Generuj();

		// ustalamy parametry symulacji (ilosc procesow, dugosc procesu,maksymalny czas}

		gen.CreateProces(300, 2000, 150);

		// pokaż wszystki procesy

		gen.seeProces();

		System.out.println("Sredni czas dla FCFS: " + gen.sredniCzasFCSF());
		System.out.println("Sredni czas dla RR: " + gen.sredniRot());
		System.out.println("Sredni czas dla SJF: " + gen.sredniSJF());
	}

}
