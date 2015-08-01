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

    public static void main(String[] args) {
        HanoiWithStacks hanoi = new HanoiWithStacks();

        hanoi.hanoiRecursive(3, 'A', 'B', 'C');
    }
}
