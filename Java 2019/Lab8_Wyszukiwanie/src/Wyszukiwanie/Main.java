package Wyszukiwanie;

public class Main {
	public static void main(String[] args) {
/*		GenerujTab t = new GenerujTab();
		t.wypelnienie();
		t.showTab();
		t.petla();
		t.sort();
		t.showTab();
		t.testlosowy();*/
		
		// ====
		test tt = new test();
		tt.wypelnienie();
		tt.showTab();

		System.out.println(tt.szukajLiniowo(10));
		System.out.println();
		tt.sort();
		tt.showTab();
		System.out.println();
		tt.binarySearch(10);

	}
}
