package tree_to_list;

public class FacebookQuestion2 {

	/*
	Given tree:

	   |
	   5
	 /  \
	4    3
   / \  / \
   9  1 2  7
    \
	 8

	 |
	 -> 9 <-> 8 <-> 4 <-> 1 <-> 5 <-> 2 <-> 3 <-> 7 <-
	 -------------------------------------------------

	Make a double linked-list from a tree.
	Without creating a new structure.

	*/

	// given class
	public static class Node {
		public Node(final int value, final Node left, final Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
		public int value;
		public Node left;
		public Node right;
	}

	public static void main(final String[] args) {
		final var node8 = new Node(8, null, null);
		final var node9 = new Node(9, null, node8);
		final var node1 = new Node(1, null, null);
		final var node4 = new Node(4, node9, node1);

		final var node2 = new Node(2, null, null);
		final var node7 = new Node(7, null, null);
		final var node3 = new Node(3, node2, node7);

		final var node5 = new Node(5, node4, node3);

		walk(node5);
	}

	private static void walk(final Node node) {
		if (node.left != null) {
			walk(node.left);
		}

		System.out.println(node.value);
		// create new list by adding these values
		// TODO do the same without allocating new data


		if (node.right != null) {
			walk(node.right);
		}
	}
}
