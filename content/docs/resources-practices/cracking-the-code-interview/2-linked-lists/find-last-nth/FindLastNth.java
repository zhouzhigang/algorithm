
class Node {
    Node next;
    int data;
    Node(int data) {
        this.data = data;
    }
}
public class FindLastNth {
    public Node nthToLast(Node head, int k) {
        Node p = head;
        Node q = head;
        for (int i = 0; i < k; i++) {
            if (q == null) return null; // k > length
            q = q.next;
        }
        while (q != null) {
            p = p.next;
            q = q.next;
        }
        return p;
    }


    public static Node createLinkedList(int[] arr) {
        Node head = new Node(0);
        Node p = head;
        for (int i = 0; i < arr.length; i++) {
            p.next = new Node(arr[i]);
            p = p.next;
        }
        return head.next;
    }

    public static void printLinkedList(Node n) {
        Node p = n;
        while (p != null) {
            System.out.print(p.data + "->");
            p = p.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        FindLastNth sol = new FindLastNth();

        int[][] nums = {
            {}, // empty list
            {1}, // length = 1
            {1, 2, 3, 4, 5},
        };
        int[] nths = {
            0, // emtpty list
            2, // k > length
            4
        };
        int count = nums.length;
        for (int i = 0; i < count; i++) {
            Node n = createLinkedList(nums[i]);
            System.out.println("==== Test List ====");
            printLinkedList(n);
            Node lastNth = sol.nthToLast(n, nths[i]);
            System.out.println("==== Last Nth ====");
            printLinkedList(lastNth);
        }

    }
}
             
