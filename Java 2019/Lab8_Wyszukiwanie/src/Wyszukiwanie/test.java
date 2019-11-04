package Wyszukiwanie;

import java.util.Random;

public class test {

	static int[] tab = new int[20];

	public void wypelnienie() {
		Random r = new Random();
		for (int i = 0; i < tab.length; i++) {
			tab[i] = r.nextInt(10) + 1;
		}

	}

	public void showTab() {
		for (int i = 0; i < tab.length; i++) {
			System.out.print(tab[i] + ",");
		}
	}

	public int szukajLiniowo(int szukana) {
		for (int i = 0; i < tab.length; i++) {
			if (tab[i] == szukana) {
				System.out.println();
				return i;
			}
		}
		System.out.println();
		return -1;
	}

	public int liczbaRand() {
		Random r = new Random();
		int liczba = 0;
		for (int i = 0; i < tab.length; i++) {
			tab[i] = r.nextInt(99) + 1;
			liczba = tab[i];
		}
		return liczba;
	}

//---------------------HeapSort-------------------
	public void sort() {
		int n = tab.length;

		for (int i = n / 2 - 1; i >= 0; i--)
			heapify(n, i);

		for (int i = n - 1; i >= 0; i--) {

			int temp = tab[0];
			tab[0] = tab[i];
			tab[i] = temp;

			heapify(i, 0);
		}
	}

	void heapify(int n, int i) {
		int largest = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;

		if (l < n && tab[l] > tab[largest])
			largest = l;

		if (r < n && tab[r] > tab[largest])
			largest = r;

		if (largest != i) {
			int swap = tab[i];
			tab[i] = tab[largest];
			tab[largest] = swap;

			heapify(n, largest);
		}
	}
	// -------------------------binarySearch--------------------

	public int binarySearch(int key) {
		int low = 0;
		int high = tab.length - 1;
		int middle = (low + high + 1) / 2;
		int location = -1;

		do {
			System.out.print(remainingElements(low, high));

			for (int i = 0; i < middle; i++) {
				System.out.print(" ");
			}
			System.out.println(" * ");

			if (key == tab[middle]) {
				location = middle;
			} else if (key < tab[middle]) {
				high = middle - 1;
			} else {
				low = middle + 1;
			}

			middle = (low + high + 1) / 2;
		} while ((low <= high) && (location == -1));
		return location;
	}

	private String remainingElements(int low, int high) {
		StringBuilder temporary = new StringBuilder();

		for (int i = 0; i < low; i++) {
			temporary.append(" ");
		}

		for (int i = low; i <= high; i++) {
			temporary.append(tab[i] + " ");
		}
		return String.format("%s%n", temporary);
	}

}
