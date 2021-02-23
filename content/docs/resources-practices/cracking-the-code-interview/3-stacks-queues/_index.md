---
title: "Stacks and Queues"
date: 2015-08-02
weight: 3
description: >
  Stacks and Queues
---

## Implementing as Stack

```java
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
```

## Implementing a Queue

```java
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
```
