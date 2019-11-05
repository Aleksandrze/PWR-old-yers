
public class TreeRandB {
	final static boolean RED = true;
	final static boolean BLACK = false;

	Node root;

	public TreeRandB() {
		root = null;
	}

	public void insert(int v) {
		Node n = new Node(v);
		root = insert(root, n);
		buildTree(root, n);
	}

	private Node insert(Node r, Node n) {
		if (r == null)
			return n;
		if (n.value < r.value) {
			r.left = insert(r.left, n);
			r.left.parent = r;
		} else if (n.value > r.value) {
			r.right = insert(r.right, n);
			r.right.parent = r;
		}
		return r;
	}

	public void buildTree(Node r, Node n) {
		Node parent = null;
		Node grand_parent = null;
		while ((n != r) && (n.color != BLACK) && (n.parent.color == RED)) {
			parent = n.parent;
			grand_parent = n.parent.parent;
			if (parent == grand_parent.left) {
				Node uncle = grand_parent.right;
				if (uncle != null && uncle.color == RED) {
					grand_parent.color = RED;
					parent.color = BLACK;
					uncle.color = BLACK;
					n = grand_parent;
				} else {
					if (n == parent.right) {
						rotateLeft(parent);
						n = parent;
						parent = n.parent;
					}
					rotateRight(grand_parent);
					boolean tmp = parent.color;
					parent.color = grand_parent.color;
					grand_parent.color = tmp;
					n = parent;
				}
			} else {
				Node uncle = grand_parent.left;
				if ((uncle != null) && (uncle.color == RED)) {
					grand_parent.color = RED;
					parent.color = BLACK;
					uncle.color = BLACK;
					n = grand_parent;
				} else {
					if (n == parent.left) {
						rotateRight(parent);
						n = parent;
						parent = n.parent;
					}
					rotateLeft(grand_parent);
					boolean tmp = parent.color;
					parent.color = grand_parent.color;
					grand_parent.color = tmp;
					n = parent;
				}
			}
		}
		nodes(root);
		root.color = BLACK;
	}

	public void rotateLeft(Node n) {
		Node n_right = n.right;

		n.right = n_right.left;

		if (n.right != null)
			n.right.parent = n;

		n_right.parent = n.parent;

		if (n.parent == null)
			root = n_right;
		else if (n == n.parent.left)
			n.parent.left = n_right;
		else
			n.parent.right = n_right;

		n_right.left = n;
		n.parent = n_right;
	}

	public void rotateRight(Node n) {
		Node n_left = n.left;

		n.left = n_left.right;

		if (n.left != null)
			n.left.parent = n;

		n_left.parent = n.parent;

		if (n.parent == null)
			root = n_left;
		else if (n == n.parent.left)
			n.parent.left = n_left;
		else
			n.parent.right = n_left;

		n_left.right = n;
		n.parent = n_left;
	}

	@SuppressWarnings("unused")
	private void nodes(Node r) {
		if (r == null)
			return;

		r.nodes = numberOfNodes(r);
		r.lnodes = numberOfNodes(r.left);
		r.rnodes = numberOfNodes(r.right);

		nodes(r.left);
		nodes(r.right);
	}

	public int numberOfNodes() {
		return numberOfNodes(root);
	}

	public int numberOfNodes(Node r) {
		if (r == null)
			return 0;
		else {
			int lnodes = numberOfNodes(r.left);
			int rnodes = numberOfNodes(r.right);

			return (lnodes + rnodes + 1);
		}
	}

	public int height() {
		return findHeight(root);
	}

	public int findHeight(Node n) {
		if (n == null || (n.left == null && n.right == null))
			return 0;
		return Math.max(findHeight(n.left), findHeight(n.right)) + 1;
	}

	public Node search(int v) {
		return search(root, v);
	}

	private Node search(Node r, int v) {
		if (r == null || r.value == v)
			return r;
		if (r.value > v)
			return search(r.left, v);
		return search(r.right, v);
	}

	public void searchNode(int v) {
		if (search(v) != null)
			System.out.println("Wezel zostal znaleziony!");
		else
			System.out.println("Nie ma wezla o podanym kluczu");
	}

	public void levelOrder() {
		System.out.println("Poziomami:");
		int h = height();
		for (int i = 0; i <= h; i++) {
			printGivenLevel(root, i);
			System.out.println();
		}
	}

	private void printGivenLevel(Node n, int level) {
		if (n == null)
			return;
		if (level == 0) {
			if (n.color == RED) {
				System.out.print(n.value + "(R)  ");
			} else {
				System.out.print(n.value + "(B)  ");
			}
		} else {
			printGivenLevel(n.left, level - 1);
			printGivenLevel(n.right, level - 1);
		}
	}

	public void inOrderWalk() {
		inOrderWalk(this.root);
	}

	private void inOrderWalk(Node localRoot) {
		if (localRoot != null) {
			inOrderWalk(localRoot.left);
			System.out.print(localRoot.value + localRoot.getColor() + " ");
			inOrderWalk(localRoot.right);
		}
	}

	public void preOrderWalk() {
		preOrderWalk(this.root);
	}

	private void preOrderWalk(Node localRoot) {
		if (localRoot != null) {
			System.out.print(localRoot.value + localRoot.getColor() + " ");
			preOrderWalk(localRoot.left);
			preOrderWalk(localRoot.right);
		}
	}

	public void postOrderWalk() {
		postOrderWalk(this.root);
	}

	private void postOrderWalk(Node localRoot) {
		if (localRoot != null) {
			postOrderWalk(localRoot.left);
			postOrderWalk(localRoot.right);
			System.out.print(localRoot.value + localRoot.getColor() + " ");
		}
	}

	// ==========================ZmadyfikowaC==================================
	public void printNodes() {
		System.out.println("Wezly drzewa: " + root.nodes);
		System.out.println("Wezly lewego poddrzewa: " + root.lnodes);
		System.out.println("Wezly prawego poddrzewa: " + root.rnodes);
	}

	public void printNodes(Node x) {
		if (x == null) {
			System.out.println("Nie ma drzewa o padanym korzeniu");
			return;
		}
		System.out.println("Wezly drzewa " + x.value + ": " + x.nodes);
		System.out.println("Wezly lewego poddrzewa " + x.value + ": " + x.lnodes);
		System.out.println("Wezly prawego poddrzewa " + x.value + ": " + x.rnodes);
	}

	public void printHeights() {
		System.out.println("Wysokosc drzewa: " + height());
		System.out.println("Wysokosc lewego poddrzewa: " + findHeight(root.left));
		System.out.println("Wysokosc prawego poddrzewa: " + findHeight(root.right));
	}

	public void printHeights(Node x) {
		if (x == null) {
			System.out.println("Nie ma drzewa o padanym korzeniu");
			return;
		}
		System.out.println("Wysokosc drzewa " + x.value + ": " + findHeight(x));
		System.out.println("Wysokosc lewego poddrzewa " + x.value + ": " + findHeight(x.left));
		System.out.println("Wysokosc prawego poddrzewa " + x.value + ": " + findHeight(x.right));
	}
}