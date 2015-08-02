class Node {
    int val;
    Node left;
    Node right;
    Node(int val) {
        this.val = val;
    }
    void addChild(Node left, Node right) {
        this.left = left;
        this.right = right;
    }
}

public class IsBalancedTree {

    public boolean isBalanced(Node tree) {
        return getMaxDepth(tree) - getMinDepth(tree) <= 1;
    }

    public int getMaxDepth(Node tree) {
        int left = 0;
        int right = 0;
        if (tree != null) {
            left = getMaxDepth(tree.left);
            right = getMaxDepth(tree.right);
            return left > right ? left + 1 : right + 1;
        }
        return 0;
    }

    public int getMinDepth(Node tree) {
        int left = 0;
        int right = 0;
        if (tree != null) {
            left = getMaxDepth(tree.left);
            right = getMaxDepth(tree.right);
            return left < right ? left + 1 : right + 1;
        }
        return 0;
    }

    public static void printPreOrder(Node tree) {
        if (tree != null) {
            System.out.print(tree.val + " ");
            printPreOrder(tree.left);
            printPreOrder(tree.right);
        }
    }

    public static void main(String[] args) {
        IsBalancedTree sol = new IsBalancedTree();
        
        Node root = new Node(1);
        Node left = new Node(2);
        Node right = new Node (3);
        root.addChild(left, right);
        left.addChild(new Node(4), new Node(5));
        // left.left.addChild(new Node(6), new Node(7))

        printPreOrder(root);
        System.out.println();

        System.out.println("max depth: " + sol.getMaxDepth(root));
        System.out.println("min depth: " + sol.getMinDepth(root));
        System.out.println("is balanced: " + sol.isBalanced(root));
    }
}
