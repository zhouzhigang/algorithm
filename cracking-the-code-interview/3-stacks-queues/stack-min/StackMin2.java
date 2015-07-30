class Stack {
    int[] arr;
    int top = -1;
    int stackSize;

    public Stack(int stackSize) {
        this.stackSize = stackSize;
        arr = new int[stackSize];
    }

    public boolean push(int val) {
        if (top + 1 < stackSize) {
            top++;
            arr[top] = val;
            return true;
        }
        return false;
    }

    public Integer pop() {
        if (top > -1) {
            int val = arr[top];
            top--;
            return val;
        }
        return null;
    }

    public Integer peek() {
        if (top > -1) {
            return arr[top];
        }
        return null;
    }
}

public class StackMin2 {
    int[] arr;
    int top = -1;
    int stackSize;
    Stack minStack;

    public StackMin2(int stackSize) {
        this.stackSize = stackSize;
        arr = new int[stackSize];
        minStack = new Stack(stackSize);
    }
    
    public boolean push(int val) {
        if (top + 1 < stackSize) {
            Integer min = min();
            if (val <= min) {
                minStack.push(val);
            }
            top++;
            arr[top] = val;
            return true;
        }
        return false;
    }

    public Integer pop() {
        if (top > -1) {
            int val = arr[top];
            Integer min = min();
            if (min == val) {
                minStack.pop();
            }
            top--;
            return val;
        }
        return null;
    }

    public int min() {
        Integer min = minStack.peek();
        return min != null ? min : Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        StackMin2 stack = new StackMin2(6);
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
