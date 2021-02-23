import java.util.Stack;

public class SortStack {

    public Stack<Integer> sort(Stack<Integer> s) {
        if (s == null || s.isEmpty()) return null;
        int temp;
        Stack<Integer> t = new Stack<Integer>();
        while (!s.isEmpty()) {
            temp = s.pop();
            while (!t.isEmpty() && temp < t.peek()) {
                // push back until find tmp position
                s.push(t.pop());
            }
            // insert temp
            t.push(temp);
        }
        return t;
    }

    public static void main(String[] args) {
        SortStack sol = new SortStack();
        Stack<Integer> stack = new Stack<Integer>();
        int[] nums = {4, 3, 5, 2, 1};
        int count = nums.length;
        int val;
        for (int i = 0; i < count; i++) {
            stack.push(nums[i]);
            System.out.print(nums[i] + "->");
        }
        Stack<Integer> t = sol.sort(stack);
        System.out.println();
        while (!t.isEmpty()){
            val = t.pop();
            System.out.print(val + "<-");
        }
        System.out.println();
    }
}
