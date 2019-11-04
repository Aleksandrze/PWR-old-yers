import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class PlikTekst {

	public TreeSet<String> slownik = new TreeSet<>();
	public int[] czyJest = new int[alfabet.length()];
	public int[] wartosc = new int[alfabet.length()];
	public Iterator<String> iterator;
	StringTokenizer tokinazier;
	public static String alfabet = "ABCDEFGHIJKLMNOPRSTUWXYZVQabcdefghijklmnoprstuwxyz";
	BufferedReader reader;

	public PlikTekst() {
		for (int i = 0; i < alfabet.length(); i++) {
			czyJest[i] = 0;
			wartosc[i] = 0;
		}
	}

	public void plik(String nazwaPliku) throws IOException {
		String line;
		reader = new BufferedReader(new FileReader(nazwaPliku));
		while ((line = reader.readLine()) != null) {
			tokinazier = new StringTokenizer(line);
			while (tokinazier.hasMoreTokens())
				slownik.add(tokinazier.nextToken());
		}
		reader.close();
	}

	public void wys() {
		iterator = slownik.iterator();
		while (iterator.hasNext()) {
			String t = iterator.next();
			System.out.println(t);
		}
	}

	public void licz() {
		iterator = slownik.iterator();
		while (iterator.hasNext()) {
			String t = iterator.next();
			for (int i = 0; i < t.length(); i++)
				for (int j = 0; j < alfabet.length(); j++) 
					if (t.charAt(i) == alfabet.charAt(j)) {
						czyJest[j] = 1;
					}
				}

			for (int y = 0; y < alfabet.length(); y++) {
				int sum = 0;
				iterator = slownik.iterator();
				while (iterator.hasNext()) {
					String t = iterator.next();
					for (int i = 0; i < t.length(); i++) {
						if (t.charAt(i) == alfabet.charAt(y)) 
							sum++;
					}
					}
					wartosc[y] = sum;
				}
				for (int y = 0; y < alfabet.length(); y++) {
					if (czyJest[y] == 1) {
						System.out.println("Litera " + alfabet.charAt(y) + " pojawia sie " + wartosc[y]+" raz");
					}
				}
			}


	public static void main(String[] args) throws IOException {
		PlikTekst pt = new PlikTekst();
		pt.plik("plik01.txt");
		pt.wys();
		pt.licz();
	}
}