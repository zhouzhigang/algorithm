/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

/**
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode(0);
        ListNode curr = head;
        int sum = 0;
        while (l1 != null &&  l2 != null) {
            sum  = sum / 10 + l1.val + l2.val;
            curr.next = new ListNode(sum % 10);
            l1 = l1.next;
            l2 = l2.next;
            curr = curr.next;
        }
        ListNode rest = l1 != null ? l1 : l2;
        // no carray, link the rest node
        if (sum / 10 == 0) {
            curr.next = rest;
            return head.next;
        }
        // has carry, continue add
        while (rest != null) {
            sum  = sum / 10 + rest.val;
            curr.next = new ListNode(sum % 10);
            rest = rest.next;
            curr = curr.next;
        }
        // handle the last carry
        if (sum / 10 != 0) {
            curr.next = new ListNode(sum / 10);
        }
        return head.next;
    }

    /**
     * Create list by array.
     */
    public static ListNode createList(int[] arr) {
        if (arr.length == 0) { return null; }
        ListNode node = new ListNode(arr[0]);
        ListNode curr = node; // used to move next
        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        return node;
    }

    /**
     * Print list.
     */
    public static void printList(ListNode list) {
        while (list != null) {
            System.out.print(list.val + "->");
            list = list.next;
        }
        System.out.println("null");
    }

    /**
     * Test case.
     *  Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     *  Output: 7 -> 0 -> 8
     */
    public static void main(String[] args) {
        int[] arr1 = {4, 3, 5};
        int[] arr2 = {5, 6, 4};
        ListNode l1 = createList(arr1);
        ListNode l2 = createList(arr2);
        ListNode l3 = new AddTwoNumbers().addTwoNumbers(l1, l2);
        printList(l1);
        printList(l2);
        printList(l3);
    }
}
