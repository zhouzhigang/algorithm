public class ThreeStacks1 {
   Object arr[];
   /**
    * Size of one stack.
    * The total size of arr is 3*stackSize(use n/3 may not equal).
    */
   int stackSize;

   int[] topIdxs = {-1, -1, -1};

   public ThreeStacks1(int stackSize) {
       this.stackSize = stackSize;
       arr = new Object[3*stackSize];
   }

   public Object pop(int stackIdx) {
       if (topIdxs[stackIdx] > -1) { // check is empty
           int top = stackIdx * stackSize + topIdxs[stackIdx];
           topIdxs[stackIdx]--;
           return arr[top];
       }
       return null;
   }

    public boolean push(int stackIdx, Object val) {
        if (topIdxs[stackIdx] + 1 < stackSize) { // check is full
            topIdxs[stackIdx]++;
            int top = stackIdx * stackSize + topIdxs[stackIdx];
            arr[top] = val;
            return true;
        }
        return false;
    }

    public Object peek(int stackIdx) {
        if (topIdxs[stackIdx] > -1) {
            int top = stackIdx * stackSize + topIdxs[stackIdx];
            return arr[top];
        }
        return null;
    }

    public boolean isEmpty(int stackIdx) {
        return topIdxs[stackIdx] == -1;
    }

    public static void main(String[] args) {
        ThreeStacks1 stack = new ThreeStacks1(3);
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
