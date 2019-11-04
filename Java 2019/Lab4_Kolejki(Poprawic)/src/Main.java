
public class Main {

	public static void main(String[] args) throws EmptyQueueException {
/*		Kolejka k = new Kolejka();
		k.enqueue("test");
		k.enqueue("kolejka");
		k.enqueue("pszerwa");
		k.wyswietl();
		System.out.println("");
		k.enqueue("H2O");
		k.enqueue("Java");
		k.wyswietl();
		System.out.println("");
		System.out.println("Rozmiar: " + k.size());
		System.out.println("Usywanie: ");
		System.out.println("delete: " + k.dequeue());
		System.out.println("delete: " + k.dequeue());
		System.out.println("delete: " + k.dequeue());
		System.out.println("\nUpdate kolejki:");
		System.out.println("Rozmiar: " + k.size());
		k.wyswietl();
		k.clear();
		System.out.println("Rozmiar: " + k.size());
		k.dequeue();
		
		k.dequeue();*/
		

			Bufor b = new Bufor(5);
			try {
			b.enqueue("Test");
			b.enqueue("H2O");
			b.enqueue("Sky");
			b.enqueue("coca-cola");
			b.enqueue("pacman");
	
			b.wyswietl();
			System.out.println();
			b.enqueue("chleb");
			System.out.println("");
			System.out.println("Usynuc element: " + b.dequeue());
			System.out.println("Usynuc element: " + b.dequeue());
			System.out.println("");
			b.wyswietl();
			System.out.println("Usynuc element: " + b.dequeue());
			b.enqueue("ser001");

			b.wyswietl();
			System.out.println("Usynuc element: " + b.dequeue());
			System.out.println("Usynuc element: " + b.dequeue());
			System.out.println("Usynuc element: " + b.dequeue());
			System.out.println("Usynuc element: " + b.dequeue());

		} catch (EmptyQueueException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
