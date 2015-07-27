import java.util.Map;
import java.util.HashMap;

class Node {
    Node next;
    int data;
    Node(int data) {
        this.data = data;
    }
}
public class RemoveDuplicateNodes {
    public void deleteDups(Node n) {
        if (n == null) return;
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        Node p = n;
        Node q = p.next;
        map.put(p.data, true);
        while (q != null) {
            if (map.get(q.data) != null) {
                p.next = q.next;
                q = p.next;
            } else {
                map.put(q.data, true);
                // move next
                p = q;
                q = q.next;
            }
        }
                
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
        RemoveDuplicateNodes sol = new RemoveDuplicateNodes();
        int[][] nums = {
            {}, // empty list
            {1}, // one element
            {1, 1}, // one element with duplicate
            {1, 2, 3, 2, 4},
        };
        int count = nums.length;
        for (int i = 0; i < count; i++) {
            Node n = createLinkedList(nums[i]);
            System.out.println("==== Before Remove Duplicates ====");
            printLinkedList(n);
            sol.deleteDups(n);
            System.out.println("==== After Remove Duplicates ====");
            printLinkedList(n);
        }
    }
}
