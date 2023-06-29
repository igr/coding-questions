package tree_fun;

public class FsqTreeFun {

    public static void main(String[] args) {
        Node node7 = Node.of(7);
        Node node4 = Node.of(4);
        Node node1 = Node.of(1);
        Node node3 = Node.of(3);

        Node node2 = Node.of(node7, node4, 2);
        Node node6 = Node.of(node1, node3, 6);

        Node node5 = Node.of(node2, node6, 5);
        Node node1_1 = Node.of(null, null, 1);

        Node node8 = Node.of(node5, node1_1, 8);

        System.out.println(calcMaxFunNoLimit(node8));   // 22
        System.out.println(calcMaxFun(node8));
    }

    private static int calcMaxFunNoLimit(Node root) {
        if (root == null) {
            return 0;
        }
        int leftMax = calcMaxFunNoLimit(root.left);
        int rightMax = calcMaxFunNoLimit(root.right);

        return Math.max(leftMax, rightMax) + root.value;
    }

    private static int calcMaxFun(Node root) {
        int[] max = calcMaxFunWithOrWithoutMe(root);
        return Math.max(max[0], max[1]);
    }

    private static int[] calcMaxFunWithOrWithoutMe(Node root) {
        if (root == null) {
            return new int[] {0, 0};
        }
        int[] leftMax = calcMaxFunWithOrWithoutMe(root.left);
        int[] rightMax = calcMaxFunWithOrWithoutMe(root.right);

        // with me, so ignore my direct nodes
        int withMe = root.value + leftMax[1] + rightMax[1];
        // without me, so take max of my direct nodes
        int withoutMe = Math.max(leftMax[0], leftMax[1]) + Math.max(rightMax[0], rightMax[1]);

        return new int[] {withMe, withoutMe};
    }
}
