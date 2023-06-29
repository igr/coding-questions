package tree_height;

public class FsqTreeHeight {

    public static void main(String[] args) {
        Node node7 = new Node(null, null);
        Node node4 = new Node(null, null);
        Node node1 = new Node(null, null);
        Node node3 = new Node(null, null);

        Node node2 = new Node(node7, node4);
        Node node6 = new Node(node1, node3);

        Node node5 = new Node(node2, node6);
        Node node1_1 = new Node(null, null);

        Node node8 = new Node(node5, node1_1);

        System.out.println(calcTreeHeight(node8));  // 4
    }

    private static int calcTreeHeight(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = calcTreeHeight(root.left);
        int rightHeight = calcTreeHeight(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
