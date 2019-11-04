import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Tablica {

    Scanner in = new Scanner(System.in);
    double[][] macierz;
    int liczbaW;
    int liczbaK;
    int min;
    int max;
	int indeksWiersze = 0;
	int indeksKolumny = 0;

    public Tablica() {

        System.out.print("Podaj liczbę wierszy:");
        this.liczbaW = in.nextInt();
        System.out.print("Podaj liczbę kolumn:");
        this.liczbaK = in.nextInt();
        System.out.print("Podaj zakres liczb od:");
        this.min = in.nextInt();
        System.out.print(" do:");
        this.max = in.nextInt();
        System.out.println("==============================================================");
        this.macierz = new double[liczbaW][liczbaK];

        macierz = new double[liczbaK][liczbaK];

        for(int i = 0; i < macierz.length; i++) {
            for(int j = 0; j < macierz[i].length; j++) {
                macierz[i][j] = (int)(Math.random() * (max - min)) + min;
            }
        }

        for(int i = 0; i < macierz.length; i++) {
            for(int j = 0; j < macierz[i].length; j++) {
               System.out.printf("%2.2f", macierz[i][j]);
               System.out.print("\t");

            }
            System.out.print("\n");

        }

    }
    


    public void zapiszDoPliku() {
        try {
            BufferedWriter zapiszDoMacierzy = new BufferedWriter(new FileWriter("tablica.txt"));
            zapiszDoMacierzy.write("Macierz");
            zapiszDoMacierzy.newLine();
            zapiszDoMacierzy.write(Integer.toString(macierz.length));
            zapiszDoMacierzy.newLine();
            zapiszDoMacierzy.write(Integer.toString(macierz[0].length));
            zapiszDoMacierzy.newLine();
            for(int i = 0; i < macierz.length; i++) {
                for(int j = 0; j < macierz[i].length; j++) {
                    zapiszDoMacierzy.write( String.format("%,2f", macierz[i][j]) );
                    zapiszDoMacierzy.write("\t");
                }
                zapiszDoMacierzy.newLine();
            }
            zapiszDoMacierzy.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    
    
    
// z pliku
    public void wczytajMacierz() {
        int wiersz;
        int kolumna;
        double[][] macierz2 = null;
        try {
            BufferedReader wczytajZpliku = new BufferedReader(new FileReader("tablica.txt"));
            wczytajZpliku.readLine();
            wiersz = Integer.parseInt(wczytajZpliku.readLine());
            kolumna = Integer.parseInt(wczytajZpliku.readLine());
            macierz2 = new double[wiersz][kolumna];
            for(int i = 0 ; i < wiersz; i++) {
                String[] a = (wczytajZpliku.readLine()).split("\t");
                for(int j = 0; j < kolumna; j++) {
                    macierz2[i][j] = Double.parseDouble(a[j].replace(",", "."));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        
// _____________________________________Wyswietlenie macierzy_____________________________________________
        for(int i = 0; i < macierz.length; i++) {
            for(int j = 0; j < macierz[i].length; j++) {
                System.out.print("\t");
                System.out.printf("%2.2f",macierz[i][j]);
                System.out.print("\t");
            }
            System.out.print("\n");
        }
    }
        
    	public void min() {

    		for (int i = 0; i < macierz.length; i++) {
    			for (int j = 0; j < macierz[i].length; j++) {
    				if (macierz[i][j] < macierz[indeksWiersze][indeksKolumny]) {
    					indeksWiersze = i;
    					indeksKolumny = j;
    				}
    			}
    		}
    		System.out.println();
    		System.out.println(" Min tablicy:  ");
    		System.out.printf("%2.2f", macierz[indeksWiersze][indeksKolumny]);
    	}

    	public void max() {

    		for (int i = 0; i < macierz.length; i++) {
    			for (int j = 0; j < macierz[i].length; j++) {
    				if (macierz[i][j] > macierz[indeksWiersze][indeksKolumny]) {
    					indeksWiersze = i;
    					indeksKolumny = j;
    				}
    			}
    		}
    		System.out.println();
    		System.out.println(" Max tablicy:  ");
    		System.out.printf("%2.2f", macierz[indeksWiersze][indeksKolumny]);
    	}





    public static void main(String[] args) {

        Tablica macierz1 = new Tablica();

        System.out.println("Macierz zapisana w pliku");
       macierz1.zapiszDoPliku();

        System.out.println("==============================================================");
        System.out.println();
        System.out.println("Macierz odczytana z pliku");
        System.out.println();
        macierz1.wczytajMacierz();
        macierz1.min();
        macierz1.max();
    }

}
