
import java.io.*;
import java.util.*;

class Przetwarzanie {
	private List<String> lista;

	public Przetwarzanie(String staryPlik, String nowyPlik) {
		lista = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(new File(staryPlik)))) {
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

		while (i.hasNext()) {
			boolean ukosnik = false;
			String s = i.next();

			for (int j = 0; j < 2; j++) {
				if (s.charAt(j) == ('/')) 
					ukosnik = true;
				else
					ukosnik = false;
			}

			if (ukosnik == true)
				i.remove();
		}

		try (PrintWriter writer = new PrintWriter(new File(nowyPlik))) {
			for (String s : lista) {
				writer.println(s);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}


