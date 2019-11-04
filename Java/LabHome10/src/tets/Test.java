package tets;

import java.util.Scanner;

public class Test {
	int num = 0;
	public String a[] = new String[num];

	public void scan() {
		Scanner s = new Scanner(System.in);
		System.out.println("Ilosc elementow");
		int num = s.nextInt();
		String a[] = new String[num];
		System.out.println("Text:");
		for (int i = 0; i < num; i++) {
			a[i] = s.next();
			if (a[i].equals("kot")) {
				System.out.println("Stop");
				for (int j = num - 1; j >= 0; j--) {
					if (a[j] == null) {
						System.out.print("");
					} else {
						System.out.print(a[j] + " ");

					}
				}
			}
		}
		System.out.println("Elementy w drugej kol.");
		for (int i = num - 1; i >= 0; i--) {
			System.out.print(a[i] + " ");
		}
	}

}
