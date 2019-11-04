
import java.io.*;
import java.util.*;

class CopingPlik {
	private List<String> lista;

	public void Coping() {
		String plik01; String plik02;
		Scanner sc = new Scanner(System.in);
		System.out.println("Wpisz plik z jakego bendziem kopiewoc");
		plik01 = sc.nextLine();
		System.out.println("Wpisz plik w ktory to robim");
		plik02 = sc.nextLine();
		lista = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(new File(plik01)))) {
			String linia = reader.readLine();
			while (linia != null) {
				lista.add(linia);
				linia = reader.readLine();
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		for (int j = 0; j < lista.size(); j++) {
			lista.set(j, lista.get(j).replaceAll("\\s+", " "));

		}

		Iterator<String> i = lista.iterator();

		try (PrintWriter writer = new PrintWriter(new File(plik02))) {
			for (String s : lista) {
				writer.println(s);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}


