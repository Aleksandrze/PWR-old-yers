
public class Main {

	public static void main(String[] args) {
		ListaStudent list = new ListaStudent();

		list.wczytajPlik("student.txt");
		list.wyswietlStudentow();
		list.wyswietlSrednia();
		list.wpiszOcene("Misiuryna", "Debowski", 4.5);
		list.wyswietlSrednia();
		list.wyswietNieZalicz();
		list.zapiszStudentow("updateStudent.txt");
	}

}
