package tree_deep_copy;

import java.util.HashMap;
import java.util.Map;

public class MicrosoftSolution {

	public static class Node {
		public Node(final int data, final Node next, final Node random) {
			this.data = data;
			this.next = next;
			this.random = random;
		}
		public int data;
		public Node next;
		public Node random;
	}

	public static void main(final String [] args) {
		test1();
		test2();
	}

	private static final Map<Node, Node> cache = new HashMap<Node, Node>();

	public static Node deepCopy(final Node node) {
		final Node cachedNode = cache.get(node);
		if (cachedNode != null) {
			return cachedNode;
		}

		// random
		Node random = node.random;
		if (random != null) {
			random = deepCopy(random);
		}

		// next
		Node next = node.next;
		if (next != null) {
			next = deepCopy(next);
		}

		final Node resultNode = new Node(node.data, next, random);

		cache.put(node, resultNode);
		return resultNode;
	}


	public static void test1() {
		final Node node = new Node(1, null, null);
		final Node result = deepCopy(node);

		System.out.println(result != null);
		System.out.println(result.data == 1);
		System.out.println(result.next == null);
	}

	public static void test2() {
		final Node node2 = new Node(2, null, null);
		final Node node = new Node(1, null, node2);

		final Node result = deepCopy(node);
		final Node result2 = result.random;

		System.out.println(result.data == node.data);
		System.out.println(result.next == null);

		System.out.println(result2.data == result2.data);
		System.out.println(result2.random == null);
	}

	public static void test_recurction() {
		final Node node2 = new Node(2, null, null);
		final Node node = new Node(1, null, node2);
		node2.random = node;


		final Node result = deepCopy(node);
		final Node result2 = result.random;

		System.out.println(result.data == node.data);
		System.out.println(result.next == null);
		System.out.println(result.random == result2);

		System.out.println(result2.data == result2.data);
		System.out.println(result2.next == null);
		System.out.println(result2.random == result);
	}

}
