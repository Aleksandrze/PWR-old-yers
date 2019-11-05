package Wyszukiwanie;

import java.util.Random;

public class GenerujTab {

	int good1 = 0;
	int bead1 = 0;

	int pb=0;
	int pg=-1;
	
	static int[] tab = new int[1000];

	public void petla() {
		System.out.println();
		int t = 0;
		for (int i = 0; i < 100; i++) {
			t = liczbaRand();
			szukajLiniowo(t);
			binarySearch(t);
		}
	}

	public void testlosowy() {
		System.out.println(good1);
		System.out.println(bead1);
		System.out.println(pg);
		System.out.println(pg/good1);
		System.out.println(pb);
		System.out.println(pb/bead1);
		System.out.println(((pg/good1)+(pb/bead1))/100);
	}

	public void wypelnienie() {
		Random r = new Random();
		for (int i = 0; i < tab.length; i++) {
			tab[i] = r.nextInt(1000) + 1;
		}
	}

	public void showTab() {
		for (int i = 0; i < tab.length; i++) {
			System.out.print(tab[i] + ",");
		}
	}

	public void szukajLiniowo(int szukana) {
		for (int i = 0; i < tab.length; i++) {
			if (tab[i] == szukana) {
				good1++;
				pg+= tab[i];
			} else {
				bead1++;
				for(int j=0;j<i;j++) {
					pb= pb+tab[i]*(-1);
				}
			}
		}
	}

	public int liczbaRand() {
		Random r = new Random();
		int liczba = 0;
		for (int i = 0; i < tab.length; i++) {
			tab[i] = r.nextInt(100) + 1;
			liczba = tab[i];
		}
		return liczba;
	}

//---------------------HeapSort-------------------
	public void sort() {
		int n = tab.length;
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(n, i);
		}
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
