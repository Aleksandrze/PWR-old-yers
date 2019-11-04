package main;

import sortowanie.MergeSort;
import sortowanie.QuickSort;

public class Main {

	public static void main(String[] args) {
		Sort m = new Sort();

		m.losuj();
		MergeSort[] ms = new MergeSort[3];
		QuickSort[] bs = new QuickSort[3];
		String c8, c32, c128;
		c8 = m.showArr(m.test10);
		for (int i = 0; i < 3; i++) {
			bs[i] = new QuickSort();
			ms[i] = new MergeSort();
		}
		// 10 elementow
		
		System.out.println("Dla 10 elementow:\n" + c8);
		System.out.println("QuickSort\t\tMergeSort");
		bs[0].sort(m.test10);
		ms[0].sort(m.test10);
		m.pokaz(bs[0], ms[0]);
		System.out.println(m.show(m.test10) + "\n");

		m.sortuj();

		System.out.println("Posortowane: ");
		System.out.println("QuickSort\t\tMergeSort");
		bs[1].sort(m.test10);
		ms[1].sort(m.test10);
		m.pokaz(bs[1], ms[1]);
		System.out.println(m.show(m.test10) + "\n");

		m.sortujOdwrotnie();
		System.out.println("Posortowane odwrotnie: ");
		System.out.println("QuickSort\t\tMergeSort");
		bs[2].sort(m.test10);
		ms[2].sort(m.test10);
		m.pokaz(bs[2], ms[2]);
		System.out.println(m.show(m.test10) + "\n");

		// 100 elementy
		
		m.losuj();
		c32 = m.showArr(m.test100);
		System.out.println("Dla 100 elementow:\n" + c32);
		System.out.println("QuickSort\t\tMergeSort");
		bs[0].sort(m.test100);
		ms[0].sort(m.test100);
		m.pokaz(bs[0], ms[0]);
		System.out.println(m.show(m.test100) + "\n");

		m.sortuj();
		System.out.println("Posortowane: ");
		System.out.println("QuickSort\t\tMergeSort");
		bs[1].sort(m.test100);
		ms[1].sort(m.test100);
		m.pokaz(bs[1], ms[1]);
		System.out.println(m.show(m.test100) + "\n");

		m.sortujOdwrotnie();
		System.out.println("Posortowane odwrotnie: ");
		System.out.println("QuickSort\t\tMergeSort");
		bs[2].sort(m.test100);
		ms[2].sort(m.test100);
		m.pokaz(bs[2], ms[2]);
		System.out.println(m.show(m.test100) + "\n");

		// 500 elementow
		
		m.losuj();
		c128 = m.showArr(m.test500);
		System.out.println("Dla 500 elementow:\n" + c128);
		System.out.println("QuickSort\t\tMergeSort");
		bs[0].sort(m.test500);
		ms[0].sort(m.test500);
		m.pokaz(bs[0], ms[0]);
		System.out.println(m.show(m.test500) + "\n");

		m.sortuj();
		System.out.println("QuickSort\t\tMergeSort");
		bs[1].sort(m.test500);
		ms[1].sort(m.test500);
		m.pokaz(bs[1], ms[1]);
		System.out.println(m.show(m.test500) + "\n");

		m.sortujOdwrotnie();
		System.out.println("Posortowane odwrotnie: ");
		System.out.println("QuickSort\t\tMERGE_SORT");
		bs[2].sort(m.test500);
		ms[2].sort(m.test500);
		m.pokaz(bs[2], ms[2]);
		System.out.println(m.show(m.test500) + "\n");
	}

}
