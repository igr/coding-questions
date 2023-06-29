package tree_fun;

public class Node {
    final Node left;
    final Node right;
    final int value;

    public Node(Node left, Node right, int value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public static Node of(int value) {
        return new Node(null, null, value);
    }
    public static Node of(Node left, Node right, int value) {
        return new Node(left, right, value);
    }
}
