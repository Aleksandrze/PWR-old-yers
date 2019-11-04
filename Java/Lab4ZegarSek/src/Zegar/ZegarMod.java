package Zegar;

public class ZegarMod {
	public int sek;
	public static int ile;

	public ZegarMod() {
		System.out.println("Utworzenie zegara dla czasu 00:00:00");
		sek = 0;
		ile++;
	}

	public ZegarMod(int g, int m, int s) {
		sek = g * 3600 + m * 60 + s;
		ile++;
	}

	public String toString() {
		String godziny, minuty, sekundy;
		if (sek > 86399) {
			sek -= 86400;
		}
		if (sek < 0) {
			sek += 86400;
		}
		if (sek / 3600 < 10) {
			godziny = "0" + sek / 3600 + ":";
		} else {
			godziny = sek / 3600 + ":";
		}
		if (((sek - ((sek / 3600) * 3600)) / 60) < 10) {
			minuty = "0" + (sek - ((sek / 3600) * 3600)) / 60 + ":";
		} else {
			minuty = (sek - ((sek / 3600) * 3600)) / 60 + ":";
		}
		if ((sek % 60) < 10) {
			sekundy = "0" + sek % 60 + "";
		} else {
			sekundy = sek % 60 + "";
		}

		System.out.print("Tworzym zegar: ");

		return godziny + minuty + sekundy;
	}

	public boolean equals(int g, int m, int s) {
		if (sek == g * 3600 + m * 60 + s) {
			return true;
		}
		return false;
	}

	public void plusGodz() {
		System.out.println("Plus godzine");
		sek += 3600;
	}

	public void minusGodz() {
		System.out.println("Minus godzine");
		sek -= 3600;
	}

	public void plusSek() {
		System.out.println("Plus sekunde");
		sek++;
	}

	public void plusSek(int n) {
		System.out.println("Plus " + n + " sekund");
		sek += n;
	}

	public int compare(int g, int m, int s) {
		System.out.println();
		System.out.println("Tworzym  zegar dla compare " + g + ":" + m + ":" + s);
		if (sek == g * 3600 + m * 60 + s) {
			return 0;
		}
		if (sek > g * 3600 + m * 60 + s) {
			return -1;
		}
		return 1;
	}

	public static void main(String[] args) {
		ZegarMod z0 = new ZegarMod();
		System.out.println(z0);
		System.out.println("----------------------------");

		ZegarMod z1 = new ZegarMod(23, 15, 15);
		ZegarMod testEquals = new ZegarMod(12, 15, 16);
		System.out.println(z1);
		System.out.println(testEquals + " sprawdzim zegary w equals() -  " + z1.equals(testEquals));
		z1.plusGodz();
		System.out.println(z1);
		System.out.println("-----------------------------");
		ZegarMod z2 = new ZegarMod(0, 54, 30);
		System.out.println(z2);
		z2.minusGodz();
		System.out.println(z2);
		System.out.println("-----------------------------");

		ZegarMod z3 = new ZegarMod(23, 59, 59);
		System.out.println(z3);
		z3.plusSek();
		System.out.println(z3);
		System.out.println("-----------------------------");

		ZegarMod z4 = new ZegarMod(23, 59, 30);
		System.out.println(z4);
		z4.plusSek(50);
		System.out.println(z4);
		System.out.println("-----------------------------");

		ZegarMod z5 = new ZegarMod(23, 55, 34);
		System.out.println(z5);
		System.out.println("Naszy zegary w  compare(): " + z5.compare(23, 55, 14));

		System.out.println("-----------------------------");
		System.out.println("Zegarow jest: " + ile);
	}
}