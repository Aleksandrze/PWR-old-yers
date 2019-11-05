package Struktury;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Heap heap = new Heap();

		Scanner read = new Scanner(System.in);
		String[] s = new String[0];
		System.out.println("Dodaj elementy do kopcu:");
		if (read.hasNext())
			s = read.nextLine().split(" ");
		for (int i = 0; i < s.length; i++)
			heap.enqueue(Integer.parseInt(s[i]));
		System.out.println("\n" + heap);
		System.out.println("Zamien element:");
		if (read.hasNext())
			s = read.nextLine().split(" ");
		heap.changePriority(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
		System.out.println("\n" + heap);
		System.out.println("Jakie elementy usunac?:");
		if (read.hasNext())
			s = read.nextLine().split(" ");
		for (int i = 0; i < s.length; i++)
			System.out.print(heap.remove(Integer.parseInt(s[i])) + " ");
		System.out.println("\n" + heap);
		heap.dequeue();
		heap.dequeue();
		heap.dequeue();
		System.out.println("\n" + heap);
		read.close();
	}
}
