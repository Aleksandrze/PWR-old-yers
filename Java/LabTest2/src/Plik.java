import java.util.*;
import java.io.*;

class Plik {
	private List<String> lista;

	//czytanie plika
	public Plik(String nazwaPliku) {
		lista = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(new File(nazwaPliku)))) {
			String linia = reader.readLine();
			while (linia != null) {
				lista.add(linia);
				linia = reader.readLine();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public int ileZnakow() {
		int znaki = 0;
		String[] wyrazy;
		for (String s : lista) {
			s = s.replaceAll("\\s+", " ");
			wyrazy = s.split(" ");

			for (int i = 0; i < wyrazy.length; i++) {
				znaki = znaki + wyrazy[i].length();
			}
		}
		return znaki;
	}

	public int ileWierszy() {
		return lista.size();
	}

	public int najdluzszyWiersz() {
		int znaki = 0;
		for (String s : lista) {
			if (znaki < s.length())
				znaki = s.length();
		}
		return znaki;
	}

	public int ileWyrazow() {
		int liczbaWyrazow = 0;
		String[] wyrazy;

		for (String s : lista) {
			s = s.replaceAll("\\s+", " ");
			wyrazy = s.split(" ");
			liczbaWyrazow = liczbaWyrazow + wyrazy.length;
		}
		return liczbaWyrazow;
	}

	public int ileRazy() {
		String slowo;
		Scanner wczytanie = new Scanner(System.in);
		System.out.println("podaj wyraz");
		slowo = wczytanie.nextLine();

		wczytanie.close();

		int ile = 0;
		String[] wyrazy;

		for (String s : lista) {
			s = s.replaceAll("\\s+", " ");
			wyrazy = s.split(" ");

			for (int i = 0; i < wyrazy.length; i++) {
				if (wyrazy[i].equals(slowo))
					ile++;
			}
		}
		return ile;
	}
}
