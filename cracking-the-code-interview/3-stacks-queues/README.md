# Statcks and Queues

## Implementing as Stack

    class Stack {
        Node top;
        Node pop() {
            if (top != null) {
                Object item = top.data;
                top = top.next;
                return item;
            }
            return null;
        }
        void push(Object item) {
            Node t = new Node(item);
            t.next = top;
            top = t;
        }
    }

## Implementing a Queue

    class Queue {
        Node first, last;
        void enqueue(Object item) {
            if (!first) {
                back = new Node(item);
                first = back;
            } else {
                back.next = new Node(item);
                back = back.next;
            }
        }
        Node deque(Node n) {
            if (front != null) {
                Object item = front.data;
                front = front.next;
                return item;
            }
            return null;
        }

    }

## Exercises
|No.|Title|Solution|
|---|-----|--------|
|3.1|[Use a single array to implement three stacks]()|[Java]()|
|3.2|[Stack with push, pop, min in O(1) time]()]|[Java]()|
|3.3|[Set of stacks, create a new stack once previous capacity]()|[Java]()|
|3.4|[Hanoi with stacks]()|[Java]()|
|3.5|[Implenting a queue using two stacks]()|[Java]()|
|3.6|[Sort a stack using push, pop, peak, isEmpty]()|[Java]()|
