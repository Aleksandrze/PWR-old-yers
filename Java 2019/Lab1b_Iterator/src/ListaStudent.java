
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ListaStudent {
	private ArrayList<Student> studenci = new ArrayList<Student>();
	private String naglowek = "";

	public void wczytajPlik(String plik) {
		try {
			Scanner wczytaj = new Scanner(new BufferedReader(new FileReader(new File(plik))));
			if (wczytaj.hasNext())
				this.naglowek = (String) wczytaj.nextLine();
			while (wczytaj.hasNext())
				dodajStudenta(wczytaj.nextLine().split("\\s"));
			wczytaj.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dodajStudenta(String[] parametry) {
		try {
			studenci.add(new Student(parametry[0], parametry[1], parametry[2], Double.parseDouble(parametry[3])));
		} catch (Exception e) {
			System.err.println("Blad w pliku tekstowym!");
		}
	}

	public void wyswietlStudentow() {
		Iterator<Student> it = studenci.iterator();
		while (it.hasNext())
			it.next().wyswietlStudenta();
		System.out.println();
	}

	public void wpiszOcene(String nazwisko, String imie, Double nowaOcena) {
		for (Student student : studenci)
			if (student.getNazwisko().equals(nazwisko) && student.getImie().equals(imie)) {
				student.setOcena(nowaOcena);
			}
		System.out.println("Ocena zminiena");
	}

	public void wyswietlSrednia() {
		double srednia = 0;
		int counter = 0;
		for (Student student : studenci)
			if (student.getOcena() >= 3) {
				srednia += student.getOcena();
				counter++;
			}
		if (counter != 0)
			srednia /= counter;
		System.out.printf("Srednia z ocen pozytywnych:\t%.1f%n%n%n", srednia);
	}

	public void wyswietNieZalicz() {
		System.out.println("Studenty nie zaliczyli kurs \n");
		for (Student student : studenci)
			if (student.getOcena() < 3)
				student.wyswietlStudenta();
		System.out.println();
	}

	public void zapiszNowyPlik(String plik, String naglowek) {
		try {
			BufferedWriter zapisz = new BufferedWriter(new FileWriter(new File(plik), false));
			zapisz.write(naglowek);
			for (Student student : studenci) {
				zapisz.newLine();
				zapisz.write(student.formatuj());
			}
			zapisz.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void zapiszStudentow(String plik) {
		this.zapiszNowyPlik(plik, this.naglowek);
	}
}