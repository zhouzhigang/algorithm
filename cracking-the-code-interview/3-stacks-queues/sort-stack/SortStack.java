import java.util.Stack;

public class SortStack {

    public Stack<Integer> sort(Stack<Integer> s) {
        if (s == null || s.isEmpty()) return null;
        int temp = s.pop();
        Stack<Integer> t = new Stack<Integer>();
        t.push(temp);
        while (!s.isEmpty()) {
            temp = s.pop();
            if (temp < t.peek()) {
                // push back
                while (!t.isEmpty()) {
                    s.push(t.pop());
                }
            }
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
