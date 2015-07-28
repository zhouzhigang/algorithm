class Node {
    Node next;
    int data;
    Node(int data) {
        this.data = data;
    }
}
public class FindBeginningCircular {
    public Node findBeginning(Node head) {
        if (head == null || head.next == null) { return null; }

        Node p = head;
        Node q = head;

        // find the meeting point
        do {
            p = p.next;
            q = q.next.next;
        } while (q.next != null && p != q);

        if (q.next == null) { return null; } // no loop

        q = head; // move to head
        // find the beginning of loop
        while (p != q) {
            p = p.next;
            q = q.next;
        }

        return p;
    }

    public static Node createCircularList(int[] arr, int loopBegin) {
        Node head = new Node(0);
        int count = arr.length;
        Node curr = head;
        Node circular = null;
        for (int i = 0; i < count; i++) {
            if (i != loopBegin) {
                curr.next = new Node(arr[i]);
            } else {
                circular = new Node(arr[i]);
                curr.next = circular;
            }
            curr = curr.next;
        }
        curr.next = circular; // link to the circular begin node
        return head.next;
    }

    public static void main(String[] args) {
        FindBeginningCircular sol = new FindBeginningCircular();

        int[] arr = {1, 2, 3, 4, 5};
        int count = arr.length;
        for (int i = 0; i <= count; i++) {
            System.out.println("==== Begin of Circular at position: " + i + " ====");
            Node head = createCircularList(arr, i);
            Node cirBegin = sol.findBeginning(head);
            if (cirBegin != null) {
                System.out.println(cirBegin.data);
            } else {
                System.out.println("==== Not a circular list ====");
            }
        }
    }
}
