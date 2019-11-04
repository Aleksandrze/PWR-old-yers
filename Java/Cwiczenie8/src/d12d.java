
public class d12d {
	private static void wHanoi(int src, int dst, int klocki) {
		int pomoc = 6 - (src + dst); 

		if (klocki == 1)
			System.out.println(src + " => " + dst);
		else {
			wHanoi(src, pomoc, klocki - 1);
			wHanoi(src, dst, 1);
			wHanoi(pomoc, dst, klocki - 1);
		}
	}

	public static void main(String[] args) {

		wHanoi(1, 3, 4);
	}

}
