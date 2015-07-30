class Node {
    int val;
    int min;
    Node(int val, int min) {
        this.val = val;
        this.min = min;
    }
}

public class StackMin1 {
    Node[] arr;
    int top = -1;
    int stackSize;

    public StackMin1(int stackSize) {
        this.stackSize = stackSize;
        arr = new Node[stackSize];
    }

    public boolean push(int val) {
        if (top + 1 < stackSize) {
            int min = min();
            top++;
            Node node = new Node(val, val < min ? val : min);
            arr[top] = node;
            return true;
        }
        return false;
    }

    public Integer pop() {
        if (top > -1) {
            int val = arr[top].val;
            top--;
            return val;
        }
        return null;
    }

    public int min() {
        if (top > -1) {
            return arr[top].min;
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        StackMin1 stack = new StackMin1(6);
        int[] arr = {2, 1, 3, 1, 4, 5};
        int count = arr.length;
        boolean res;
        Integer val;
        System.out.println("==== Push Test ====");
        for (int i = 0; i < count; i++) {
            res = stack.push(arr[i]);
            if (res) {
                System.out.print(arr[i] + "(min: " + stack.min() + ")->");
            } else {
                System.out.print("Stack Overflow");
            }
        }
        System.out.println("\n==== Pop and Min Test ====");
        while ((val = stack.pop()) != null) {
            System.out.println("pop: " + val + ", min: " + stack.min());
        }

    }
}
