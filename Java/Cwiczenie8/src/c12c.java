
public class c12c {

	public int fibonacciIteracja(int n) {
		int pierwszy = 1;
		int drugi = 1;
		int pomocnicza = 1;

		for (int i = 2; i < n; i++) {
			pomocnicza = pierwszy + drugi;
			pierwszy = drugi;
			drugi = pomocnicza;
		}

		return pomocnicza;
	}

	public int fibonacciRekurencja(int n) {
		return n < 2 ? n : fibonacciRekurencja(n - 1) + fibonacciRekurencja(n - 2);
	}

	public static void main(String[] args) {
		c12c fibo = new c12c();
		int fiboIter, fiboRek = 0;

		fiboIter = fibo.fibonacciIteracja(6);
		fiboRek = fibo.fibonacciRekurencja(6);

		System.out.println("Iteracja: " + fiboIter);
		System.out.println("Rekurencja: " + fiboRek);
	}

}
