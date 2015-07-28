class Node {
    Node next;
    int data;
    Node(int data) {
        this.data = data;
    }
}
public class SumOfLinkedList {
    public Node addList(Node l1, Node l2) {
        Node head = new Node(0);
        Node l3 = head;
        int sum = 0;
        while (l1 != null && l2 != null) {
            sum = l1.data + l2.data + sum / 10;
            l3.next = new Node(sum % 10);
            l1 = l1.next;
            l2 = l2.next;
            l3 = l3.next;
        }
        Node rest = l1 != null ? l1 : l2;
        while (rest != null) {
            sum = rest.data + sum / 10;
            l3.next = new Node(sum % 10);
            rest = rest.next;
            l3 = l3.next;
        }
        if (sum / 10 != 0) {
            l3.next = new Node(1);
        }
        return head.next;
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
        SumOfLinkedList sol = new SumOfLinkedList();
        int[][] arrs = {
            {1},{},
            {1}, {9},
            {1}, {2, 3},
            {1, 2, 3}, {5, 6, 7},
        };
        int count = arrs.length / 2;
        for (int i = 0; i < count; i++) {
            System.out.println("==== Test ====");
            Node l1 = createLinkedList(arrs[2*i]);
            Node l2 = createLinkedList(arrs[2*i+1]);
            Node l3 = sol.addList(l1, l2);
            printLinkedList(l1);
            printLinkedList(l2);
            printLinkedList(l3);
        }
    }
}
