class Node {
    Object val;
    int preIdx;
    Node(Object val, int preIdx) {
        this.val = val;
        this.preIdx = preIdx;
    }
}
public class ThreeStacks2 {
    Node[] arr;
    int totalSize;
    int count = -1;
    int[] topIdxs = {-1, -1, -1};

    public ThreeStacks2(int totalSize) {
        this.totalSize = totalSize;
        arr = new Node[totalSize];
    }

    public Object pop(int stackIdx) {
        if (topIdxs[stackIdx] > -1) {
            int top = topIdxs[stackIdx];
            topIdxs[stackIdx] = arr[top].preIdx;
            // how to handle these space
            return arr[top].val;
        }
        return null;
    }

    public boolean push(int stackIdx, Object val) {
        if (count + 1 < totalSize) {
            int top = topIdxs[stackIdx]; // previous top index
            count++;
            topIdxs[stackIdx] = count; // save current top
            Node node = new Node(val, top);
            arr[count] = node;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ThreeStacks2 stack = new ThreeStacks2(9);
        int[][] nums = {
            {11, 12, 13},
            {21, 22, 23, 24},
            {31, 32, 33}
        };
        int count = nums.length;
        boolean res;
        Object val;
        System.out.println("==== Push Test ====");
        for (int i = 0; i < count; i++) {
            int len = nums[i].length;
            for (int j = 0; j < len; j++) {
                res = stack.push(i, nums[i][j]);
                if (res) {
                    System.out.print(nums[i][j] + "->");
                } else {
                    System.out.print("Stack Overflow");
                }
            }
            System.out.println();
        }
        System.out.println("==== Pop Test ====");
        for (int i = 0; i < count; i++) {
            while ((val = stack.pop(i)) != null) {
                System.out.print(val + "<-");
            }
            System.out.println();
        }
    }
}
