
public class Zegar {

	private int godz;
	private int min;
	private int sek;
	private static int ile;
//sek
	public Zegar(int godz, int min, int sek) {
		ile++;
		this.godz = godz;
		this.min = min;
		this.sek = sek;
	}

	public Zegar() {
		ile++;
	}

	public int getGodz() {
		return godz;
	}

	public void setGodz(int godz) {
		this.godz = godz;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getSek() {
		return sek;
	}

	public void setSek(int sek) {
		this.sek = sek;
	}

	public String toString() {
		if (godz < 10 && min < 10 && sek < 10) {
			return "Czas: 0" + godz + ":0" + min + ":0" + sek + "";
		}
		if (sek < 10) {
			return "Czas: " + godz + ":" + min + ":0" + sek + "";
		}
		if (min < 10) {
			return "Czas: " + godz + ":0" + min + ":0" + sek + "";
		}

		return "Czas: " + godz + ":" + min + ":" + sek + "";

	}

	public boolean equals(int g, int m, int s) {
		if (godz == g) {
			if (min == m) {
			}
			if (sek == s) {
			}
			return true;
		} else {
			return false;
		}
	}

	public void plusGodz() {
		boolean plus = true;
		if (plus == true) {
			if (godz == 23) {
				godz = 00;
			} else {
				godz++;
			}
		}
	}

	public void minusGodz() {
		boolean plus = false;
		if (plus == false) {
			if (godz == 00) {
				godz = 23;
			} else {
				godz--;
			}
		}
	}

	public void plusSek() {
		boolean plus = true;
		if (plus == true) {
			if (sek == 59) {
				if (min == 59) {
					plusGodz();
					min = 00;
					sek = 00;
				} else {
					sek = 00;
					min++;
				}
			} else {
				sek++;
			}
		}
	}

	public void plusSek(int n) {
		boolean plus = true;
		if (plus == true) {
			if (n < 60) {
				if (sek + n >= 60) {
					if (min == 59) {
						min = 00;
						plusGodz();
						sek = Math.abs(60 - (sek + n));
					} else {
						min++;
						sek = Math.abs(60 - (sek + n));
					}
				} else {
					sek = sek + n;
				}

			} else {
				System.out.println("n powino byc mniej niz 60");
			}
		}
	}

	public int compare(int g, int m, int s) {
		if (godz == g && min == m && sek == s) {
			return 0;
		}
		if ((godz * 3600) + (min * 60) + sek > (g * 3600) + (min * 60) + sek) {
			return -1;
		}
		return 1;
	}

	public static void main(String[] args) {

		Zegar zegar = new Zegar();
		System.out.println(zegar);
		System.out.println("-----------------");
		Zegar z2 = new Zegar(23, 45, 15);
		System.out.println(z2);
		System.out.println("Czy nasz czas jest rowny z podanym...? " + z2.equals(14, 16, 15));
		z2.plusGodz();
		System.out.println("Plus godzina:");
		System.out.println(z2);
		System.out.println("-----------------");
		Zegar z3 = new Zegar(00, 58, 59);
		System.out.println(z3);
		z3.minusGodz();
		System.out.println("Minus godzina:");
		System.out.println(z3);
		System.out.println("-----------------");
		Zegar z4 = new Zegar(23, 59, 59);
		System.out.println(z4);
		z4.plusSek();
		System.out.println("Plus sekunda:");
		System.out.println(z4);
		System.out.println("-----------------");
		Zegar z5 = new Zegar(23, 59, 59);
		System.out.println(z5);
		z5.plusSek(35);
		System.out.println("Plus 'n" + "' sekund:");
		System.out.println(z5);
		System.out.println("-----------------");
		Zegar z6 = new Zegar(17, 54, 59);
		System.out.println(z6);
		System.out.println("Czy nasz czas jest -1,1,0 ? Otp: " + z6.compare(14, 48, 45));
		System.out.println("-----------------");
		System.out.println("Stwozono zegarow - " + ile);

	}

}
