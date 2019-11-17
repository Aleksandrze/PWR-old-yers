
public class Main_Test {
	public static void main(String []args){
		Dysk dysk = new Dysk();
		System.out.println("FCFS : " + dysk.FCFS());
		System.out.println("SSTF : " + dysk.SSTF());
		System.out.println("CSCAN: " + dysk.CSCAN());
		System.out.println("SCAN : " + dysk.SCAN());
	}
}
