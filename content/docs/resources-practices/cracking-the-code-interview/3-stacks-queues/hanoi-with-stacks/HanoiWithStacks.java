import java.util.Stack;

public class HanoiWithStacks {

    public void hanoiRecursive(int n, char a, char b, char c) {
        if (n == 1) {
            System.out.println("Move " + n + " from " + a + " to " + c);
        } else {
            hanoiRecursive(n-1, a, c, b);
            System.out.println("Move " + n + " from " + a + " to " + c);
            hanoiRecursive(n-1, b, a, c);
        }
    }

    public void hanoiRecursive(int i, int n, char a, char b, char c) {
        if (n == i) { // move a single disk
            System.out.println("Move " + n + " from " + a + " to " + c);
        } else {
            hanoiRecursive(1, n-1, a, c, b); // left
            hanoiRecursive(n, n, a, b, c); // pure recursive, root
            hanoiRecursive(1, n-1, b, a, c); // right
        }
    }

    public void hanoiWithStack(int i, int n, int a, int b, int c) {
        Stack<Integer[]> stack = new Stack<Integer[]>();
        Integer[] arr = {i, n, a, b, c}; // maybe use a structure/class to save these parameters is better
        stack.push(arr);
        Integer[] pre;
        int k = n;
        while (!stack.isEmpty()) {
            pre = stack.pop();
            if (pre[0] != pre[1]) {
                Integer[] right = {1, pre[1]-1, pre[2], pre[4], pre[3]};
                stack.push(right);
                Integer[] root = {pre[1], pre[1], pre[2], pre[3], pre[4]};
                stack.push(root);
                Integer[] left = {1, pre[1]-1, pre[2], pre[4], pre[3]};
                stack.push(left);
            } else {
                System.out.println("Move " + pre[1] + " from " + pre[2] + " to " + pre[4]);
            }
        }
    }

    public static void main(String[] args) {
        HanoiWithStacks hanoi = new HanoiWithStacks();

        hanoi.hanoiRecursive(1, 3, 'A', 'B', 'C');
        hanoi.hanoiWithStack(1, 3, 'A', 'B', 'C');
    }
}
