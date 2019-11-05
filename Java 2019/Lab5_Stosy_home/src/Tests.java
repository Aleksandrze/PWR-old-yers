import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;



public class Tests {
	Scanner odczyt;

	public void obliczWyrazenia(String plik) {
		String s = "";
		try {
			Scanner wczytaj = new Scanner(new BufferedReader(new FileReader(new File(plik))));
			while (wczytaj.hasNext()) {
				s = wczytaj.nextLine();
				System.out.println(s + " = " + RPN.calculate(s));
			}
			wczytaj.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//---
	public void sprawdzStos() {
		StosTablicowyNP<String> stos = new StosTablicowyNP<String>();
		System.out.println(stos.size() + "/" + stos.getRozmiar());
		while (odczyt.hasNext()) {
			try {
				String s[] = odczyt.nextLine().split("\\s");
				if (s[0].equals("stop")) {
					break;
				} else if (s[0].equals("pop")) {
					for (int i = 0; i < Integer.parseInt(s[1]); i++)
						System.out.print(stos.pop() + " ");
					System.out.println();
					System.out.println(stos.size() + "/" + stos.getRozmiar());
				} else {
					for (String c : s)
						stos.push(c);
					System.out.println(stos.size() + "/" + stos.getRozmiar());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}