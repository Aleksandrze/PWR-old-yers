import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

public class PlikA {
	ArrayList<Point> list;
	ArrayList<Point> lista;
	Random r = new Random();
	BufferedWriter bw;
	BufferedReader br;
	BufferedWriter bw2;
	DataInputStream da;
	StringTokenizer tokinazier;

	public PlikA() {
		list = new ArrayList<>();
	}

	public void uzup(int z, int n) {
		for (int i = 0; i < n; i++) {
			list.add(new Point(r.nextInt(z * 2) - z, r.nextInt(z * 2) - z));
		}
	}

	public void wys() {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).x + " : " + list.get(i).y);
		}
	}

	public void zapisz(String plik) throws IOException {
		bw = new BufferedWriter(new FileWriter(plik));
		bw.write("Liczba punktow " + list.size());
		bw.newLine();
		bw.write("x \t y");
		bw.newLine();
		for (Point t : list) {

			bw.write(t.x + "\t" + t.y);
			bw.newLine();
		}
		bw.close();
	}

	/*
	 * public void czytaj(String plik2) throws IOException { // br = new
	 * BufferedReader(new FileReader(plik2)); lista = new ArrayList<Point>(); da =
	 * new DataInputStream(new FileInputStream(plik2));
	 * System.out.println(da.readInt()); for(int i =0; i<da.readInt()-1;i++) {
	 * lista.add(new Point(da.read(),da.read())); } }
	 */
//---------------------------------------------------------------------------------
	public void czytaj(String plik2) throws IOException {
		lista = new ArrayList<Point>();
		br = new BufferedReader(new FileReader(plik2));
		String line;
		br.readLine();
		br.readLine();

		while ((line = br.readLine()) != null) {
			tokinazier = new StringTokenizer(line);
			lista.add(new Point(Integer.valueOf(tokinazier.nextToken()), Integer.valueOf(tokinazier.nextToken())));
		}
	}

	public void wys2() {
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i).x + " : " + lista.get(i).y);
		}
	}

	public double odleglosc(Point p) {
		return Math.sqrt(Math.pow(p.x, 2) + Math.pow(p.y, 2));
	}

	public void B1b() {
		Point max = new Point();
		for (Point p : lista) {
			if (odleglosc(p) > odleglosc(max)) {
				max = p;
			}
		}
		System.out.println("Najbardziej odleglu punkt " + max.x + " " + max.y);
	}

	public void B2() {
		int maxX = 0;
		int maxY = 0;
		int minX = 0;
		int minY = 0;
		for (Point p : lista) {
			if (maxX < p.x) {
				maxX = p.x;
			}
			if (maxY < p.y) {
				maxY = p.y;
			}
			if (minX > p.x) {
				minX = p.x;
			}
			if (minY > p.y) {
				minY = p.y;
			}
		}
		System.out.println("Pola malego prostokota biedzie miec wsporzendne: ");
		System.out.println("x \t y");
		System.out.println(maxX + " \t " + maxY);
		System.out.println(maxX + " \t" + minY);
		System.out.println(minX + " \t" + maxY);
		System.out.println(minX + " \t" + minY);
	}

	public double odleglosc(Point p, Point pt) {
		return Math.sqrt(Math.pow(p.x - pt.x, 2) + Math.pow(p.y - pt.y, 2));
	}

	public void B3() throws IOException {
/*		System.out.println("Tabela odległosci punktow");
		for (int i = 0; i < lista.size(); i++) {
			for (int j = i + 1; j < lista.size(); j++) {
				System.out.printf("%,2f", odleglosc(lista.get(i), lista.get(j)));
				System.out.println();
			}
		}*/
	}

/*	public void B4() {
		int[] tab = new int[lista.size()];
		for (int i = 0; i < lista.size(); i++) {
		for (int j = i + 1; j < lista.size(); j++) {
			System.out.printf("%,2f", odleglosc(lista.get(i), lista.get(j)));
			System.out.println();
		}
		}
	}*/

//_--------------------Main-------------------------
	public static void main(String[] args) throws IOException {
		PlikA a = new PlikA();
/*		a.uzup(10, 6);
		a.wys();
		a.zapisz("plik.txt");
		System.out.println("___________________________");*/
		a.czytaj("plik.txt");
		a.wys2();
		a.B1b();
		System.out.println("___________________________");
		a.B2();
		System.out.println("___________________________");
		a.B3();
		//a.B4();
	}
}
