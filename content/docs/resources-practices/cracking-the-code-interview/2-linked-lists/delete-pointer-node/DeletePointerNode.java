class Node {
    Node next;
    int data;
    Node(int data) {
        this.data = data;
    }
}
public class DeletePointerNode {
    public boolean deleteNode(Node curr) {
        if (curr == null || curr.next == null) return false;
        Node q = curr.next;
        curr.data = q.data; // copy data(simulate previous)
        curr.next = q.next; // delete node
        return true;
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
        DeletePointerNode sol = new DeletePointerNode();

        int[] nums = {1, 2, 3, 4, 5};
        boolean[] results = {true, true, true, true, false};
        int count = nums.length;
        int failed = 0;
        boolean result;
        for (int i = 0; i < count; i++) {
            Node head = createLinkedList(nums);
            Node curr = head;
            int j = 0;
            // move curr to differnt position(from head to tail)
            while (j < i) {
                curr = curr.next;
                j++;
            }
            result = sol.deleteNode(curr);
            System.out.println("==== Delete at " + i + "th Node: " + result + " ====");
            printLinkedList(head);
            if (result != results[i]) {
                failed++;
            }
        }
        System.out.println("Test " + count + " cases: " + (count-failed) + " success, " + failed + " failed.");
    }
}

