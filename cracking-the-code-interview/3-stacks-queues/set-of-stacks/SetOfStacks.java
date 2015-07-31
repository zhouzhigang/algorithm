import java.util.ArrayList;

class Stack {
    int[] arr;
    int top = -1;
    int stackSize;

    public Stack(int stackSize) {
        this.stackSize = stackSize;
        arr = new int[stackSize];
    }

    public void push(int val) {
        top++;
        arr[top] = val;
    }

    public int pop() {
        int val = arr[top];
        top--;
        return val;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top + 1 == stackSize;
    }

    public int shiftBottom() {
        int bottom = arr[0];
        for (int i = 1; i < top; i++) {
            arr[i-1] = arr[i];
        }
        return bottom;
    }
}
public class SetOfStacks {
    ArrayList<Stack> stacks = new ArrayList<Stack>();
    int top = -1;
    int stackSize;
    int i = 0;

    public SetOfStacks(int stackSize) {
        this.stackSize = stackSize;
        Stack stack = new Stack(stackSize);
        stacks.add(stack);
    }

    private Stack getLastStack() {
        if (stacks.size() > 0) {
            return stacks.get(stacks.size() - 1);
        }
        return null;
    }

    public void push(int val) {
        Stack last = getLastStack();
        if(last.isFull()) {
            Stack stack = new Stack(stackSize);
            stack.push(val);
            stacks.add(stack);
        } else {
            last.push(val);
        }
    }

    public Integer pop() {
        Stack last = getLastStack();
        if (last == null || last.isEmpty()) return null;
        int val = last.pop();
        if (last.isEmpty()) {
            stacks.remove(stacks.size() - 1);
        }
        return val;
    }

    public Integer popAt(int index) {
        if (index < 0 || index > stacks.size() - 1) return null;
        Stack stack = stacks.get(index);
        int val = stack.pop();
        for(int i = index + 1; i < stacks.size(); i++) {
            stack = stacks.get(i-1);
            Stack nextStack = stacks.get(i);
            int bottom = nextStack.shiftBottom();
            stack.push(bottom);
        }
        return val;
    }

    public static void main(String[] args) {
        SetOfStacks stacks = new SetOfStacks(5);
        System.out.println("==== Push Test ====");
        for (int i = 0; i < 15; i++) {
            stacks.push(i);
            System.out.print(i + "->");
        }
        System.out.println("null");
        System.out.println("==== Pop Test ====");
        for (int i = 0; i < 5; i++) {
            int val = stacks.pop();
            System.out.print(val + "<-");
        }
        System.out.println();
        System.out.println("==== PopAt Test ====");
        for (int i = 0; i < 5; i++) {
            int val = stacks.popAt(0);
            System.out.print(val + "<-");
        }
        System.out.println();
    }
}
