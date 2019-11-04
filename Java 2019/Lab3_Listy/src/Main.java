
public class Main {

	public static void main(String[] args) {

		ListElemnt lista = new ListElemnt();

		lista.add("test");
		lista.add("toster");
		lista.add("PC");
		lista.wyswietlListe();
		System.out.println("\n Insert");
		lista.insert(2, "PC");
		lista.wyswietlListe();

/*		System.out.println("Size \n " + lista.size());
		lista.clear();
		lista.wyswietlListe();
		System.out.println("Size \n " + lista.size());*/

		// =============
		System.out.println(lista.set(3, "BOX"));
		System.out.println("\nSet\n");
lista.wyswietlListe();
		System.out.println("\niterator");
		Iterator it = lista.iterator();
		for (it.first(); !it.isDone(); it.next()) {
			System.out.println(it.current());
		}
		System.out.println("");
		System.out.println("get 2 " + lista.get(2));
		System.out.println("contains PK " + lista.contains("PK"));
		System.out.println("contains toster " + lista.contains("toster"));
		System.out.println("test index of " + lista.indexOf("teset"));
		System.out.println("BOX index of " + lista.indexOf("test"));
		System.out.println("PK index of " + lista.indexOf("PK"));
		System.out.println("size " + lista.size());
		System.out.println("Delete : " + lista.delete(1));
		System.out.println("size " + lista.size());


	}

}
