
public class Zegar {

	private int godz;
	private int min;
	private int sek;
	private static int count;

	public Zegar(int godz, int min, int sek) {
		count++;
		this.godz = godz;
		this.min = min;
		this.sek = sek;
	}

	public Zegar() {

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
		return "Zegar [" + godz + ":" + min + ":" + sek + "]";
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
	


	public static void main(String[] args) {

		Zegar zega = new Zegar(23, 59, 49);
		System.out.println(zega);
		System.out.println("czy nasz czas jest równy z czasem podanym w parametrze: " + zega.equals(15, 18, 15));
		zega.plusGodz();
		System.out.println(zega);
		zega.minusGodz();
		System.out.println(zega);
		zega.plusSek();
		System.out.println(zega);
		zega.plusSek(2);
		System.out.println(zega);

		Zegar zega2 = new Zegar(3, 15, 48);
	
		System.out.println("Zegarow stwozone: " + Zegar.count);
		

		
	}



}
