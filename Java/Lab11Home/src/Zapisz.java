import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Zapisz {
	
	
	double[][] macierz;

	Scanner in = new Scanner(System.in);
	int liczbaW;
	int liczbaK;
	int zakresLiczbOd;
	int zakresLiczbDo;
	public Zapisz() {
	 
	System.out.print("Podaj liczbę wierszy: ");
	this.liczbaW = in.nextInt();
	System.out.print("Podaj liczbę kolumn: ");
	this.liczbaK = in.nextInt();
	System.out.print("Podaj zakres liczb od: ");
	this.zakresLiczbOd = in.nextInt();
	System.out.print("do: ");
	this.zakresLiczbDo = in.nextInt();
	this.macierz = new double[liczbaW][liczbaK];

	try {
		for (int i = 0; i < macierz.length; i++) {
			for (int j = 0; j < macierz[i].length; j++) {
				macierz[i][j] =  (Math.random() *  ((zakresLiczbDo - zakresLiczbOd) + zakresLiczbDo));
				System.out.printf("%2.2f",macierz[i][j]);
				System.out.print("\t");
			}
			System.out.print("\n");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}

}

public void zapiszBin(String plik) throws IOException {


	DataOutputStream zapisz = new DataOutputStream(new FileOutputStream(plik));

	zapisz.write((byte) macierz.length);
	zapisz.write((byte) macierz[0].length);

	for (int i = 0; i < macierz.length; i++)
		for (int j = 0; j < macierz[0].length; j++) {
			zapisz.writeDouble(macierz[i][j]);
		}

	zapisz.close();

}



}