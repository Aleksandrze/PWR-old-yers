import java.util.*;
import java.awt.Toolkit;
import java.io.*;

class Plik {
	private List<String> lista;

	// czytanie plika
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

	public int ZnakiCzarny() {
		int syboly = 0;
		String[] wyrazy;
		for (String s : lista) {
			s = s.replaceAll("\\s+", " ");
			wyrazy = s.split(" ");
			for (int i = 0; i < wyrazy.length; i++) {
				syboly = syboly + wyrazy[i].length();
			}
		}
		return syboly;
	}

	public int WszystkiZnaki() {
		int syboly = 0;
		String[] wyrazy;
		for (String s : lista) {
			wyrazy = s.split("");
			for (int i = 0; i < wyrazy.length; i++) {
				syboly = syboly + wyrazy[i].length();
			}
		}
		return syboly;
	}

	public int ileWyrazow() {
		int ileWyraz = 0;
		String[] wyrazy;
		for (String s : lista) {
			s = s.replaceAll("\\s+", " ");
			wyrazy = s.split(" ");
			ileWyraz = ileWyraz + wyrazy.length;
		}
		return ileWyraz;
	}

	public int ileWierszy() {
		return lista.size();
	}

	public int najdluzszyWiersz() {
		int znaki = 0;
		for (String s : lista) {
			if (znaki < s.length()) {
				znaki = s.length();
			}
		}
		return znaki;
	}

	public int najdluzszyWyraz() {
		int max = 0;
		StringTokenizer buffer;
		for (int i = 1; i < lista.size(); i++) {
			buffer = new StringTokenizer(lista.get(i));
			while (buffer.hasMoreTokens()) {
				String t = buffer.nextToken();
				if (max < t.length()) {
					max = t.length();
				}
			}
		}
		return max;
	}
	


	public int ileRazy() {
		String slowo;
		Scanner wczytanie = new Scanner(System.in);
		System.out.println(" ");
		System.out.println("Podaj wyraz");
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
