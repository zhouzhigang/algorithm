---
title: "Linked Lists"
date: 2015-08-07
weight: 4
description: >
  Why, Kind Of Linked List, Basic Operation, List Problems
---

The linked list, a deceptively simple data structure, is the basis for a surprising number of problems regarding the handling of dynamic data.

Questions about effcient list traversal, list sorting, and the insertion or removal of data from either end of a list are good tests of basic data structure concepts.

## Why Linked Lists?

Linked list are useful to determine whether a candidate understands how pointers and references work, particularly in C and C++.

Linked list are so basic that you need to be familiar with them before moving to more complicated data structures.

## Kind of Linked List

There are three basic kinds of linked list:
* Singly Linked List
* Doubly Linked List
* Circular Linked List

### Singly Linked Lists

```c++
struct/class Node {
    Node    next;
    EleType data;
}
```

### Doubly Linked Lists


### Circular Linked Lists


## Basic Linked List Operations

### Tracking the Head Element

The head element of a singly linked list must always be tracked; otherwise, the list will be list - either garbage collected or leaked, depending on the language.

That means the pointer reference to the head of the list must be updated when a new element is inserted ahead of the first element or when the existing first element is removed from the list.

In Java, we can use return List to update the head.
In C, we can pass a pointer to the head pointer to update the head, and use return value to indicate the success or failure of the memory allocation(no exception in C).

### Traversing a List

When traversing, we must always check that we haven't reached the end of the list.

If didn't find the value in the list, it will return null.
The caller must detect an error condition by checking for a null return value.

**Note**: Always test for the end of a linked list as you traverse it.

### Inserting and Deleting Elements

Any insertion or deletion of elements in the middle of a list requires modification of the previous element's next pointer or reference.

**Note**: Deleteion of an element always requires at least two pointer variables.
Insertion requires two pointers as well, but because one of them is used for an element in the list and the other for the pointer returned by the memory allocation call, there's litte danger of forgetting this in the insertion case.

