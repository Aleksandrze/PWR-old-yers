package main;

import java.util.Random;

import sortowanie.MergeSort;
import sortowanie.QuickSort;

public class Sort {
	public int[] test10 = new int[10];
	public int[] test100 = new int[100];
	public int[] test500 = new int[500];

	public void sortuj() {
		int[][] collections = { test10, test100, test500 };
		for (int[] c : collections) {
			int len = c.length;
			int temp = 0;

			for (int i = 0; i < len; i++)
				for (int j = 1; j < (len - i); j++)
					if (c[j - 1] > c[j]) {
						// swap elements
						temp = c[j - 1];
						c[j - 1] = c[j];
						c[j] = temp;
					}
		}
	}

	public void sortujOdwrotnie() {
		int[][] collections = { test10, test100, test500 };
		for (int[] c : collections) {
			int len = c.length;
			int temp = 0;

			for (int i = 0; i < len; i++)
				for (int j = 1; j < (len - i); j++)
					if (c[j - 1] < c[j]) {
						// swap elements
						temp = c[j - 1];
						c[j - 1] = c[j];
						c[j] = temp;
					}
		}
	}

	public void losuj() {
		Random rand = new Random();
		int[][] collections = { test10, test100, test500 };
		for (int[] c : collections)
			for (int i = 0; i < c.length; i++)
				c[i] = rand.nextInt(50) + 1;

	}

	public void pokaz(QuickSort bs, MergeSort ms) {
		if (bs.getPorownania() < 100)
			System.out.println("porownania = " + bs.getPorownania() + "\t\tporownania = " + ms.getPorownania());
		else
			System.out.println("porownania = " + bs.getPorownania() + "\tporownania = " + ms.getPorownania());
		if (bs.getPrzepisania() > 9)
			System.out.println("przepisania = " + bs.getPrzepisania() + "\tprzepisania = " + ms.getPrzepisania());
		else
			System.out.println("przepisania = " + bs.getPrzepisania() + "\t\tprzepisania = " + ms.getPrzepisania());
		System.out.println("zamiany = " + bs.getZamiany() + "\t\tzamiany = " + ms.getZamiany()+"\n");
	}

	public String showArr(int[] a) {
		String output = "";
		for (int i = 0; i < a.length - 1; i++)
			output += a[i] + ", ";
		output += a[a.length - 1];
		return output;
	}
	public String show(int[] a){
String test ="";
for(int i=0; i<a.length; i++) {
	test += a[i] + ", ";
}
		return test;
		}
}