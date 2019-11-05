public class Huffman {

	public static void print(Node korzeń, String s) {
		if (korzeń.left == null && korzeń.right == null ) {
			System.out.println(korzeń.alfabet + " --> " + s);
			return;
		}
		print(korzeń.left, s + "0");
		print(korzeń.right, s + "1");
	}
}
