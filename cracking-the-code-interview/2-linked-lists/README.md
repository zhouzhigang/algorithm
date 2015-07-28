# Linked Lists

## Creating a Linked List

    class Node {
        Node next = null;
        int data;
        public Node(int d) { data = d; }
        void appendToTail(int d) {
            Node end = new Node(d);
            Node n = this;
            while (n.next != null) { n = n.next; }
            n.next = end;
        }
    }

## Deleting a Node from a Singly Linked List

    Node deleteNode(Node head, int d) {
        Node n = head;
        if (n.data == d) {
            return head.next; /* move head */
        }
        while (n.next != null) {
            if (n.next.data == d) {
                n.next = n.next.next;
                return head; /* head didn't change */
            }
            n = n.next;
        }
    }

## Exercises

|No.|Title|Solution|
|---|-----|--------|
|2.1|[Remove duplicates from an unsorted linked list](remove-duplicate-nodes)|[Java](remove-duplicate-nodes/RemoveDuplicateNodes.java)|
|2.2|[Find the nth to last element of a singly linked list](find-last-nth)|[Java](find-last-nth/FindLastNth.java)|
|2.3|[Delete a node in the middle of a single linked list](delete-pointer-node)|[Java](delete-pointer-node/DeletePointerNode.java)|
|2.4|[Sum of reverse order linked list](sum-of-linked-list)|[Java](sum-of-linked-list/SumOfLinkedList.java)|
|2.5|[Find the begininng node of the loop in a circular linked list](find-beginning-circular)|[Java](find-beginning-circular/FindBeginningCircular.java)|
