
public class Trojkat {

	private int a, b, c;

	public Trojkat(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public void drukuj() {
		System.out.println("A: " + a);
		System.out.println("B: " + b);
		System.out.println("C: " + c);
	}

	public boolean czyMoznaZbudowac() {
		if (a + b >= c && b + c >= a && a + c >= b) {
			return true;
		} else {
			return false;
		}
	}

	public void info() {
		if (!czyMoznaZbudowac()) {
			System.out.println("Nie mozna zbudowac tego trojkąta");

		} else {
			System.out.println(" Mozna budowac");

		}
	}

	private String jakiOn() {
		String opis;
		if (a == b && b == c) {
			opis = "rownoboczny";
		} else if (a == b || b == c || a == c) {
			opis = "rownoramienny";
		} else {
			opis = "roznoboczny";
		}
		return opis;
	}

	public float pola() {
		double p = (a + b + c) / 2.0f;
		return (float) Math.sqrt(p * (p - a) * (p - b) * (p - c));

	}

	public float obw() {
		return a + b + c;

	}

	private String katyTrojkata() {
		String opis;
		if ((a * a + b * b > c * c)&&(c * c + b * b > a * a)&&(a * a + c * c > a * a)) {
			opis = "ostrokatny";
		} else 
			if (a * a + b * b == c * c) {
				opis = "prostokatny";
			} else {
				opis = "rozwartokatny";
			}
			return opis;
		
	}

	public void zwoz() {
		if (czyMoznaZbudowac() == true) {
			System.out.println(" Mozna budowac");
			System.out.println("On :" + jakiOn());
			System.out.println("Kat : " + katyTrojkata());
			System.out.println("Pola : " + pola());
			System.out.println("Obw :" + obw());

		} else {
			System.out.println("Nie mozna zbudowac tego trojkąta");

		}

	}

	public static void main(String[] args) {

		Trojkat t1 = new Trojkat(3, 3, 3);
		t1.zwoz();
		System.out.println("-------");
		Trojkat t2 = new Trojkat(3, 4, 3);
		t2.zwoz();
		System.out.println("-------");

		Trojkat t3 = new Trojkat(3, 4, 5);
		t3.zwoz();
		System.out.println("-------");

		Trojkat t4 = new Trojkat(800, 4, 8);
		t4.zwoz();
		System.out.println("-------");

		Trojkat t5 = new Trojkat(10, 4, 12);
		t5.zwoz();

	}
}