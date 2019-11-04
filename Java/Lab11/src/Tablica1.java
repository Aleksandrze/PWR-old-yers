import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Tablica1 {

    Scanner in = new Scanner(System.in);
	double[][] tab;
    int liczbaWierszy;
    int liczbaKolumn;
    int wartoscOd;
    int wartoscDo;

    public Tablica1() {

        }
    public void StworzWys() {
        System.out.print("Podaj liczbę wierszy:");
        this.liczbaWierszy = in.nextInt();
        System.out.print("Podaj liczbę kolumn:");
        this.liczbaKolumn = in.nextInt();
        System.out.print("Podaj zakres od:");
        this.wartoscOd = in.nextInt();
        System.out.print(" do:");
        this.wartoscDo = in.nextInt();
        System.out.println("==============================================================");
        this.tab = new double[liczbaWierszy][liczbaKolumn];

        tab = new double[liczbaKolumn][liczbaKolumn];

        for(int i = 0; i < tab.length; i++) {
            for(int j = 0; j < tab[i].length; j++) {
                tab[i][j] =(int)(Math.random() * (wartoscDo - wartoscOd)) + wartoscOd;
            }
        }

        for(int i = 0; i < tab.length; i++) {
            for(int j = 0; j < tab[i].length; j++) {
               System.out.printf("%2.2f", tab[i][j]);
               System.out.print("\t");

            }
            System.out.print("\n");

        }
    }


    public void zapiszDoPliku() {
        try {
            BufferedWriter zapisz = new BufferedWriter(new FileWriter("tablica.txt"));
            zapisz.write("Macierz");
            zapisz.newLine();
            zapisz.write("Liczba wierzy:  ");
            zapisz.write(Integer.toString(liczbaWierszy));
            zapisz.newLine();
            zapisz.write("Liczba kolumn:  ");
            zapisz.write(Integer.toString(liczbaKolumn));
            zapisz.newLine();
            for(int i = 0; i < tab.length; i++) {
                for(int j = 0; j < tab[i].length; j++) {
                	zapisz.write( String.format("%,2f", tab[i][j]) );
                	zapisz.write("\t");
                }
                zapisz.newLine();
            }
            zapisz.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
