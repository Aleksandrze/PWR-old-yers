
public class Main {
	public static void main(String[] args) {
/*		HashTable<Student> hash = new HashTable<Student>();
		Student s1 = new Student("258056", "Wiktoria", "Korczakow");
		Student s2 = new Student("258056", "Wiktoria", "Korczakow");
		Student s3 = new Student("255153", "Maciej", "Plich");
		Student s4 = new Student("255154", "Andrzej", "Duda");
		Student s5 = new Student("245165", "Wladyslaw", "Nowak");
		Student s6 = new Student("255177", "Grzegorz", "Puta");
		Student s7 = new Student("258056", "Wiktoria", "Korczakow");

		System.out.println("Tablica jest pusta: " + hash.isEmpty());

		hash.put(s1.getNumerIndeksu(), s1);
		hash.put(s2.getNumerIndeksu(), s2);
		hash.put(s3.getNumerIndeksu(), s3);
		hash.put(s4.getNumerIndeksu(), s4);
		hash.put(s5.getNumerIndeksu(), s5);
		hash.put(s6.getNumerIndeksu(), s6);
		hash.put(s7.getNumerIndeksu(), s7);

		System.out.println("\nSzukamy (get(key)):");
		System.out.println(hash.get(s2.getNumerIndeksu()));
		System.out.println(hash.get(s1.getNumerIndeksu()));
		System.out.println(hash.get("000000"));
		System.out.println(hash.get("245165"));
		System.out.println();

		System.out.println("Tablica jest pusta:" + hash.isEmpty());
		System.out.println("Rozmiar " + hash.size());
		System.out.println();

		hash.dump();*/
		
		
		HashTable2<Student> hash = new HashTable2<Student>(10);
		Student s1 = new Student("258056", "Wiktoria", "Korczakow");
		Student s2 = new Student("258056", "Wiktoria", "Korczakow");
		Student s3 = new Student("255153", "Maciej", "Plich");
		Student s4 = new Student("255154", "Andrzej", "Duda");
		Student s5 = new Student("245165", "Wladyslaw", "Nowak");
		Student s6 = new Student("255177", "Grzegorz", "Puta");
		Student s7 = new Student("258056", "Wiktoria", "Korczakow");

		System.out.println("Tablica jest pusta: " + hash.isEmpty());

		hash.put(s1.getNumerIndeksu(), s1);
		hash.put(s2.getNumerIndeksu(), s2);
		hash.put(s3.getNumerIndeksu(), s3);
		hash.put(s4.getNumerIndeksu(), s4);
		hash.put(s5.getNumerIndeksu(), s5);
		hash.put(s6.getNumerIndeksu(), s6);
		hash.put(s7.getNumerIndeksu(), s7);

		System.out.println("\nSzukamy (get(key)):");
		System.out.println(hash.get(s2.getNumerIndeksu()));
		System.out.println(hash.get(s1.getNumerIndeksu()));
		System.out.println(hash.get("000000"));
		System.out.println(hash.get("245165"));
		System.out.println();

		System.out.println("Tablica jest pusta:" + hash.isEmpty());
		System.out.println("Rozmiar " + hash.size());
		System.out.println();

		hash.dump();
	}
}
