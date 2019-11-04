import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Skrabble_alfabet {

	public static String slowo = "";
	static int summ;
	public static String alfabet = "ABCDEFGHIJKLMNOPRSTUWXYZVQabcdefghijklmnoprstuwxyz";
	static int[] punkt = { 1, 3, 2, 2, 1, 5, 3, 3, 1, 3, 2, 2, 2, 1, 1, 2, 1, 1, 2, 3, 1, 2, 2, 1, 2, 4, 1, 3, 2, 2, 1,
			5, 3, 3, 1, 3, 2, 2, 2, 1, 1, 2, 1, 1, 2, 3, 1, 2, 2, 1, 2, 4 };
	public static BufferedReader ridew = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter write = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void wpiszSlowo() throws IOException {
		System.out.println("Wpisz slowo");
		while (!slowo.endsWith("END")) {
			slowo = ridew.readLine();
			if (slowo.endsWith("END")) {
				System.out.println("Stop slowo");
			StopProgram();
			} else {
				liczPunkt();
			}
		}
	}

	public static void liczPunkt() throws IOException {
		for (int i = 0; i < slowo.length(); i++) {
			summ += punkt[alfabet.indexOf(slowo.charAt(i))];
		}
		write.flush();
		System.out.println("Liczba punktow: " + summ);
		summ = 0;
	}

	public static void StopProgram() throws IOException {
		ridew.close();
		write.close();
	}

	public static void main(String[] args) throws IOException {
		wpiszSlowo();
	}

}
