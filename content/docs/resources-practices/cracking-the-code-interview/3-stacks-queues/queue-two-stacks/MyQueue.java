import java.util.Stack;

public class MyQueue<T> {
    Stack<T> front;
    Stack<T> tail;
    int capcity;

    public MyQueue() {
        front = new Stack<T>();
        tail = new Stack<T>();
    }

    public void add(T val) {
        tail.push(val);
    }

    public T remove() {
        if (front.size() == 0) {
            while (tail.size() != 0) {
                front.push(tail.pop());
            }
        }
        return front.pop();
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        int i = 0;
        int j = 0;
        int val;
        System.out.println("==== Queue Add Test ====");
        for (i = 0; i < 5; i++) {
            queue.add(i);
            System.out.print(i + "->");
        }
        System.out.println("\n==== Queue Remove Test ====");
        for (j = 0; j < 3; j++) {
            val = queue.remove();
            System.out.print(val + "<-");
        }
        System.out.println("\n==== Queue Add Test ====");
        for (i = 6; i < 8; i++) {
            queue.add(i);
            System.out.print(i + "->");
        }
        System.out.println("\n==== Queue Remove Test ====");
        for (j = 0; j < 3; j++) {
            val = queue.remove();
            System.out.print(val + "<-");
        }
        System.out.println();
    }
}
