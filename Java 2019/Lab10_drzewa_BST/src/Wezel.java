public class Wezel {
	int value;
	Wezel left;
	Wezel right;

	public Wezel(int n) {
		value = n;
		left = right = null;

	}

	public Wezel(int n, Wezel l, Wezel r) {
		value = n;
		left = l;
		right = r;
	}

	public String inOrder() {
		String b = "";
		if (left != null) {
			b += left.inOrder();
		}
		b += value + ", ";
		if (right != null) {
			b += right.inOrder();
		}
		return b;
	}

	public String preOrder() {
		String b = "";
		b += value + ", ";
		if (left != null) {
			b += left.preOrder();
		}
		if (right != null) {
			b += right.preOrder();
		}
		return b;
	}

	public String postOrder() {
		String b = "";
		if (left != null) {
			b += left.postOrder();
		}
		if (right != null) {
			b += right.postOrder();
		}
		b += value + ", ";
		return b;
	}

}
